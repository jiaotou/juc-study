package com.wushuang.alibaba;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 评测题目: 同时有N个商品（用long类型的商品id表示），每个商品都可以被任何一个用户（long类型的用户id）收藏，
 * 每被收藏一次，该商品的收藏数加1，同一个用户对同一个商品只能收藏一次。编辑写一个类，
 * 用3个方法提供以下功能（这3个方法都是在单机多线程环境下调用）：
 * 1）为指定的用户id收藏指定的商品id
 * 2) 返回所有商品的收藏总数
 * 3）根据商品ID返回这个商品的收藏数
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/6/20 14:08
 */
public class GoodsUtil {

    /**
     * 用户统计MAP(key为userId，value为goodId列表)
     */
    private volatile Map<Long, List<Long>> userMap = new ConcurrentHashMap<>(10);

    /**
     * 商品统计MAP(key为goodId，value为userId列表)
     */
    private volatile Map<Long, List<Long>> collectMap = new ConcurrentHashMap<>(10);

    private volatile AtomicLong collectCount = new AtomicLong();

    /**
     * 为指定的用户id收藏指定的商品id
     *
     * @param goodId 商品ID
     * @param userId 用户ID
     */
    public void collectGoodByGoodIdAndUserId(long goodId, long userId) {
        // 首先判断当前用户有没有收集和收集的商品ID
        if (userMap.containsKey(userId)) {
            List<Long> oldGoodIds = userMap.get(userId);
            if (oldGoodIds.size() > 0 && oldGoodIds.contains(goodId)) {
                System.out.println("当前用户已经收集过此商品");
                return;
            }
            oldGoodIds.add(userId);
            // 收藏成功,记录商品MAP,收藏总数加一
            userMap.put(userId, oldGoodIds);
            List<Long> goodIds = new CopyOnWriteArrayList<>();
            goodIds.add(userId);
            collectMap.put(goodId, goodIds);
            collectCount.getAndIncrement();
        } else {
            List<Long> longs = new CopyOnWriteArrayList<>();
            longs.add(goodId);
            userMap.put(userId, longs);
            List<Long> userIds = new CopyOnWriteArrayList<>();
            userIds.add(userId);
            collectMap.put(goodId, userIds);
            collectCount.getAndIncrement();
        }
    }

    /**
     * 返回所有商品的收藏总数
     *
     * @return
     */
    public long getCollectCount() {
        return collectCount.longValue();
    }

    /**
     * 根据商品ID返回这个商品的收藏数
     *
     * @param goodId
     * @return
     */
    public long getCollectCountByGoodId(long goodId) {
        List userIds = collectMap.get(goodId);
        if (null != userIds) {
            return userIds.size();
        }
        return 0;
    }

    public static void main(String[] args) {
        GoodsUtil goodsUtil = new GoodsUtil();
        for (int i = 0; i <= 10000; i++) {
            Thread s = new Thread(new Runnable() {
                @Override
                public void run() {
                    goodsUtil.collectGoodByGoodIdAndUserId(new Random().nextLong(), new Random().nextLong());
                }
            }, "Thread-" + i);
            s.start();
        }

        System.out.println("总数为" + goodsUtil.getCollectCount());
        System.out.println("总数为" + goodsUtil.getCollectCountByGoodId(new Random().nextLong()));

    }
}

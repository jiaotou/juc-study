package com.wushuang.algorithm;

import com.wushuang.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树层序遍历
 * 分析：使用深度优先遍历或者使用广度优先遍历
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/7/3 14:00
 */
public class TreeLevelOrderDemo {


    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        //用来存放最终结果
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, root, res);
        return res;
    }

    /**
     * 使用深度优先遍历实现层序遍历
     *
     * @param index 层次
     * @param root  跟节点
     * @param res   结果集
     */
    public static void dfs(int index, TreeNode root, List<List<Integer>> res) {
        //假设res是[ [1],[2,3] ]， index是3，就再插入一个空list放到res中
        if (res.size() < index) {
            res.add(new ArrayList<>());
        }
        //将当前节点的值加入到res中，index代表当前层，假设index是3，节点值是99
        //res是[ [1],[2,3] [4] ]，加入后res就变为 [ [1],[2,3] [4,99] ]
        res.get(index - 1).add(root.val);
        //递归的处理左子树,同时将层数index+1
        if (root.left != null) {
            dfs(index + 1, root.left, res);
        }
        // 递归的处理右子树，同时将层数index+1
        if (root.right != null) {
            dfs(index + 1, root.right, res);
        }
    }

}

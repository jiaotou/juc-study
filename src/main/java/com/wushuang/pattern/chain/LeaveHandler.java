package com.wushuang.pattern.chain;

/**
 * 请假接口
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/4/2 15:41
 */
public interface LeaveHandler {

    /**
     * 处理请假请求
     *
     * @param request
     */
    void handleRequest(LeaveRequest request);
}

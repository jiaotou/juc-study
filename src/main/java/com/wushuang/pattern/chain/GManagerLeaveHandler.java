package com.wushuang.pattern.chain;

/**
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/4/2 16:50
 */
public class GManagerLeaveHandler extends AbstractLeaveHandler {

    public GManagerLeaveHandler(String name) {
        this.handlerName = name;
    }

    /**
     * 处理请假请求
     *
     * @param request
     */
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() <= this.MAX) {
            System.out.println("总经理:" + handlerName + "已经处理,流程结束。");
            return;
        }
        if (null != this.nextHandler) {
            this.nextHandler.handleRequest(request);
        } else {
            System.out.println("审批拒绝！");
        }
    }
}

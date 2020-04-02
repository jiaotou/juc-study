package com.wushuang.pattern.chain;

/**
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/4/2 16:11
 */
public class DirectLeaderLeaveHandler extends AbstractLeaveHandler {

    public DirectLeaderLeaveHandler(String name) {
        this.handlerName = name;
    }

    /**
     * 处理请假请求
     *
     * @param request
     */
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() <= this.MIN) {
            System.out.println("直接主管:" + handlerName + "已经处理,流程结束。");
            return;
        } else {
            System.out.println("直接主管:" + handlerName + "已经处理,等待上级领导审批");
        }
        if (null != this.nextHandler) {
            this.nextHandler.handleRequest(request);
        } else {
            System.out.println("审批拒绝！");
        }
    }
}

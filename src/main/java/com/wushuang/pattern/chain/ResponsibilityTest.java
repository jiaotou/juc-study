package com.wushuang.pattern.chain;

/**
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/4/2 16:51
 */
public class ResponsibilityTest {

    public static void main(String[] args) {
        LeaveRequest request = new LeaveRequest();
        request.setLeaveDays(20);
        request.setName("藠头SSS");

        AbstractLeaveHandler directLeaderLeaveHandler = new DirectLeaderLeaveHandler("县令");
        DeptManagerLeaveHandler deptManagerLeaveHandler = new DeptManagerLeaveHandler("知府");
        GManagerLeaveHandler gManagerLeaveHandler = new GManagerLeaveHandler("京兆尹");

        directLeaderLeaveHandler.setNextHandler(deptManagerLeaveHandler);
        deptManagerLeaveHandler.setNextHandler(gManagerLeaveHandler);

        directLeaderLeaveHandler.handleRequest(request);
    }
}

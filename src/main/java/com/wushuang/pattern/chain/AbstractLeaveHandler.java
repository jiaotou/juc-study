package com.wushuang.pattern.chain;

/**
 * 请假处理抽象类
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/4/2 16:05
 */
public abstract class AbstractLeaveHandler implements LeaveHandler {

    /**
     * 直接主管审批处理的请假天数
     */
    protected int MIN = 1;

    /**
     * 部门经理处理的请假天数
     */
    protected int MIDDLE = 3;

    /**
     * 总经理处理的请假天数
     */
    protected int MAX = 30;

    /**
     * 领导名称
     */
    protected String handlerName;

    /**
     * 下一个处理节点（即更高级别的领导）
     */
    protected LeaveHandler nextHandler;

    protected void setNextHandler(AbstractLeaveHandler handler) {
        this.nextHandler = handler;
    }

}

package com.wushuang.pattern.chain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 请假请求对象
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/4/2 15:35
 */
@Data
@ToString
public class LeaveRequest implements Serializable {

    /**
     * 请假天数
     */
    private int leaveDays;

    /**
     * 请假人
     */
    private String name;
}

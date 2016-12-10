package com.activiti.entity;

/**
 * ClassName: BillStatus
 * Description: 请假单状态
 * Date: 2016/7/21 16:28
 *
 * @author SAM SHO
 * @version V1.0
 */
public enum BillStatus {

    INIT("初始录入"), APPROVE("审批中"), FINISH("完成");

    private String desc;

    BillStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}

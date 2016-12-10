package com.activiti.bean;

/**
 * ClassName: ActType
 * Description:
 * Date: 2016/7/22 10:49
 *
 * @author SAM SHO
 * @version V1.0
 */
public enum ActType {

    LEAVEBILL("请假单"), PROCESS("流程定义");

    private String desc;

    ActType(String desc) {
        this.desc = desc;
    }

    String getDesc() {
        return desc;
    }


}

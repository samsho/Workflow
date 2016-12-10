package com.activiti.entity;

/**
 * ClassName: Sex
 * Description:
 * Date: 2016/7/18 20:58
 *
 * @author SAM SHO
 * @version V1.0
 */
public enum Sex {
    MAN("男"), WOMEN("女");

    String value;

    Sex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}

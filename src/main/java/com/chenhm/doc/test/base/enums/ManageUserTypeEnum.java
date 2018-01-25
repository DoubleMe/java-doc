package com.chenhm.doc.test.base.enums;

/**
 * @author chen-hongmin
 * @since 2017/11/30 14:32
 */

public enum ManageUserTypeEnum {

    HOSPITAL(0, "医院"), SUPPLIER(1, "供应商");

    final private Integer type;

    final private String desc;

    ManageUserTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}

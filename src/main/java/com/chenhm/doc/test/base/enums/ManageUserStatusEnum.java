package com.chenhm.doc.test.base.enums;

/**
 * @author chen-hongmin
 * @since 2017/11/30 14:32
 */
public enum ManageUserStatusEnum {

    ACTIVE(1, "正常"), DISABLED(0, "禁用");

    final private Integer type;

    final private String desc;

    ManageUserStatusEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static ManageUserStatusEnum getEnum(Integer type){

        for (ManageUserStatusEnum typeEnum : values()){
            if (typeEnum.type.equals(type)){
                return typeEnum;
            }
        }
        return null;
    }
}

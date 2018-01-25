package com.chenhm.doc.test.base.enums;

/**
 * @author chen-hongmin
 * @since 2017/11/30 9:51
 */
public enum HospitalTypeEnum {

    FIRST(1, "一级医院"), SECOND(2, "二级医院"), three(3, "三级医院"), PRIVATE(99, "民营医院");

    final private Integer type;

    final private String desc;

    HospitalTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static HospitalTypeEnum getEnum(Integer type){

        for (HospitalTypeEnum typeEnum : values()){
            if (typeEnum.type.equals(type)){
                return typeEnum;
            }
        }
        return null;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}

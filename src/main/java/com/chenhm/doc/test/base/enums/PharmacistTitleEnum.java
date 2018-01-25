package com.chenhm.doc.test.base.enums;

/**
 * @author chen-hongmin
 * @since 2017/11/30 10:23
 */
public enum PharmacistTitleEnum {

    ASSISTANT_PHARMACIST(1, "药士"),

    PHARMACIST(2, "药师"),

    HEAD_PHARMACIST(3, "主管药师"),

    DEPUTY_CHIEF_PHARMACIST(4, "副主任药师"),

    CHIEF_PHARMACIST(5, "主任药师");

    final private Integer type;

    final private String desc;

    PharmacistTitleEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static PharmacistTitleEnum getEnum(Integer type){

        for (PharmacistTitleEnum typeEnum : values()){
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

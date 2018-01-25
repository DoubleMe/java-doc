package com.chenhm.doc.test.base.enums;

/**
 * @author chen-hongmin
 * @since 2017/11/30 9:51
 */
public enum SupplierTypeEnum {

    WHOLESALE_BUSINESS(1, "批发企业"), RETAIL_BUSINESS(2, "零售企业"), PRODUCE_BUSINESS(3, "生产企业");

    final private Integer type;

    final private String desc;

    SupplierTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static SupplierTypeEnum getEnum(Integer type){

        for (SupplierTypeEnum typeEnum : values()){
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

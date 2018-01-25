package com.chenhm.doc.test.pharmacist.dto;


import com.chenhm.doc.test.base.query.PageQuery;

/**
 * @author chen-hongmin
 * @since 2017/11/30 10:54
 */
public class PharmacistQuery extends PageQuery {

    /**
     * 药师姓名（支持左模糊）
     */
    private String name;

    /**
     * 供应商ID
     */
    private String supplierId;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 药师职称
     */
    private Integer title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }
}

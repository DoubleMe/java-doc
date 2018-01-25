package com.chenhm.doc.test.hospital.dto;


import com.chenhm.doc.test.Param;
import com.chenhm.doc.test.base.query.PageQuery;

import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/11/30 10:40
 */
public class HospitalQuery extends PageQuery {

    /**
     * 医院名称 （支持左模糊）
     */
    private String hospitalName;

    /**
     * 供应商名称 （支持左模糊）
     */
    private String supplierName;

    /**
     * 医院类型
     * @note 全部传 -1
     */
    private Integer type;

    /**
     * 测试用一下
     */
    private List<Param> params;

    /**
     * 证书内容
     */
    private byte[] certificate;

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Param> getParams() {
        return params;
    }

    public void setParams(List<Param> params) {
        this.params = params;
    }

    public byte[] getCertificate() {
        return certificate;
    }

    public void setCertificate(byte[] certificate) {
        this.certificate = certificate;
    }
}

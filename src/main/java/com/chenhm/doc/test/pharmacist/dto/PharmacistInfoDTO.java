package com.chenhm.doc.test.pharmacist.dto;


import com.chenhm.doc.test.base.enums.PharmacistTitleEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chen-hongmin
 * @since 2017/11/29 17:41
 */
public class PharmacistInfoDTO implements Serializable {

    /**
     * 药师ID
     */
    private Long userId;

    /**
     * 药师UUID
     */
    private String pharmacistId;

    /**
     * 药师姓名
     */
    private String pharmacistName;

    /**
     * 所属供应商id
     */
    private String supplierId;

    /**
     * 所属供应商
     */
    private String supplierName;

    /**
     * 药师手机号
     */
    private String mobile;

    /**
     * 药师身份证号
     */
    private String idCard;

    /**
     * 药师职称
     */
    private PharmacistTitleEnum title;

    /**
     * 资格证书图像代码
     */
    private String credentialsPath;

    /**
     * 注册证书图像代码
     */
    private String registeredPath;
    /**
     * 注册证书有效时间
     */
    private Date registeredDate;

    /**
     * 操作员标志（GOPS 登录账号）
     */
    private String operator;

    public String getPharmacistId() {
        return pharmacistId;
    }

    public void setPharmacistId(String pharmacistId) {
        this.pharmacistId = pharmacistId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getPharmacistName() {
        return pharmacistName;
    }

    public void setPharmacistName(String pharmacistName) {
        this.pharmacistName = pharmacistName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public PharmacistTitleEnum getTitle() {
        return title;
    }

    public void setTitle(PharmacistTitleEnum title) {
        this.title = title;
    }

    public String getCredentialsPath() {
        return credentialsPath;
    }

    public void setCredentialsPath(String credentialsPath) {
        this.credentialsPath = credentialsPath;
    }

    public String getRegisteredPath() {
        return registeredPath;
    }

    public void setRegisteredPath(String registeredPath) {
        this.registeredPath = registeredPath;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}

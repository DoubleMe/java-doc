package com.chenhm.doc.test.pharmacist.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 药师电子证书表
 * @author chen-hongmin
 */
public class PharmacistCertificateDTO  implements Serializable{


    /**
     * 药师UID
     */
    private String pharmacistId;

    /**
     * 药师姓名
     */
    private String pharmacistName;

    /**
     * 证书内容
     */
    private byte[] certificate;

    /**
     * 证书密码
     */
    private String password;

    /**
     * 生效起始时间
     */
    private Date effectiveTime;

    /**
     * 失效时间
     */
    private Date expiredTime;

    /**
     * 算法
     */
    private String algorithm;

    /**
     * 是否吊销 0吊销，1正常
     */
    private Integer certStatus;

    /**
     * 证书序号
     */
    private String certNumber;

    /**
     * 证书提供者
     */
    private Integer provider;

    /**
     * 证书类型,p12,cer
     */
    private String certSuffix;

    public String getPharmacistId() {
        return pharmacistId;
    }

    public void setPharmacistId(String pharmacistId) {
        this.pharmacistId = pharmacistId;
    }

    public String getPharmacistName() {
        return pharmacistName;
    }

    public void setPharmacistName(String pharmacistName) {
        this.pharmacistName = pharmacistName;
    }

    public byte[] getCertificate() {
        return certificate;
    }

    public void setCertificate(byte[] certificate) {
        this.certificate = certificate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public Integer getCertStatus() {
        return certStatus;
    }

    public void setCertStatus(Integer certStatus) {
        this.certStatus = certStatus;
    }

    public String getCertNumber() {
        return certNumber;
    }

    public void setCertNumber(String certNumber) {
        this.certNumber = certNumber;
    }

    public Integer getProvider() {
        return provider;
    }

    public void setProvider(Integer provider) {
        this.provider = provider;
    }

    public String getCertSuffix() {
        return certSuffix;
    }

    public void setCertSuffix(String certSuffix) {
        this.certSuffix = certSuffix;
    }
}
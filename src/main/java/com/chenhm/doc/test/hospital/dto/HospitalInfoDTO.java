package com.chenhm.doc.test.hospital.dto;


import com.chenhm.doc.test.base.enums.HospitalTypeEnum;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 医院信息传输对象
 * @author chen-hongmin
 * @since 2017/11/29 17:38
 */
public class HospitalInfoDTO implements Serializable {


    /**
     * 微医医院ID
     */
    private String hospitalId;
    /**
     * 证书内容
     */
    private byte[] certificate;

    /**
     * 医院名称
     */
    private String hospitalName;

    /**
     * 医院类型，3 三级，2 二级 ，1 一级，99 民营
     */
    private HospitalTypeEnum hospitalType;

    /**
     * 省代码
     */
    private Integer provinceId;

    /**
     * 省名称
     */
    private String provinceName;

    /**
     * 城市代码
     */
    private Integer cityId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 区代码
     */
    private Integer districtId;

    /**
     * 区名称
     */
    private String districtName;

    /**
     * 医院地址
     */
    private String address;

    /**
     * 医院Logo code
     */
    private String logo;

    /**
     * 医院信息简介
     */
    private String introduction;

    /**
     * 医院负责人
     */
    private String master;

    /**
     * 医院负责人电话
     */
    private String masterMobile;

    /**
     * 供应商UUID
     */
    private List<String> supplierIds;

    /**
     * 医院机构代码图片的代码
     */
    private String orgCodePath;

    /**
     * 医院机构代码时间
     */
    private Date orgCodeDate;

    /**
     * 医院营业执照图片代码
     */
    private String licencePath;

    /**
     * 医院营业执照时间
     */
    private Date licenceDate;

    /**
     * 医联经营许可图片
     */
    private String permitPath;

    /**
     * 特许经营时间
     */
    private Date permitDate;

    /**
     * 操作员标志（GOPS 登录账号）
     */
    private String operator;

    /**
     * 管理员账号
     */
    private String managerAccount;

    /**
     * 管理员手机号
     */
    private String managerMobile;

    /**
     * 供应商信息集合
     */
    private List<SupplierSimpleInfoDTO> supplierInfoList;

    /**
     * 创建时间
     */
    private Date gmtCreated;


    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public HospitalTypeEnum getHospitalType() {
        return hospitalType;
    }

    public void setHospitalType(HospitalTypeEnum hospitalType) {
        this.hospitalType = hospitalType;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getMasterMobile() {
        return masterMobile;
    }

    public void setMasterMobile(String masterMobile) {
        this.masterMobile = masterMobile;
    }

    public List<String> getSupplierIds() {
        return supplierIds;
    }

    public void setSupplierIds(List<String> supplierIds) {
        this.supplierIds = supplierIds;
    }

    public String getOrgCodePath() {
        return orgCodePath;
    }

    public void setOrgCodePath(String orgCodePath) {
        this.orgCodePath = orgCodePath;
    }

    public Date getOrgCodeDate() {
        return orgCodeDate;
    }

    public void setOrgCodeDate(Date orgCodeDate) {
        this.orgCodeDate = orgCodeDate;
    }

    public String getLicencePath() {
        return licencePath;
    }

    public void setLicencePath(String licencePath) {
        this.licencePath = licencePath;
    }

    public Date getLicenceDate() {
        return licenceDate;
    }

    public void setLicenceDate(Date licenceDate) {
        this.licenceDate = licenceDate;
    }

    public String getPermitPath() {
        return permitPath;
    }

    public void setPermitPath(String permitPath) {
        this.permitPath = permitPath;
    }

    public Date getPermitDate() {
        return permitDate;
    }

    public void setPermitDate(Date permitDate) {
        this.permitDate = permitDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getManagerAccount() {
        return managerAccount;
    }

    public void setManagerAccount(String managerAccount) {
        this.managerAccount = managerAccount;
    }

    public String getManagerMobile() {
        return managerMobile;
    }

    public void setManagerMobile(String managerMobile) {
        this.managerMobile = managerMobile;
    }

    public List<SupplierSimpleInfoDTO> getSupplierInfoList() {
        return supplierInfoList;
    }

    public void setSupplierInfoList(List<SupplierSimpleInfoDTO> supplierInfoList) {
        this.supplierInfoList = supplierInfoList;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public byte[] getCertificate() {
        return certificate;
    }

    public void setCertificate(byte[] certificate) {
        this.certificate = certificate;
    }
}

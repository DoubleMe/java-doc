package com.chenhm.doc.test.hospital.dto;

import java.io.Serializable;

/**
 * @author chen-hongmin
 * @since 2017/12/2 14:25
 */
public class SupplierSimpleInfoDTO implements Serializable {

    /**
     * 供应商Id
     */
    private String supplierId;

    /**
     * 供应商名称
     */
    private String supplierName;

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}

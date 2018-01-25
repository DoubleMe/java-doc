package com.chenhm.doc.test.pharmacist.dto;

/**
 *
 * 药师信息 含有证书信息
 * @author chen-hongmin
 * @since 2017/12/28 15:46
 */
public class PharmacistInfoDetailDTO extends PharmacistInfoDTO {

    /**
     * 药师证书信息
     */
    private PharmacistCertificateDTO pharmacistCertificateDTO;

    public PharmacistCertificateDTO getPharmacistCertificateDTO() {
        return pharmacistCertificateDTO;
    }

    public void setPharmacistCertificateDTO(PharmacistCertificateDTO pharmacistCertificateDTO) {
        this.pharmacistCertificateDTO = pharmacistCertificateDTO;
    }
}

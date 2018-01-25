package com.chenhm.doc.test.pharmacist;


import com.chenhm.doc.test.base.response.PageResponseDTO;
import com.chenhm.doc.test.base.response.ResponseDTO;
import com.chenhm.doc.test.pharmacist.dto.PharmacistInfoDTO;
import com.chenhm.doc.test.pharmacist.dto.PharmacistInfoDetailDTO;
import com.chenhm.doc.test.pharmacist.dto.PharmacistQuery;

/**
 * 药师管理service
 * @author chen-hongmin
 * @since 2017/11/29 17:41
 */
public interface PharmacistInfoService {

    /**
     * 列表查询
     * @param query 查询参数
     * @return List<EnterprisePharmacistInfoDTO>
     */
    PageResponseDTO<PharmacistInfoDTO> list(PharmacistQuery query);
    /**
     * 新增
     *
     * @param pharmacistInfo
     * @return
     */
    ResponseDTO<Long> insert(PharmacistInfoDTO pharmacistInfo);

    /**
     * 更新
     *
     * @param pharmacistInfo
     * @return
     */
    ResponseDTO<Long> update(PharmacistInfoDTO pharmacistInfo);

    /**
     * 主键查询
     *
     * @param pharmacistId 药师UUID
     * @return EnterprisePharmacistInfoDTO
     */
    ResponseDTO<PharmacistInfoDetailDTO> getByPharmacistId(String pharmacistId);

    /**
     * 根据主键删除
     *
     * @param pharmacistId 药师UUID
     * @param operator 操作员登录账号
     * @return
     */
    ResponseDTO<Integer> delByPharmacistId(String pharmacistId, String operator);


}

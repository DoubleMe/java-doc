package com.chenhm.doc.test.hospital;


import com.chenhm.doc.test.base.response.PageResponseDTO;
import com.chenhm.doc.test.base.response.ResponseDTO;
import com.chenhm.doc.test.hospital.dto.HospitalInfoDTO;
import com.chenhm.doc.test.hospital.dto.HospitalQuery;

/**
 * 医院管理service
 * @author chen-hongmin
 * @since 2017/11/29 17:38
 */
public interface HospitalInfoService {

    /**
     * 列表查询
     *
     * @param query 查询参数
     * @return PageResponseDTO<HospitalInfoDTO>
     */
    PageResponseDTO<HospitalInfoDTO> list(HospitalQuery query);

    /**
     * 新增
     *
     * @param hospitalInfo 医院信息
     * @return ResponseDTO 主键
     */
    ResponseDTO<String> insert(HospitalInfoDTO hospitalInfo);

    /**
     * 更新
     *
     * @param hospitalInfo 医院信息
     * @return ResponseDTO 主键
     */
    ResponseDTO<String> update(HospitalInfoDTO hospitalInfo);

    /**
     * 主键查询
     *
     * @param hospitalId 医院信息
     * @return ResponseDTO<HospitalInfoDO>
     */
    ResponseDTO<HospitalInfoDTO> getByHospitalId(String hospitalId);



}

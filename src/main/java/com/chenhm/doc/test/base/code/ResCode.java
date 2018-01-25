package com.chenhm.doc.test.base.code;

/**
 * 响应码接口
 *
 * @author zhaogg
 * @created 2016年7月23日 上午11:03:11
 */
public interface ResCode {

    /**
     * 获取响应码
     * 
     * @return
     */
    int getCode();

    /**
     * 获取响应说明
     * 
     * @return
     */
    String getMessage();

}

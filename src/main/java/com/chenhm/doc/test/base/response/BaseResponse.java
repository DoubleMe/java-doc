package com.chenhm.doc.test.base.response;


import com.chenhm.doc.test.base.code.BaseResCode;

import java.io.Serializable;

/**
 * 基本接口响应
 *
 * @author zhaogg
 * @created 2016年7月23日 下午3:35:27
 */
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = 1651315356564808195L;

    /**
     * 响应码
     */
    private int code;

    /**
     * 响应说明
     */
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return code == BaseResCode.SUCCESS.getCode();
    }

    public void setResult(int code, String message) {

        this.code = code;
        this.message = message;
    }

}

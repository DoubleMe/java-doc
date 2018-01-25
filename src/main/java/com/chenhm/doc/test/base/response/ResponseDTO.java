package com.chenhm.doc.test.base.response;

/**
 * 一般接口响应
 *
 * @author zhaogg
 * @created 2016年7月23日 上午11:00:01
 */
public class ResponseDTO<T> extends BaseResponse {

    private static final long serialVersionUID = 858435791573181866L;

    /**
     * 响应数据
     */
    private T data;

    public ResponseDTO() {

    }

    public ResponseDTO(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

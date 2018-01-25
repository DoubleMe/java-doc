package com.chenhm.doc.test.base.code;

/**
 *
 * @author zhaogg
 * @created 2016年7月23日 上午10:56:16
 */
public enum BaseResCode implements ResCode {

    // 0-99 系统响应码

    /**
     * 0-处理成功
     */
    SUCCESS(0, "处理成功"),

    /**
     * 1-处理失败
     */
    FAIL(1, "处理失败"),

    /**
     * 2-系统异常
     */
    SYSTEM_ERROR(2, "系统异常"),

    /**
     * 3-非法参数
     */
    ILLEGAL_PARAMS(3, "非法参数"),

    /**
     * 4-参数超出规定大小或者长度
     */
    PARAMS_BOUND(4, "参数超出规定大小或者长度"),;

    /**
     * 响应码
     */
    final private int code;

    /**
     * 响应说明
     */
    final private String message;

    private BaseResCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}

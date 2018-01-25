package com.chenhm.doc.formatter;

/**
 * @author chen-hongmin
 * @since 2017/12/15 16:36
 */
public interface Formatter<T> {

    /**
     * 格式化
     * @param t
     * @return
     */
    String format(T t);
}

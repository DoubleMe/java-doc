package com.chenhm.doc.filter;

/**
 * @author chen-hongmin
 * @since 2017/12/19 13:53
 */
public interface Filter<T> {

    /**
     * 参数过滤
     * @param t 参数
     * @return
     */
    boolean filter(T t);
}

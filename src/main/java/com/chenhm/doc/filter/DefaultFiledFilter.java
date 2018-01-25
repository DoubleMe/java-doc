package com.chenhm.doc.filter;

import com.sun.javadoc.FieldDoc;

/**
 * @author chen-hongmin
 * @since 2017/12/19 13:56
 */
public class DefaultFiledFilter implements Filter<FieldDoc> {

    @Override
    public boolean filter(FieldDoc fieldDoc) {
        return true;
    }
}

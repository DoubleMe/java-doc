package com.chenhm.doc.filter;

import com.sun.javadoc.MethodDoc;

/**
 * @author chen-hongmin
 * @since 2017/12/19 13:55
 */
public class DefaultMethodFilter implements Filter<MethodDoc> {

    @Override
    public boolean filter(MethodDoc methodDoc) {


        if (methodDoc.isPrivate()){
            return false;
        }
        return true;
    }
}

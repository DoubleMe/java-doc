package com.chenhm.doc;

import com.sun.javadoc.ClassDoc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen-hongmin
 * @since 2017/12/16 16:49
 */
public class ClassDocHolder {

    public static Map<String, ClassDoc> docMap = new HashMap<>();

    public static ClassDoc getClassDoc(String key) {
        return docMap.get(key);
    }

    public static void putClassDoc(String key, ClassDoc classDoc) {
        docMap.put(key, classDoc);
    }
}

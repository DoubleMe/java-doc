package com.chenhm.doc;


import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.Doclet;
import com.sun.javadoc.RootDoc;

/**
 * @author chen-hongmin
 * @since 2017/12/14 17:52
 */
public class CommonDoc extends Doclet {


    /**
     * @param root
     * @return
     */
    public static boolean start(RootDoc root) {
        buildDoc(root.classes());
        return true;
    }

    /**
     * 创建文档
     *
     * @param classDocs 文档集合
     */
    private static void buildDoc(ClassDoc[] classDocs) {

        for (ClassDoc classDoc : classDocs) {
            System.out.println(classDoc.name());
            ClassDocHolder.putClassDoc(classDoc.qualifiedTypeName(),classDoc);
        }

    }




}

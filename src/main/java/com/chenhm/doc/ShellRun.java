package com.chenhm.doc;

/**
 * @author chen-hongmin
 * @since 2017/12/15 16:50
 */
public class ShellRun {

    public static void main(String[] args) {

        String project = "D:/github/doc/src/main/java/";
        String packageName = "com.chenhm.doc.test";


        DocMain.defaultDoc().run(project, packageName,"Service","D:\\com\\chenhm\\doc");


    }


}

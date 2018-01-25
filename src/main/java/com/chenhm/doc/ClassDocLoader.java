package com.chenhm.doc;

/**
 * @author chen-hongmin
 * @since 2017/12/19 13:39
 */
public class ClassDocLoader {

    private static final String DOCLET = "-doclet";


    /**
     * 默认生成某个类的文档
     *
     * @param sourcePath  D:/github/doc/src/main/java/
     * @param packageName 包名
     */
    public static void documentDOC(String sourcePath, String packageName) {

        packageName = packageName.replaceAll("/", "\\.");
        String[] docArgs = new String[]{"-private",DOCLET, CommonDoc.class.getName(), "-sourcepath", sourcePath,packageName};
        com.sun.tools.javadoc.Main.execute(docArgs);
    }

    public static void help() {

        String[] docArgs = new String[]{"-help"};
        com.sun.tools.javadoc.Main.execute(docArgs);
    }

    /**
     * 默认生成文档
     *
     * @param projectPath 工程路径 D:\github\doc\src\main\java
     * @param typeName    java类的全路径
     */
    public static void docByPath(String projectPath, String typeName) {

        String classPath = projectPath + typeName.replaceAll("\\.", "/") + ".java";

        String[] docArgs = new String[]{DOCLET, CommonDoc.class.getName(), classPath};
        com.sun.tools.javadoc.Main.execute(docArgs);
    }

    public static void main(String[] args) {
        help();

//        docByPath("src",List.class.getName());
    }
}

package com.chenhm.doc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chen-hongmin
 * @since 2018/1/22 16:55
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {


        String packageName = "com/chenhm/doc/test";

        List<String> fileNames = getFileName(packageName);
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        String pack = packageName.replaceAll("/", "\\.");

        List<Class> list = new ArrayList<>(fileNames.size());
        for (String fileName : fileNames){

            String substring = fileName.substring(0, fileName.length() - 6);
            Class<?> aClass = classLoader.loadClass(pack + "." + substring);
            list.add(aClass);
        }

        System.out.println(list);
    }

    public static List<String> getFileName(String packageName) {

        String filePath = ClassLoader.getSystemResource("").getPath() + packageName;
        String subFilePath = filePath.substring(1, filePath.length());

        List<String> paths = new ArrayList<>();

        // 路径
        File f = new File(subFilePath);
        if (!f.exists()) {
            System.out.println(subFilePath + " not exists");
            return paths;
        }

        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isDirectory()) {
                System.out.println(fs.getName() + " [目录]");
            } else {
                paths.add(fs.getName());
                System.out.println(fs.getName());
            }
        }

        return paths;
    }

}

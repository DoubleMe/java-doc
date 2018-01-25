package com.chenhm.doc.util;

import com.chenhm.doc.formatter.html.HtmlFormatter;
import com.chenhm.doc.object.DocClassModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author chen-hongmin
 * @since 2018/1/24 11:24
 */
public class FileUtils {

    /**
     * 保存文件
     *
     * @param docModel
     */
    public static void saveFile(DocClassModel docModel,String source) {

        HtmlFormatter formatter = new HtmlFormatter();
        String format = formatter.format(docModel);

        File doc = getDirectory(source);
        writeFile(doc, format, docModel.getName());
    }

    /**
     * 输出文件
     * 没有文件夹创建
     * 文件已存在则覆盖
     */
    public static void writeFile(File targetFile, String source, String fileName) {


        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        String file = fileName + ".html";
        try {
            File directory = new File(targetFile, file);
            fos = new FileOutputStream(directory, false);
            osw = new OutputStreamWriter(fos, "utf-8");
            bw = new BufferedWriter(osw);
            bw.write(source);
            bw.flush();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fos.close();
                osw.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }

    /**
     * 获取文件路径
     *
     * @return
     */
    public static File getDirectory(String souce) {

        File project = new File(souce);
        if (!project.isDirectory()) {
            boolean rc = project.mkdirs();
            if (!rc) {
                throw new RuntimeException("" + project.getAbsolutePath());
            }
        }

        return project;
    }

    /**
     * 获取文件路径
     *
     * @return
     */
    public static void getSubPackage(String root, String targetPackage, List<String> subPkgList) {


        String path = root + targetPackage;
        File rootFile = new File(path);
        //不是包
        if (!rootFile.isDirectory()) {
            return;
        }
        File[] files = rootFile.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                String subPkg = targetPackage + "/" + file.getName();
                subPkgList.add(subPkg);
                getSubPackage(root, subPkg, subPkgList);
            }
        }

    }
}

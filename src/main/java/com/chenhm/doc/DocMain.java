package com.chenhm.doc;

import com.chenhm.doc.formatter.Formatter;
import com.chenhm.doc.formatter.html.HtmlFormatter;
import com.chenhm.doc.object.DocClassModel;
import com.chenhm.doc.util.ClassUtils;
import com.chenhm.doc.util.DocUtils;
import com.chenhm.doc.util.FileUtils;

import java.io.File;
import java.util.*;

/**
 * @author chen-hongmin
 * @since 2018/1/24 11:25
 */
public class DocMain {

    private Formatter formatter;

    private DocMain(Formatter formatter) {
        this.formatter = formatter;
    }

    public static DocMain newInstance(Formatter formatter) {
        DocMain docMain = new DocMain(formatter);

        return docMain;
    }

    public static DocMain defaultDoc() {
        DocMain docMain = new DocMain(new HtmlFormatter());

        return docMain;
    }


    public void run(String project, String packageName, String regex, String sourcePath) {

        List<String> classPaths = new ArrayList<>();
        ClassUtils.getClassTypeNameList(project, packageName, true, classPaths);

        List<Class> list = ClassUtils.classList(classPaths);

        Map<String, Class> map = new HashMap<>();
        list.forEach(data -> {
            ClassUtils.relationClass(data, map);
        });

        List<String> subPkgList = new ArrayList<>();


        packageName = packageName.replaceAll("\\.", "/");
        subPkgList.add(packageName);
        FileUtils.getSubPackage(project, packageName, subPkgList);

        subPkgList.forEach(pkg -> {
            ClassDocLoader.documentDOC(project, pkg);
        });


        for (Class cls : list) {
            String className = cls.getSimpleName();

            if (className.endsWith(regex)) {
                DocClassModel docClassModel = DocUtils.buildClassDoc(ClassDocHolder.getClassDoc(cls.getName()), map, null);

                saveFile(docClassModel, sourcePath);
            }
        }
    }

    private void saveFile(DocClassModel docClassModel, String sourcePath) {

        String format = formatter.format(docClassModel);

        File doc = FileUtils.getDirectory(sourcePath);
        FileUtils.writeFile(doc, format, docClassModel.getName());
    }

}

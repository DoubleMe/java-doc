package com.chenhm.doc.object;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/12/15 15:28
 */
public class DocClassModel {

    /**
     * 类名 简略名
     */
    private String name;

    /**
     * 类注释
     */
    private String classDoc;


    /**
     * 是否有泛型
     */
    private boolean hasGeneric;

    /**
     * 是否是枚举
     */
    private boolean isEnum;

    /**
     * 泛型
     */
    private DocClassModel genericType;

    /**
     * 作者
     */
    private String author;

    /**
     * 版本
     */
    private String version;

    /**
     * 类创建日期
     */
    private String date;

    /**
     * 方法列表
     */
    private List<DocMethodModel> methods;

    /**
     * 参数列表
     */
    private List<DocFieldModel> fieldModels;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassDoc() {
        return classDoc;
    }

    public void setClassDoc(String classDoc) {
        this.classDoc = classDoc;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<DocMethodModel> getMethods() {
        return methods;
    }

    public void setMethods(List<DocMethodModel> methods) {
        this.methods = methods;
    }

    public boolean isHasGeneric() {
        return hasGeneric;
    }

    public void setHasGeneric(boolean hasGeneric) {
        this.hasGeneric = hasGeneric;
    }

    public boolean isEnum() {
        return isEnum;
    }

    public void setEnum(boolean anEnum) {
        isEnum = anEnum;
    }

    public DocClassModel getGenericType() {
        return genericType;
    }

    public void setGenericType(DocClassModel genericType) {
        this.genericType = genericType;
    }

    public void addMethod(DocMethodModel methodModel) {

        if (methods == null) {
            methods = new ArrayList<>();
        }
        methods.add(methodModel);
    }

    public void addFiled(DocFieldModel docFieldModel) {

        if (fieldModels == null) {
            fieldModels = new ArrayList<>();
        }
        fieldModels.add(docFieldModel);
    }

    public List<DocFieldModel> getFieldModels() {
        return fieldModels;
    }

    public void setFieldModels(List<DocFieldModel> fieldModels) {
        this.fieldModels = fieldModels;
    }

    @Override
    public String toString() {
        return "DocClassModel{" +
                "name='" + name + '\'' +
                ", classDoc='" + classDoc + '\'' +
                ", author='" + author + '\'' +
                ", version='" + version + '\'' +
                ", date='" + date + '\'' +
                ", methods=" + methods +
                '}';
    }
}

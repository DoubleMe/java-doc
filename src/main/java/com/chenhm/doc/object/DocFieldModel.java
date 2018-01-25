package com.chenhm.doc.object;

/**
 * @author chen-hongmin
 * @since 2017/12/15 15:28
 */
public class DocFieldModel {

    /**
     * 类名 简略名
     */
    private String filedName;

    /**
     * 字段注释
     */
    private String filedDoc;

    /**
     * 字段类型
     */
    private String typeName;

    /**
     * 字段简单类型
     */
    private String simpleTypeName;

    /**
     * 不是简单类型 迭代获取参数类型
     */
    private DocClassModel classModel;

    /**
     * 泛型
     */
    private DocClassModel genericType;

    /**
     * 示例
     */
    private String sample;

    /**
     * 说明
     */
    private String desc;

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }

    public String getFiledDoc() {
        return filedDoc;
    }

    public void setFiledDoc(String filedDoc) {
        this.filedDoc = filedDoc;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public DocClassModel getClassModel() {
        return classModel;
    }

    public void setClassModel(DocClassModel classModel) {
        this.classModel = classModel;
    }

    public String getSimpleTypeName() {
        return simpleTypeName;
    }

    public void setSimpleTypeName(String simpleTypeName) {
        this.simpleTypeName = simpleTypeName;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public DocClassModel getGenericType() {
        return genericType;
    }

    public void setGenericType(DocClassModel genericType) {
        this.genericType = genericType;
    }

    @Override
    public String toString() {
        return "DocFieldModel{" +
                "filedName='" + filedName + '\'' +
                ", filedDoc='" + filedDoc + '\'' +
                ", typeName='" + typeName + '\'' +
                ", classModel=" + classModel +
                '}';
    }
}

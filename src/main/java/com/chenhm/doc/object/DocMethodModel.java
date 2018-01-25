package com.chenhm.doc.object;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/12/15 15:28
 */
public class DocMethodModel {

    /**
     * 类名 简略名
     */
    private String methodName;

    /**
     * 类注释
     */
    private String methodDoc;

    /**
     * 返回类型
     */
    private DocClassModel returnType;

    /**
     * 参数列表
     */
    private List<DocFieldModel> parameters;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodDoc() {
        return methodDoc;
    }

    public void setMethodDoc(String methodDoc) {
        this.methodDoc = methodDoc;
    }

    public List<DocFieldModel> getParameters() {
        return parameters;
    }

    public void setParameters(List<DocFieldModel> parameters) {
        this.parameters = parameters;
    }

    public void addParameter(DocFieldModel docFieldModel){

        if (parameters == null){
            parameters = new ArrayList<>();
        }
        parameters.add(docFieldModel);
    }

    public DocClassModel getReturnType() {
        return returnType;
    }

    public void setReturnType(DocClassModel returnType) {
        this.returnType = returnType;
    }

    @Override
    public String toString() {
        return "DocMethodModel{" +
                "methodName='" + methodName + '\'' +
                ", methodDoc='" + methodDoc + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}

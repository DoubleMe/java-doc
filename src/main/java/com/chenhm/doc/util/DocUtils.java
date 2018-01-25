package com.chenhm.doc.util;

import com.chenhm.doc.ClassDocHolder;
import com.chenhm.doc.filter.DefaultMethodFilter;
import com.chenhm.doc.object.DocClassModel;
import com.chenhm.doc.object.DocFieldModel;
import com.chenhm.doc.object.DocMethodModel;
import com.chenhm.doc.test.Param;
import com.chenhm.doc.type.JavaType;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.Parameter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author chen-hongmin
 * @date 2017/12/15 14:15
 * @since V1.0
 */
public class DocUtils {

    /**
     * 添加类信息
     *
     * @param classDoc
     * @param map         类信息集合
     * @param genericName 泛型名称
     */
    public static DocClassModel buildClassDoc(ClassDoc classDoc, Map<String, Class> map, String genericName) {

        DocClassModel docModel = new DocClassModel();
        if (classDoc == null) {
            return docModel;
        }
        String qualifiedTypeName = classDoc.qualifiedTypeName();
        String rawCommentText = classDoc.getRawCommentText();
        String commentText = classDoc.commentText();

        docModel.setClassDoc(commentText);
        docModel.setAuthor(RawCommentUtils.getValue(rawCommentText, "author"));
        docModel.setVersion(RawCommentUtils.getValue(rawCommentText, "since"));
        docModel.setDate(RawCommentUtils.getValue(rawCommentText, "date"));
        docModel.setName(classDoc.name());

        Class cls = map.get(qualifiedTypeName);
        if (JavaType.isJavaType(qualifiedTypeName) || cls.isEnum()) {
            docModel.setEnum(cls.isEnum());
            return docModel;
        }

        buildFiledDoc(docModel, classDoc.fields(false), cls, map, genericName);

        MethodDoc[] methods = classDoc.methods(false);
        if (methods.length > 0) {
            for (int i = 0; i < methods.length; i++) {
                DefaultMethodFilter filter = new DefaultMethodFilter();
                if (filter.filter(methods[i])) {

                    buildMethodDoc(docModel, methods[i], getMethod(methods[i], cls), map);
                }
            }
        }
        return docModel;
    }

    /**
     * @param docModel
     * @param fields
     * @param cls
     * @param map
     * @param genericName 泛型名称
     */
    public static void buildFiledDoc(DocClassModel docModel, FieldDoc[] fields, Class cls, Map<String, Class> map, String genericName) {

        if (fields != null && fields.length > 0) {
            for (FieldDoc fieldDoc : fields) {

                String typeName = fieldDoc.type().qualifiedTypeName();
                String filedName = fieldDoc.name();
                Class aClass = map.get(typeName);

                boolean effectiveField = effectiveField(filedName, cls, false);
                if (!effectiveField) {
                    continue;
                }

                DocFieldModel docFieldModel = new DocFieldModel();
                String commentText1 = fieldDoc.commentText();
                //是普通类型
                docFieldModel.setFiledName(fieldDoc.name());
                docFieldModel.setSimpleTypeName(fieldDoc.type().typeName());
                docFieldModel.setTypeName(typeName);
                docFieldModel.setFiledDoc(commentText1);
                Field field = ClassUtils.getField(fieldDoc.name(), cls);
                //字段有泛型
                if (ClassUtils.fieldHasGenericType(field)) {
                    typeName = ClassUtils.fieldGenericType(field);
                    if ("T".equals(typeName) || "E".equals(typeName) || "K".equals(typeName) || "V".equals(typeName)) {
                        typeName = genericName;
                    }
                }
                //复杂类型
                if (aClass != null && !JavaType.isJavaType(typeName) && !aClass.isEnum()) {

                    ClassDoc filedClass = ClassDocHolder.getClassDoc(typeName);
                    DocClassModel docClassModel = buildClassDoc(filedClass, map, null);
                    docFieldModel.setClassModel(docClassModel);
                }

                docModel.addFiled(docFieldModel);
            }
        }
    }


    public static void buildMethodDoc(DocClassModel docModel, MethodDoc methodDoc, Method method, Map<String, Class> map) {

        DocMethodModel docMethodModel = new DocMethodModel();
        if (method == null){
            return;
        }

        //方法的返回参数
        String qualifiedTypeName = methodDoc.returnType().qualifiedTypeName();


        //缓存中获取classDoc 信息
        ClassDoc returnType = ClassDocHolder.getClassDoc(qualifiedTypeName);

        DocClassModel returnTypeModel = buildClassDoc(returnType, map, ClassUtils.methodGenericType(method));

        docMethodModel.setReturnType(returnTypeModel);

        String commentText = methodDoc.commentText();
        String rawCommentText = methodDoc.getRawCommentText();
        docMethodModel.setMethodDoc(commentText);
        docMethodModel.setMethodName(methodDoc.name());

        Parameter[] parameters = methodDoc.parameters();
        if (parameters.length > 0) {
            for (int i = 0; i < parameters.length; i++) {

                DocFieldModel docFieldModel = new DocFieldModel();

                String typeName = parameterTypeName(i, method);
                docFieldModel.setFiledName(parameters[i].name());
                docFieldModel.setSimpleTypeName(parameters[i].typeName());
                docFieldModel.setTypeName(typeName);
                docFieldModel.setFiledDoc(RawCommentUtils.getParam(rawCommentText, parameters[i].name()));
                //复杂类型
                if (!JavaType.isJavaType(typeName)) {
                    ClassDoc filedClass = ClassDocHolder.getClassDoc(typeName);
                    DocClassModel docClassModel = buildClassDoc(filedClass, map, null);
                    docFieldModel.setClassModel(docClassModel);
                }
                docMethodModel.addParameter(docFieldModel);
            }
        }

        docModel.addMethod(docMethodModel);
    }


    /**
     * 获取参数的泛型
     *
     * @param i
     * @param method
     * @return
     */
    private static String parameterTypeName(int i, Method method) {

        Type[] genericParameterTypes = method.getGenericParameterTypes();

        return ClassUtils.genericTypeName(genericParameterTypes[i]);
    }

    /**
     * 有效字段 必须要在类中有get方法
     *
     * @param fieldName
     * @param cls
     * @return
     */
    private static boolean effectiveField(String fieldName, Class cls, boolean isBoolean) {

        String methodName = StringUtils.getGetterMethodName(fieldName, isBoolean);
        try {
            cls.getMethod(methodName, null);
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    private static Method getMethod(MethodDoc methodDoc, Class cls) {

        Method[] methods = cls.getMethods();

        for (Method method : methods) {
            if (!method.getName().equals(methodDoc.name())) {
                continue;
            }
            String name = method.getReturnType().getName();

            if (!JavaType.changeType(name).equals(methodDoc.returnType().qualifiedTypeName())) {
                continue;
            }
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length != methodDoc.parameters().length) {
                continue;
            }

            boolean sameParameter = true;
            Parameter[] parameters = methodDoc.parameters();
            for (int i = 0; i < parameters.length; i++) {
                if (!parameters[i].type().qualifiedTypeName().equals(parameterTypes[i].getName())) {
                    sameParameter = false;
                }
            }
            if (!sameParameter) {
                continue;
            }
            return method;
        }
        return null;
    }

    public static void main(String[] args) throws Exception {

        boolean param = effectiveField("test", Param.class, false);
        System.out.println(param);
    }


}

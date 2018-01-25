package com.chenhm.doc.util;

import com.chenhm.doc.test.DocTest;
import com.chenhm.doc.type.JavaType;

import java.io.File;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author chen-hongmin
 * @since 2017/12/16 17:08
 */
public class ClassUtils {

    /**
     * 获取一个类的全部关联类
     *
     * @param clazz
     * @param map
     */
    public static void relationClass(Class clazz, Map<String, Class> map) {

        if (map.containsKey(clazz.getName())) {
            return;
        }
        if (JavaType.isJavaType(clazz.getName())) {
            return;
        }
        map.put(clazz.getName(), clazz);


        Field[] fields = clazz.getDeclaredFields();
        if (fields == null) {
            return;
        }

        for (Field field : fields) {

            Class<?> type = field.getType();
            String typeName = type.getName();

            newClassAndAddCache(typeName, map);

            if (fieldHasGenericType(field)) {
                typeName = fieldGenericType(field);
                newClassAndAddCache(typeName, map);
            }


        }

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {

            Class<?> returnType1 = method.getReturnType();

            map.put(returnType1.getName(), returnType1);
            if (!returnType1.isPrimitive()) {
                relationClass(returnType1, map);
            }
            String returnType = methodGenericType(method);
            newClassAndAddCache(returnType, map);

            Class<?>[] parameterTypes = method.getParameterTypes();
            Type[] genericParameterTypes = method.getGenericParameterTypes();

            for (int i = 0; i < parameterTypes.length; i++) {

                if (!parameterTypes[i].isPrimitive()) {
                    relationClass(parameterTypes[i], map);
                }

                //参数有泛型
                if (genericParameterTypes[i] instanceof ParameterizedType) {
                    String typeName = genericTypeName(genericParameterTypes[i]);
                    newClassAndAddCache(typeName, map);
                }

            }

        }
    }

    private static Class newClassAndAddCache(String typeName, Map<String, Class> map) {

        if (JavaType.isJavaType(typeName)) {
            return null;
        }
        try {
            Class<?> forName = Class.forName(typeName);
            if (!forName.isPrimitive()) {
                relationClass(forName, map);
            }

            return forName;
        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        }

        return null;
    }

    /**
     * 获取包下所有的类的typeName
     *
     * @param packageName 包名 com.chenhm.doc
     * @param recursive   是否递归查询
     * @param classPaths  结果集合
     */
    public static void getClassTypeNameList(String path, String packageName, boolean recursive, List<String> classPaths) {

        String filePath = path + packageName.replaceAll("\\.", "/");

        classTypeNameList(filePath, packageName, recursive, classPaths);


    }

    /**
     * 获取包下所有的类的typeName
     *
     * @param fileName    文件名 全路径
     * @param packageName 包名
     * @param recursive   是否递归查询
     * @param classPaths  结果集合
     */
    public static void classTypeNameList(String fileName, String packageName, boolean recursive, List<String> classPaths) {

        // 路径
        File rootFile = new File(fileName);
        if (!rootFile.exists()) {
            System.out.println(fileName + " not exists");
            return;
        }

        //子类文件
        File[] files = rootFile.listFiles();
        for (File file : files) {

            if (file.isDirectory() && recursive) {
                classTypeNameList(file.getPath(), packageName + "." + file.getName(), recursive, classPaths);
            }
            if (!file.isDirectory() && file.getName().endsWith(".java")) {
                String simpleTypeName = file.getName().substring(0, file.getName().length() - 5);
                String typeName = packageName + "." + simpleTypeName;
                classPaths.add(typeName);
            }
        }
    }

    /**
     * 获取class列表
     *
     * @param typeNames
     * @return
     */
    public static List<Class> classList(List<String> typeNames) {

        List<Class> classes = new ArrayList<>(typeNames.size());
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        for (String typeName : typeNames) {
            try {
                Class<?> aClass = classLoader.loadClass(typeName);
                classes.add(aClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return classes;
    }

    /**
     * class 是否是list
     *
     * @param cls
     * @return
     */
    public static boolean isList(Class cls) {

        if (cls.isAssignableFrom(List.class) || cls.isAssignableFrom(ArrayList.class)) {
            return true;
        }
        return false;
    }

    /**
     * typeName 是否是list
     *
     * @param typeName
     * @return
     */
    public static boolean isList(String typeName) {

        if (JavaType.isJavaType(typeName)) {
            return false;
        }
        try {

            Class<?> aClass = Class.forName(typeName);

            return isList(aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return false;
    }

    /**
     * 获取field 的泛型
     *
     * @param field
     * @return genericType
     */
    public static String fieldGenericType(Field field) {

        return genericTypeName(field.getGenericType());
    }

    /**
     * 获取field 的泛型
     *
     * @param field
     * @return genericType
     */
    public static boolean fieldHasGenericType(Field field) {

        if (field.getGenericType() instanceof ParameterizedType) {
            return true;
        }
        if (field.getGenericType() instanceof TypeVariable) {
            return true;
        }
        return false;
    }

    /**
     * 获取field 的泛型
     *
     * @param method
     * @return genericType
     */
    public static boolean methodHasGenericType(Method method) {

        if (method.getGenericReturnType() instanceof ParameterizedType) {
            return true;
        }
        if (method.getGenericReturnType() instanceof TypeVariable) {
            return true;
        }
        return false;
    }

    /**
     * 获取method 的泛型
     *
     * @param method
     * @return genericType
     */
    public static String methodGenericType(Method method) {

        if (method == null) {
            return null;
        }
        return genericTypeName(method.getGenericReturnType());
    }

    /**
     * 获取method 的泛型
     *
     * @param type
     * @return genericType
     */
    public static String genericTypeName(Type type) {

        String typeName = "";
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            Type generic = pt.getActualTypeArguments()[0];
            typeName = generic.toString();
        } else {
            typeName = type.toString();
        }


        return typeName.replaceAll("class", "").trim();
    }

    public static Field getField(String field, Class cls) {

        try {
            Field declaredField = cls.getDeclaredField(field);
            return declaredField;
        } catch (NoSuchFieldException e) {
            return null;
        }
    }


    public static void main(String[] args) throws Exception {

        Field field = DocTest.class.getDeclaredField("name");
        String aClass = fieldGenericType(field);
        System.out.println(aClass);

        Method out = DocTest.class.getMethod("setParams", List.class);
        String type = methodGenericType(out);

        System.out.println(type);

    }

    public static void outPath() throws Exception {


    }


}

package com.chenhm.doc.type;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chen-hongmin
 * @since 2017/12/16 14:24
 */
public class JavaType {

    protected static Map<String, String> typeMap = new HashMap<>();

    protected static Map<String, String> changeMap = new HashMap<>();

    static {
        typeMap.put(Integer.class.getName(),"");
        typeMap.put(Long.class.getName(),"");
        typeMap.put(Boolean.class.getName(),"");
        typeMap.put(Date.class.getName(),"");
        typeMap.put(String.class.getName(),"");
        typeMap.put(Double.class.getName(),"");
        typeMap.put(BigDecimal.class.getName(),"");
        typeMap.put(Float.class.getName(),"");
        typeMap.put(Byte.class.getName(),"");
        typeMap.put(Short.class.getName(),"");
        typeMap.put("int","");
        typeMap.put("long","");
        typeMap.put("void","");
        typeMap.put("boolean","");

        changeMap.put("[Z","boolean");
        changeMap.put("[B","byte");
        changeMap.put("[S","short");
        changeMap.put("[I","int");
        changeMap.put("[J","long");
        changeMap.put("[F","double");
        changeMap.put("[D","long");
        changeMap.put("[C","char");

    }

    public static boolean isJavaType(String javaType){
        if (javaType == null || javaType.length() == 0){
            return true;
        }

        return typeMap.containsKey(javaType);
    }

    public static String changeType(String javaType){
       if (changeMap.containsKey(javaType)){
           return changeMap.get(javaType);
       }

        return javaType;
    }
}

package com.chenhm.doc.util;

/**
 * @author chen-hongmin
 * @since 2017/12/15 15:53
 */
public class RawCommentUtils {

    /**
     * 获取注释信息
     * @param source
     * @param target
     * @return
     */
    public static String getValue(String source , String target){

        String[] split = source.split("@");

        for (String str : split){
            if (str.startsWith(target)){
                return str.replace(target,"").trim();
            }
        }

        return null;
    }

    /**
     * 获取注释信息
     * @param source
     * @param paramName
     * @return
     */
    public static String getParam(String source , String paramName){

        String[] split = source.split("@");

        for (String str : split){
            int indexOf = str.indexOf("param");
            if (indexOf == -1){
                continue;
            }
            String substring = str.replaceFirst("param","");
            if (substring.trim().startsWith(paramName)){
                return substring.replace(paramName,"").trim();
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String a = "@author chen-hongmin\n" +
                " @since 2017/12/15 13:54";
        getValue(a, "author");
    }
}

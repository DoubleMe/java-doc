package com.chenhm.doc.util;

/**
 * @author chen-hongmin
 * @since 2018/1/23 17:03
 */
public class StringUtils {

    /**
     *
     * @param name
     * @return
     */
    public static String firstToLowerCase(String name) {

        char[] cs = name.toCharArray();
        cs[0] += 32;
        return String.valueOf(cs);

    }

    /**
     * Computes a getter method name.  Warning - does not check to see that the property is a valid
     * property.  Call getValidPropertyName first.
     *
     * @param property the property
     * @return the getter method name
     */
    public static String getGetterMethodName(String property, boolean isBoolean) {

        StringBuilder sb = new StringBuilder();

        sb.append(property);
        if (Character.isLowerCase(sb.charAt(0))) {
            if (sb.length() == 1 || !Character.isUpperCase(sb.charAt(1))) {
                sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            }
        }

        if (isBoolean) {
            sb.insert(0, "is");
        } else {
            sb.insert(0, "get");
        }

        return sb.toString();
    }
}

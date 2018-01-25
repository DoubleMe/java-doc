package com.chenhm.doc.util;

import com.chenhm.doc.formatter.html.*;

import java.util.Map;
import java.util.Set;

/**
 * @author chen-hongmin
 * @since 2017/12/18 9:23
 */
public class HtmlUtils {

    /**
     * 创建一个标签
     *
     * @param tag
     * @return
     */
    public static String createTag(DocumentTag tag) {

        StringBuffer sb = new StringBuffer();
        sb.append("<").append(tag.getName());
        sb.append(attr(tag));
        sb.append(">");
        sb.append(tag.getText());
        sb.append("</").append(tag.getName()).append(">");
        return sb.toString();
    }



    /**
     * 创建一个table
     *
     * @param table
     * @return
     */
    public static String createTable(DocumentTable table) {

        StringBuffer sb = new StringBuffer();
        sb.append("<table ");
        sb.append(attr(table));
        sb.append(">");


        for (DocumentTR tr : table.getTrs()) {

            sb.append(createTR(tr));
        }
        sb.append("</table>");

        return sb.toString();
    }

    /**
     * 创建一个tr
     *
     * @param tr
     * @return
     */
    public static String createTR(DocumentTR tr) {

        StringBuffer sb = new StringBuffer();
        sb.append("<tr");
        sb.append(attr(tr));
        sb.append(">");
        for (DocumentTD td : tr.getTds()) {
            sb.append(createTag(td));
        }
        sb.append("</tr>");
        return sb.toString();
    }

    /**
     * 添加样式
     *
     * @param attribute
     * @return
     */
    private static String attr(DocumentAttribute attribute) {

        StringBuffer sb = new StringBuffer();
        Set<Map.Entry<String, String>> entries = attribute.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            sb.append(" ").append(entry.getKey()).append("=").append("\"").append(entry.getValue()).append("\" ");
        }

        return sb.toString();
    }


}

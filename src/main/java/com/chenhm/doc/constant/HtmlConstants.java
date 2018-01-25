package com.chenhm.doc.constant;

/**
 * @author chen-hongmin
 * @since 2017/12/16 13:27
 */
public interface HtmlConstants {


    /**
     * 工程根目录
     */
    String PROJECT_PATH = "D:/github/study/doc/src/main/java";

    /**
     * HTML 头部
     */
    String HTML_HEADER = "<!doctype html>\n" +
            "<html>\n" +
            "<head>\n" +
            "<meta charset=\"utf-8\">\n" +
            "<title>问卷列表</title>";



    /**
     * HTML table样式
     */
    String HTML_CSS = "<style>\n" +
            ".border-table {   \n" +
            "    border-collapse: collapse;   \n" +
            "    border: none;   \n" +
            "    font-weight: normal;\n" +
            "    font-size: 12pt;\n" +
            "    \n" +
            "\n" +
            "}   \n" +
            ".border-table td {   \n" +
            "\t    border:1px solid #d6dae6; \n" +
            "\t    padding:6px; \n" +
            "\t    line-height:22px;\n" +
            "}   \n" +
            "</style>";
    /**
     * BODY 头部
     */
    String BODY_HEADER = "<body>";

    /**
     * BODY 尾部
     */
    String BODY_TAIL = "</body>";

    /**
     * HTML 尾部
     */
    String HTML_TAIL = "</html>";
}

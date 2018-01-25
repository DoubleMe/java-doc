package com.chenhm.doc.formatter.html;

/**
 * @author chen-hongmin
 * @since 2017/12/20 12:11
 */
public class DocumentTag extends DocumentAttribute {

    /**
     * tag name
     */
    private String name;

    /**
     * tag value
     */
    private String text;

    public DocumentTag() {
    }

    public DocumentTag(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

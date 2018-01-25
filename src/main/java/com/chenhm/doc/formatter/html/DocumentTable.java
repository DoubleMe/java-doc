package com.chenhm.doc.formatter.html;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/12/20 12:08
 */
public class DocumentTable extends DocumentTag {

    /**
     * tr 集合
     */
    private List<DocumentTR> trs;

    public DocumentTable() {
        super.put("class", "border-table");
    }
    public DocumentTable(List<DocumentTR> trs) {
        this.trs = trs;
        super.put("class", "border-table");
    }

    public void addTitle(DocumentTR documentTR) {
        if (trs == null) {
            trs = new ArrayList<>();
        }
        trs.add(0, documentTR);
    }

    public void addTr(DocumentTR documentTR) {
        if (trs == null) {
            trs = new ArrayList<>();
        }
        trs.add(documentTR);
    }

    public List<DocumentTR> getTrs() {
        return trs;
    }

    public void setTrs(List<DocumentTR> trs) {
        this.trs = trs;
    }
}

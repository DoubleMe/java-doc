package com.chenhm.doc.formatter.html;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/12/20 11:30
 */
public class DocumentTR extends DocumentTag{


    /**
     * td 集合
     */
    private List<DocumentTD> tds;

    public DocumentTR() {
        this.tds = new ArrayList<>();
    }
    public DocumentTR(List<DocumentTD> tds) {
        this.tds = tds;
    }

    public List<DocumentTD> getTds() {
        return tds;
    }

    public void setTds(List<DocumentTD> tds) {
        this.tds = tds;
    }

    public void addTd(DocumentTD td){

        if (tds == null){
            tds = new ArrayList<>();
        }
        tds.add(td);
    }
    
}

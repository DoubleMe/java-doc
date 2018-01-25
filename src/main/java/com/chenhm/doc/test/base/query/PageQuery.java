package com.chenhm.doc.test.base.query;

/**
 * @author chen-hongmin
 * @since 2017/11/30 10:43
 */
public class PageQuery extends BaseQuery {

    /**
     * 当前页码 默认1
     */
    private int pageNo;

    /**
     * 每页条数 默认10
     */
    private int pageSize;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

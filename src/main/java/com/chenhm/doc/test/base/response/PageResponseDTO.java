package com.chenhm.doc.test.base.response;

import java.util.List;

/**
 * 页数分页响应结果
 *
 * @author zhaogg
 * @created 2016年7月23日 上午11:20:11
 */
public class PageResponseDTO<T> extends BaseResponse {

    private static final long serialVersionUID = -1041754735579863952L;

    /**
     * 响应数据
     */
    private List<T> data;

    /**
     * 当前页码，第一页，pageNo=1
     */
    private int pageNo;

    /**
     * 每页条数
     */
    private int pageSize;

    /**
     * 总数量
     */
    private int totalCount;

    public PageResponseDTO() {

    }

    public void setPageResult(int pageNo, int pageSize, int totalCount) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

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

    public int getTotalPage() {
        if (pageSize == 0) {
            return 0;
        }
        return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}

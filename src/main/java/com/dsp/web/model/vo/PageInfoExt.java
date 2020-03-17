package com.dsp.web.model.vo;


import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/3.
 */

public class PageInfoExt  implements Serializable {
    private int pageSize;
    private int currentPage;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}

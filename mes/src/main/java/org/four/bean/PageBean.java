package org.four.bean;

public class PageBean {
    private int total;
    private int pageTotal;
    private int pages;
    private int pageCurrent;

    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageTotal() {
        return pageTotal;
    }
    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {

        if(total%pageTotal==0)
            pages = total/pageTotal;
        else
            pages = total/pageTotal+1;

        this.pages = pages;
    }

    public int getPageCurrent() {
        return pageCurrent;
    }
    public void setUdes(int pageCurrent) {
        this.pageCurrent = pageCurrent;
    }
}
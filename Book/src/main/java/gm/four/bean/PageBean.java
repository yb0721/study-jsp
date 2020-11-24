package gm.four.bean;

public class PageBean {
    // used for SQL select 
    // Generally character in that table as for bean's variable
    // Generally names are same

    private int total;
    private int pageTotal; //every page's rows
    private int pages; //total pages
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
        if (total % pageTotal == 0) {
            pages = total / pageTotal;
        } else {
            pages = (total / pageTotal) + 1;
        }
        return pages;
    }
    // public void setPages(int pages) {
    //     //total pages = total rows / every page's total rows
        
    //     this.pages = pages;
    // }

    public int getPageCurrent() {
        return pageCurrent;
    }
    public void setPageCurrent(int pageCurrent) {
        this.pageCurrent = pageCurrent;
    }
}
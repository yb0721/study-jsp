package gm.four.bean;

public class BookBean {
    // used for SQL select 
    // Generally character in that table as for bean's variable
    // Generally names are same

    private String id;
    private String bookname;
    private String bookauthor;
    private String bookdes;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookauthor() {
        return bookauthor;
    }
    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public String getBookdes() {
        return bookdes;
    }
    public void setBookdes(String bookdes) {
        this.bookdes = bookdes;
    }
}
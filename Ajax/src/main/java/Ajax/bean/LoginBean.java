package Ajax.bean;

public class LoginBean {
    //表bean的私有属性一般和表字段相同
    //个数，类型，名字相同
    private int uid;
    private String uname;
    private String upwd;
    private String udes;
    private String uimg;

    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }
    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUdes() {
        return udes;
    }
    public void setUdes(String udes) {
        this.udes = udes;
    }

    public String getUimg() {
        return uimg;
    }
    public void setUimg(String uimg) {
        this.uimg = uimg;
    }
}
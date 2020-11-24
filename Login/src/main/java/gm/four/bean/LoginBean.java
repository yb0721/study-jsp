package gm.four.bean;

public class LoginBean {
    public LoginBean() {}

    private String uid;
    private String uname;
    private String upwd;
    private String udes;

    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
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
}
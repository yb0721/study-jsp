package org.four.bean;

public class LoginBean {
    private int uid;
    private String uname;
    private String upwd;
    private String udes;
    private String uimg;

    public String getUimg() {
        return uimg;
    }

    public void setUimg(String uimg) {
        this.uimg = uimg;
    }
    
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
}
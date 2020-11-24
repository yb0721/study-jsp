package gm.four.dao;

import  gm.four.bean.*;

public class AreasDao {

    public AreasDao() {}

    public AreasBean are(AreasBean cb) {
        int c;
        
        c = cb.getA() * cb.getB();
        cb.setC(c);

        return cb;
    }

}
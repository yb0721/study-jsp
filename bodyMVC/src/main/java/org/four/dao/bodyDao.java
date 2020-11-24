package org.four.dao;

import org.four.bean.*;

public class bodyDao {
    public bodyDao(){}

    public bodyBean mes(bodyBean bd) {

        double weight = 0.0;
        String mess = "";
        String sex = "";

        if (sex.equals(bd.getWoman())) {
            weight = ( bd.getH() - 70) * 0.6;

            if (weight < bd.getW()) {
                mess = "Too fat";
            } else if (weight > bd.getW()) {
                mess = "Too thin";
            } else {
                mess = "Standard";
            }
        }

        if (sex.equals(bd.getMan())) {
            weight = (bd.getH() - 80) * 0.7;

            if (weight < bd.getW()) {
                mess = "Too fat";
            } else if (weight > bd.getW()) {
              mess = "Too thin";
            }
            else {
              mess = "Standard";
            }
          }
        bd.setMess(mess);
        return bd;
    }

}
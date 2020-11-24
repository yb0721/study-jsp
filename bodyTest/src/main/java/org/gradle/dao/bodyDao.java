package org.gradle.dao;

public class bodyDao {
    public bodyDao(){}

    public String mes(String sex, double h, double w, double weight, String mess, String woman, String man) {
        if(sex.equals(woman)) {
            weight = ( h - 70) * 0.6;
            
            if(weight < w) {
                mess = "Too fat";
            }
            else if(weight > w) {
                mess = "Too thin";
            }
            else {
                mess = "Standard";
            }
          }
  
          if(sex.equals(man)) {
            weight = (h - 80) * 0.7;
  
            if(weight < w) {
              mess = "Too fat";
            }
            else if(weight > w) {
              mess = "Too thin";
            }
            else {
              mess = "Standard";
            }
          }
        return mess;
    }

}
package com.raitcon.hibernate.backbean;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mike
 */
import java.io.Serializable;
import java.util.List;

public class Model  implements Serializable {
    
     private static  final  long serialVersionUID=-2178912760546575078L;
    private String value1;
   
 
    private List<ItemDetail>  listDetail;
 
    public Model(String value1){
        this.value1 = value1;
      
    }
 
    public String getValue1() {
        return value1;
    }
 
    public void setValue1(String value1) {
        this.value1 = value1;
    }
 
   
 
    public List<ItemDetail> getListDetail() {
        return listDetail;
    }
 
    public void setListDetail(List<ItemDetail> listDetail) {
        this.listDetail = listDetail;
    }
    
}

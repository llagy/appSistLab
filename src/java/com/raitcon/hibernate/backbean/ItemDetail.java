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
public class ItemDetail implements Serializable {
    
    private static  final  long serialVersionUID=-2178612760546575078L;
    private String itemValue;
    
    private String pageName;

    
    public ItemDetail(String itemValue, String  pageName){
        this.itemValue = itemValue;
        this.pageName=pageName;
    }
    
    /**
     * @return the itemVlue
     */
    public String getItemValue() {
        return itemValue;
    }

    /**
     * @param itemValue the itemVlue to set
     */
    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    /**
     * @return the pageName
     */
    public String getPageName() {
        return pageName;
    }

    /**
     * @param pageName the pageName to set
     */
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
    
}

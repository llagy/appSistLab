/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;

import com.raitcon.hibernate.bean.Ocupacion;
import com.raitcon.hibernate.db.OcupacionDB;
import com.raitcon.hibernate.db.PersonalDB;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Miki Lap
 */
@ManagedBean(name = "ocupacionBean")
@ViewScoped
public class OcupacionBean implements Serializable {

private static final long serialVersionUID = -2377612760546575078L; 
    
    private List<Ocupacion> listOcupacion;

    public List<Ocupacion> getListOcupacion() {
        return listOcupacion;
    }

    public void setListOcupacion(List<Ocupacion> listOcupacion) {
        this.listOcupacion = listOcupacion;
    }
    
   
    public void listOcupacionAll() {
        listOcupacion = null;
        OcupacionDB ocupacionDB = new OcupacionDB();
        listOcupacion = ocupacionDB.getOcupacionAll();
    }
    
}

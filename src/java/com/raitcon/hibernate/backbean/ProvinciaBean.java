/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;

import com.raitcon.hibernate.bean.Provincia;
import com.raitcon.hibernate.db.ProvinciaDB;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Mike Lap
 */

@ManagedBean(name = "provinciaBean")
@ViewScoped

public class ProvinciaBean implements Serializable {
    
     private static final long serialVersionUID = -2377612760546575078L;
     private Integer idProvincia;
     private String descProv;
     private List<Provincia> listProvincia;
     private String mensaje;
     private Integer idDpto;

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getDescProv() {
        return descProv;
    }

    public void setDescProv(String descProv) {
        this.descProv = descProv;
    }

    public Integer getIdDpto() {
        return idDpto;
    }

    public void setIdDpto(Integer idDpto) {
        this.idDpto = idDpto;
    }
    
    

    public List<Provincia> getListProvincia() {
        return listProvincia;
    }

    public void setListProvincia(List<Provincia> listProvincia) {
        this.listProvincia = listProvincia;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
     
     public void listProvinciaAll() {
        listProvincia = null;
        ProvinciaDB provinciaDB = new ProvinciaDB();
        listProvincia = provinciaDB.getProvinciaAll();
    }
     
     public void listProvinciaByIdDpto(){
        System.out.println("listProvinciaByIdDpto->idDpto:"+idDpto);
        listProvincia = null;
        ProvinciaDB provinciaDB = new ProvinciaDB();
        listProvincia = provinciaDB.getProvinciaByIdDepa(idDpto);
         
     }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;

import com.raitcon.hibernate.bean.Distrito;
import com.raitcon.hibernate.db.DistritoDB;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Mike Lap
 */
@ManagedBean(name = "distritoBean")
@ViewScoped
public class DistritoBean implements Serializable{
   
    
     private static final long serialVersionUID = -2377612760546575078L;
     private Integer idProvincia;
     private Integer idDistrito;
     private List<Distrito> listDistrito;
     private String mensaje;
    

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Integer getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Integer idDistrito) {
        this.idDistrito = idDistrito;
    }

    public List<Distrito> getListDistrito() {
        return listDistrito;
    }

    public void setListDistrito(List<Distrito> listDistrito) {
        this.listDistrito = listDistrito;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
     
     public void listProvinciaAll() {
        listDistrito = null;
        DistritoDB distritoDB = new DistritoDB();
        listDistrito = distritoDB.getDistritoAll();
    }
     
     public void listDistritoByIdProv(){
        System.out.println("listDistritoByIdProv->idProvincia:"+idProvincia);
        listDistrito = null;
        DistritoDB distritoDB = new DistritoDB();
        listDistrito = distritoDB.getDistritoByIdProv(idProvincia);
         
     }
}

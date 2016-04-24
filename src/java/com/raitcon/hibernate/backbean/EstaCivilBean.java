/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;


import com.raitcon.hibernate.bean.Estacivil;
import com.raitcon.hibernate.db.EstaCivilDB;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author mriverar
 */
@ManagedBean(name = "estaCivilBean")
@ViewScoped
public class EstaCivilBean implements Serializable {
    private static final long serialVersionUID = -2377612760546575078L;
    private Integer codEstaCivil;
    private String descripcion;
    private List<Estacivil> listEstaCivil;
    private String mensaje;

    public Integer getCodEstaCivil() {
        return codEstaCivil;
    }

    public void setCodEstaCivil(Integer codEstaCivil) {
        this.codEstaCivil = codEstaCivil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Estacivil> getListEstaCivil() {
        return listEstaCivil;
    }

    public void setListEstaCivil(List<Estacivil> listEstaCivil) {
        this.listEstaCivil = listEstaCivil;
    }

      
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    public void listEstaCivilAll() {
        listEstaCivil = null;
        EstaCivilDB estaCivilDB = new EstaCivilDB();
        listEstaCivil = estaCivilDB.getEstaCivilAll();
    }
    
    
    public void pintarFrmEstaCivil() {

        System.out.println("Código Estado Civil: " + codEstaCivil);
        Estacivil estaCivil = null;
        EstaCivilDB departamentoDB = new EstaCivilDB();
        estaCivil = departamentoDB.getEstaCivilById(codEstaCivil);
        
        if(estaCivil != null){
            this.codEstaCivil = estaCivil.getCodEstacivil();
            this.descripcion = estaCivil.getDescripcion();
          }
     }
}

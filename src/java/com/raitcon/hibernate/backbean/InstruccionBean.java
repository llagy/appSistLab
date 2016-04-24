/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;

import com.raitcon.hibernate.bean.Instruccion;
import com.raitcon.hibernate.db.EstaCivilDB;
import com.raitcon.hibernate.db.InstruccionDB;
import java.io.Serializable;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author mriverar
 */
@ManagedBean(name = "instruccionBean")
@ViewScoped
public class InstruccionBean implements Serializable {
    
     private static final long serialVersionUID = -2377612760546575088L;
    protected static Logger log = Logger.getLogger(InstruccionBean.class); 
    private int idInstruccion;
    private String descripcion;
    private List<Instruccion> listInstruccion;

    public int getIdInstruccion() {
        return idInstruccion;
    }

    public void setIdInstruccion(int idInstruccion) {
        this.idInstruccion = idInstruccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Instruccion> getListInstruccion() {
        return listInstruccion;
    }

    public void setListInstruccion(List<Instruccion> listInstruccion) {
        this.listInstruccion = listInstruccion;
    }
    
     public void listInstruccionAll() {
        listInstruccion = null;
        InstruccionDB instruccionDB = new InstruccionDB();
        listInstruccion = instruccionDB.getInstruccionAll();
    }
    
}

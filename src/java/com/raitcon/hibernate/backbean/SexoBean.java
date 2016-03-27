/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;

import com.raitcon.hibernate.bean.Sexo;
import com.raitcon.hibernate.db.SexoDB;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Guillermo Lap
 */
@ManagedBean(name = "sexoBean")
@ViewScoped
public class SexoBean implements Serializable {

private static final long serialVersionUID = -2377612760546575079L;    
private Character codSexo;  
private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
private List<Sexo>listSexo;

    public Character getCodSexo() {
        return codSexo;
    }

    public void setCodSexo(Character codSexo) {
        this.codSexo = codSexo;
    }

    public List<Sexo> getListSexo() {
        return listSexo;
    }

    public void setListSexo(List<Sexo> listSexo) {
        this.listSexo = listSexo;
    }
    
    
    
    public void listSexoAll() {
        listSexo = null;
        SexoDB sexoDB = new SexoDB();
        listSexo = sexoDB.getSexoAll();
    }
    
    
    
    public void pintarFormSex() {

        System.out.println("codigo sexo: " + codSexo);
        Sexo sex = null;
        List<Sexo> listSexo;
        SexoDB sexDB = new SexoDB();
        listSexo = sexDB.getSexoByCod(codSexo);
        for (Sexo alumno : listSexo) {
            sex = alumno;
        }
        if(sex != null){
        this.codSexo = sex.getCodSexo();
         this.descripcion = sex.getDescripcion();
        }
        

    }
}

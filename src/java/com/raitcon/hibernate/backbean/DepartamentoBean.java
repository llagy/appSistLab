/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;

import com.raitcon.hibernate.bean.Departamento;
import com.raitcon.hibernate.db.DepartamentoDB;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Mike Lap
 */
@ManagedBean(name = "departamentoBean")
@ViewScoped
public class DepartamentoBean implements Serializable {
    private static final long serialVersionUID = -2377612760546575078L;
    private Integer idDepartamento;
    private String descDpto;
    private List<Departamento> listDpto;
    private String mensaje;

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDescDpto() {
        return descDpto;
    }

    public void setDescDpto(String descDpto) {
        this.descDpto = descDpto;
    }

    public List<Departamento> getListDpto() {
        return listDpto;
    }

    public void setListDpto(List<Departamento> listDpto) {
        this.listDpto = listDpto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    public void listDptoAll() {
        listDpto = null;
        DepartamentoDB departamentoDB = new DepartamentoDB();
        listDpto = departamentoDB.getDepartamentoAll();
    }
    
    
    public void pintarFrmDpto() {

        System.out.println("Código Departamento: " + idDepartamento);
        Departamento departamento = null;
        DepartamentoDB departamentoDB = new DepartamentoDB();
        departamento = departamentoDB.getDepartamentoById(idDepartamento);
        
        if(departamento != null){
            this.idDepartamento = departamento.getCodDepa();
            this.descDpto = departamento.getDesDepa();
                     
            //Activamos opcion para guardar
            //getOpcSave();
        }
     }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;


import com.raitcon.hibernate.bean.Estudio;
import com.raitcon.hibernate.bean.Examen;
import com.raitcon.hibernate.db.EstudioDB;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author mriverar
 */
@ManagedBean(name = "estudioBean")
@ViewScoped
public class EstudioBean implements Serializable {
    private static final long serialVersionUID = -2377612760546575178L;
    protected static Logger log = Logger.getLogger(EstudioBean.class);
    private String codExamen;
    private Integer idEstudio;
    private Examen examen;
    private Estudio estudio;
    private String descripcion;
    private Character estado;
    private List<Estudio>listEstudio;

    
    public EstudioBean(){
        System.out.println("Se instancia constructor de estudio");
    }
    
    public String getCodExamen() {
        return codExamen;
    }

    public void setCodExamen(String codExamen) {
        this.codExamen = codExamen;
    }

    public Integer getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(Integer idEstudio) {
        this.idEstudio = idEstudio;
    }
    

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }
    
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public List<Estudio> getListEstudio() {
        return listEstudio;
    }

    public void setListEstudio(List<Estudio> listEstudio) {
        this.listEstudio = listEstudio;
    }

   
    public void findEstudioByExamen(){
        this.codExamen=examen.getCodExamen();
        log.info("Buscamos todos estudios los que pertenezcan al código de examen:"+codExamen);
        EstudioDB estudioDB=new EstudioDB();
        
        this.listEstudio=estudioDB.findEstudioByExamen(codExamen);
       
   }
    
    public void frmPintarDetEstudio(){
        System.out.println("llego a frmPintarDetEstudio");
        log.info("Se cargo obejto estudio código:"+estudio.getIdEstudio());
        //EstudioDB estudioDB=new EstudioDB();
        
        this.idEstudio=estudio.getIdEstudio();
        System.out.println("llego a this.idEstudio:"+this.idEstudio);
        
       // this.listEstudio=estudioDB.findEstudioByExamen(codExamen);
       
   }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;

import com.raitcon.hibernate.bean.Clase;
import com.raitcon.hibernate.bean.Examen;

import com.raitcon.hibernate.bean.TipoExamen;
import com.raitcon.hibernate.db.ClaseDB;
import com.raitcon.hibernate.db.ExamenDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author mriverar
 */
@ManagedBean(name = "examenBean")
@ViewScoped
public class ExamenBean implements Serializable {
     private static final long serialVersionUID = -2377612760546575178L;
     protected static Logger log = Logger.getLogger(ExamenBean.class); 
     private String codExamen;
     private Clase clase;
     private Integer idClase;
     private String desClase;
     private TipoExamen tipoExamen;
     private Integer idTipoExamen;
     private String descTipoExamen;
     private String descripcion;
     private String cadBusca;
     private String enlace;
     private BigDecimal precio;
     private String recomendacion;
     private BigDecimal tiempoRespuesta;
     private List<Examen>listExamen;
     private String campoBusqueda;
    
    public ExamenBean(){
        
        System.out.println("Se instancia constructor de examen");
        this.listExamenAll();
    }

    public String getCodExamen() {
        return codExamen;
    }

    public void setCodExamen(String codExamen) {
        this.codExamen = codExamen;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public String getDesClase() {
        return desClase;
    }

    public void setDesClase(String desClase) {
        this.desClase = desClase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public TipoExamen getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(TipoExamen tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public Integer getIdTipoExamen() {
        return idTipoExamen;
    }

    public void setIdTipoExamen(Integer idTipoExamen) {
        this.idTipoExamen = idTipoExamen;
    }

    public String getDescTipoExamen() {
        return descTipoExamen;
    }

    public void setDescTipoExamen(String descTipoExamen) {
        this.descTipoExamen = descTipoExamen;
    }

    public BigDecimal getTiempoRespuesta() {
        return tiempoRespuesta;
    }

    public void setTiempoRespuesta(BigDecimal tiempoRespuesta) {
        this.tiempoRespuesta = tiempoRespuesta;
    }

    public String getCampoBusqueda() {
        return campoBusqueda;
    }

    public void setCampoBusqueda(String campoBusqueda) {
        this.campoBusqueda = campoBusqueda;
    }

    public String getCadBusca() {
        return cadBusca;
    }

    public void setCadBusca(String cadBusca) {
        this.cadBusca = cadBusca;
    }
    
    

    public List<Examen> getListExamen() {
        return listExamen;
    }

    public void setListExamen(List<Examen> listExamen) {
        this.listExamen = listExamen;
    }
    
    
    public void listExamenAll() {
        listExamen = null;
        ExamenDB examenDB = new ExamenDB();
        listExamen = examenDB.getExamenAll();
    }
    
    
    public void findExamenByName(){
        
    System.out.println("campo busqueda:"+this.campoBusqueda);
     listExamen = null;
     ExamenDB examenDB = new ExamenDB();
     if(this.campoBusqueda.equalsIgnoreCase("Descripción"))
     listExamen= examenDB.findExamenByName(this.cadBusca);
     else if(this.campoBusqueda.equalsIgnoreCase("Código")){
         listExamen= examenDB.findExamenByCode(this.cadBusca);
         
     }else{
         //Se busca por clase
         ClaseDB claseDB=new ClaseDB();
         Clase clase=claseDB.getClaseByDesc(this.cadBusca);
         
         listExamen= new ArrayList<Examen>(clase.getExamens());
     }
         
    /* System.out.println("Llego aqui");
     for(Examen o:listExamen ){
         System.out.println("o.getCodExamen:"+o.getCodExamen());
     }*/
    }
        
     
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;

import com.raitcon.hibernate.bean.Ocupacion;
import com.raitcon.hibernate.db.OcupacionDB;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Miki Lap
 */
@ManagedBean(name = "ocupacionBean")
@ViewScoped
public class OcupacionBean implements Serializable {

      private static final long serialVersionUID = -2377612760546575078L; 
     protected static Logger log = Logger.getLogger(OcupacionBean.class); 
     private int codOcupacion;
     private String descripcion;
     private Character estado;
      private Integer opcionSave;
      private String mensaje;
          private Ocupacion editOcupacion;
      
     public OcupacionBean()
     {
         this.listOcupacionAll();
     }
             

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

    /**
     * @return the codOcupacion
     */
    public int getCodOcupacion() {
        return codOcupacion;
    }

    /**
     * @param codOcupacion the codOcupacion to set
     */
    public void setCodOcupacion(int codOcupacion) {
        this.codOcupacion = codOcupacion;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the estado
     */
    public Character getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Character estado) {
        this.estado = estado;
    }
    
    
     public void agregarOcupacion() {
        int result = 0;
        if (this.getOpcionSave() !=1){
            try {
                
                Ocupacion ocupacion = new Ocupacion();
                ocupacion.setCodOcupacion(codOcupacion);
                ocupacion.setDescripcion(descripcion);
                ocupacion.setEstado('1');
                

                OcupacionDB ocupacionDB = new OcupacionDB();

                    result = ocupacionDB.insertaOcupacion(ocupacion);
                    if (result==1){
                     setMensaje("* Ocupacion con id "+ codOcupacion +", se registrÃ³ satisfactoriamente.") ;
                    }
            } catch (HibernateException ex) {
                 setMensaje("* Ocupacion con id "+codOcupacion +", no se pudo registrar.") ;
                log.error("Se generÃ³ errores al ingresar personal:"+ ex);
            } catch (Exception ex) {
                 setMensaje("* Ocupacion con id "+codOcupacion +", no se pudo registrar.") ;
                log.error("Se generÃ³ errores al ingresar personal:"+ ex);
            }
        }else{
           
            try {
                updateOcupacion();
                result=1;
                 setMensaje("* Ocupacion con id "+codOcupacion +", se actulizÃ³ satisfactoriamente.") ;
            } catch (HibernateException ex) {
                setMensaje("* Ocupacion con id "+codOcupacion +", no se pudo actualizar.") ;
                log.error("Se generÃ³ errores al actualizar ocuapacion:"+ ex);
            } catch (Exception ex) {
                setMensaje("* Oupaccion con id "+codOcupacion +", no se pudo actualizar.") ;
                log.error("Se generÃ³ errores al actualizar ocupacion:"+ ex);
            }
        }
        
        if (result == 1)
        {
            this.listOcupacionAll();
        } 
    }

    public void updateOcupacion() throws HibernateException, Exception {
            Ocupacion ocupacion = new Ocupacion();
            
            ocupacion.setCodOcupacion(codOcupacion);
            ocupacion.setDescripcion(descripcion);
            ocupacion.setEstado(estado);

        OcupacionDB ocupacionDB = new OcupacionDB();
        ocupacionDB.updateOcupacion(ocupacion, codOcupacion);
    }

    public void deleteOcupacion() throws HibernateException, Exception {

        int codocupacion=0;
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();

            Map params = externalContext.getRequestParameterMap();
            codocupacion = (Integer) params.get("formOcupacion:codOcupacion");
        } catch (Exception e) {
            System.out.println("Error al capturar parametro codPersonal:" + e.getMessage());
        }
        System.out.println("codOcupacion:" + codOcupacion);

        OcupacionDB ocupacionDB = new OcupacionDB();
        Ocupacion ocupacion = ocupacionDB.getOcupacionByIdUniqueOcupacion(codOcupacion);
       
        if(ocupacion !=null){
            ocupacion.setEstado('1');
            ocupacionDB.desactivarOcupacion(ocupacion);
            this.setMensaje("* Ocupacion con id "+codOcupacion +", se eliminÃ³ correctamente.") ;
         }
        else{
            this.setMensaje("* Ocupacion con id "+codOcupacion +", no se pudo eliminar.") ;
            
        }
            
    }

    public void pintarFrmOcupacion() {

         System.out.println("codigo clase: " +this.editOcupacion.getCodOcupacion());
        //Clase clase = null;
        //ClaseDB claseDB = new ClaseDB();
        //clase = claseDB.getClaseById(idClase);
        
        if(this.editOcupacion != null){
            this.codOcupacion = editOcupacion.getCodOcupacion();
            this.descripcion = editOcupacion.getDescripcion();
           
          //Activamos opcion para guardar
            getOpcSave();
        }
     }
    
    
   
    
    
    
    
    public void getOpcSave(){
         this.setOpcionSave((Integer) 1);
         this.setMensaje("");
    }
    
    public void getOpcNew(){
        this.opcionSave=0;
         clearFrmGrupo();
         this.mensaje="";
    }
    
     public void clearFrmGrupo(){
        this.descripcion=null;
        this.codOcupacion =0;
           
    }

    /**
     * @return the opcionSave
     */
    public Integer getOpcionSave() {
        return opcionSave;
    }

    /**
     * @param opcionSave the opcionSave to set
     */
    public void setOpcionSave(Integer opcionSave) {
        this.opcionSave = opcionSave;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
    public void remove(){
        try {
            System.out.println("Ingreso aqui. codigo de eliminacion "+ codOcupacion);
            OcupacionDB  ocupacionDB=new OcupacionDB();
            
            Ocupacion ocupacion = new Ocupacion();
            ocupacion.setCodOcupacion(codOcupacion);
            ocupacion.setEstado('0');
            
            ocupacionDB.desactivarOcupacion(ocupacion);
            mensaje = "* Clase con cÃ³digo "+codOcupacion +", se eliminÃ³ correctamente." ;
            listOcupacionAll();
        } catch (HibernateException ex) {
            mensaje = "* Clase con cÃ³digo "+codOcupacion +", no se pudo eliminar." ;
            log.error("Se generÃ³ errores al eliminar clase:"+ ex);
             System.out.println("Se generÃ³ errores al eliminar clase:"+ ex);
        } catch (Exception ex) {
             mensaje = "* Clase con cÃ³digo "+codOcupacion +", no se pudo eliminar." ;
            log.error("Se generÃ³ errores al eliminar clase:"+ ex);
            System.out.println("Se generÃ³ errores al eliminar clase:"+ ex);
        }
    }

    /**
     * @return the editOcupacion
     */
    public Ocupacion getEditOcupacion() {
        return editOcupacion;
    }

    /**
     * @param editOcupacion the editOcupacion to set
     */
    public void setEditOcupacion(Ocupacion editOcupacion) {
        this.editOcupacion = editOcupacion;
    }
}

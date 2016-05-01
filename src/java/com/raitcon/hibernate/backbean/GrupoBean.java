/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;

import com.raitcon.hibernate.bean.Grupo;
import com.raitcon.hibernate.db.GrupoDB;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Miki 
 */
@ManagedBean(name = "grupoBean")
@ViewScoped
public class GrupoBean implements Serializable{
    
    private static final long serialVersionUID = -2377612760546575078L;
    protected static Logger log = Logger.getLogger(ClaseBean.class); 

    
    
    private int idGrupo;
     private String descripcion;
     private Character estado;
    private List<Grupo> listGrupo;
    private String mensaje;
    private Integer opcionSave;
 
    
    
    private String descripcionGrupo;
    private Grupo editGrupo;
    
    
    
    public GrupoBean(){
      this.listGrupoAll();
      opcionSave=0;  
    }
    


    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

   

    

   

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getOpcionSave() {
        return opcionSave;
    }

    public void setOpcionSave(Integer opcionSave) {
        this.opcionSave = opcionSave;
    }
    
    //Metodos de Mantenimiento (CRUD)
    public void listGrupoAll() {
        listGrupo = null;
        GrupoDB grupoDB = new GrupoDB();
        listGrupo = grupoDB.getGrupoAll();
    }
    
    
    public void agregarGrupo() {
        int result = 0;
        if (this.opcionSave !=1){
            Grupo grupo = new Grupo();
            grupo.setIdGrupo(idGrupo);
            grupo.setDescripcion(descripcion);
            grupo.setEstado('1');
            
            
            GrupoDB grupoDB = new GrupoDB();
            try {
                result = grupoDB.insertGrupo(grupo);
                if (result==1){
                 mensaje = "* Grupo con código "+idGrupo +", se registró satisfactoriamente." ;
                }
            } catch (HibernateException ex) {
                 mensaje = "* Grupo con código "+idGrupo +", no se pudo registrar." ;
                log.error("Se generó errores al ingresar clase:"+ ex);
            } catch (Exception ex) {
                 mensaje = "* Grupo con código "+idGrupo +", no se pudo registrar." ;
                log.error("Se generó errores al ingresar clase:"+ ex);
            }
        }else{
           
            try {
                updateGrupo();
                result=1;
                 mensaje = "* Clase con código "+idGrupo +", se actulizó satisfactoriamente." ;
            } catch (HibernateException ex) {
                mensaje = "* Clase con código "+idGrupo +", no se pudo actualizar." ;
                log.error("Se generó errores al actualizar clase:"+ ex);
            } catch (Exception ex) {
                mensaje = "* Clase con código "+idGrupo +", no se pudo actualizar." ;
                log.error("Se generó errores al actualizar clase:"+ ex);
            }
        }
        
        
        if (result == 1) {
            this.listGrupoAll();
        } 

        
      
    }
    
    
    public void updateGrupo() throws HibernateException, Exception {
            Grupo grupo = new Grupo();
            grupo.setIdGrupo(this.idGrupo);
            grupo.setDescripcion(this.getDescripcion());
           
            GrupoDB grupoDB = new GrupoDB();
            grupoDB.updateGrupo(grupo, idGrupo);
    }
    
    
     public void pintarFrmGrupo() {

        
         System.out.println("codigo idgrupo: " + idGrupo);
          System.out.println("codigo descripcion: " + descripcion);
       // Grupo grupo = null;
      //  GrupoDB grupoDB = new GrupoDB();
      //  grupo = grupoDB.getGrupoById(idGrupo);
        
        if(this.editGrupo != null){
            this.idGrupo = this.editGrupo.getIdGrupo();
            this.descripcion = this.editGrupo.getDescripcion();
            this.estado=this.editGrupo.getEstado();
          //Activamos opcion para guardar
            getOpcSave();
        }
     }
        
        
    public void getOpcSave(){
         this.opcionSave=1;
         this.mensaje="";
    }
    
    public void getOpcNew(){
         this.opcionSave=0;
         clearFrmGrupo();
         this.mensaje="";
    }
    
    public void remove(){
        try {
            System.out.println("Ingreso aqui. codigo de eliminacion "+ idGrupo);
            GrupoDB  grupoDB=new GrupoDB();
            
            Grupo grupo = new Grupo();
            grupo.setIdGrupo(idGrupo);
            grupo.setEstado('0');

            
            //Clase clase=claseDB.getClaseById(idClase);
            grupoDB.desactivarGrupo(grupo);
            mensaje = "* Clase con código "+idGrupo +", se eliminó correctamente." ;
            listGrupoAll();
        } catch (HibernateException ex) {
            mensaje = "* Clase con código "+idGrupo +", no se pudo eliminar." ;
            log.error("Se generó errores al eliminar clase:"+ ex);
             System.out.println("Se generó errores al eliminar clase:"+ ex);
        } catch (Exception ex) {
             mensaje = "* Clase con código "+idGrupo +", no se pudo eliminar." ;
            log.error("Se generó errores al eliminar clase:"+ ex);
            System.out.println("Se generó errores al eliminar clase:"+ ex);
        }
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

  
    
    
    
    public void clearFrmGrupo(){
        this.descripcion=null;
        this.idGrupo=0;

       
    }

    /**
     * @return the descripcionGrupo
     */
    public String getDescripcionGrupo() {
        return descripcionGrupo;
    }

    /**
     * @param descripcionGrupo the descripcionGrupo to set
     */
    public void setDescripcionGrupo(String descripcionGrupo) {
        this.descripcionGrupo = descripcionGrupo;
    }



    /**
     * @return the listGrupo
     */
    public List<Grupo> getListGrupo() {
        return listGrupo;
    }

    /**
     * @param listGrupo the listGrupo to set
     */
    public void setListGrupo(List<Grupo> listGrupo) {
        this.listGrupo = listGrupo;
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

    /**
     * @return the editGrupo
     */
    public Grupo getEditGrupo() {
        return editGrupo;
    }

    /**
     * @param editGrupo the editGrupo to set
     */
    public void setEditGrupo(Grupo editGrupo) {
        this.editGrupo = editGrupo;
    }

    
}

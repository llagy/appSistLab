/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;

import com.raitcon.hibernate.bean.Clase;
import com.raitcon.hibernate.bean.Grupo;
import com.raitcon.hibernate.db.ClaseDB;
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
@ManagedBean(name = "claseBean")
@ViewScoped
public class ClaseBean implements Serializable{
    
    private static final long serialVersionUID = -2377612760546575078L;
    protected static Logger log = Logger.getLogger(ClaseBean.class); 
    private Integer idGrupo; 
    private Integer idClase;
    private String descripcion;
    private List<Clase> listClase;
    private String mensaje;
    private Integer opcionSave;
    private Clase editClase;
    
    
    private String descripcionGrupo;
    private Grupo grupo;
    
    
    
    public ClaseBean(){
      this.listClaseAll();
      opcionSave=0;  
    }
    


    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    

    public List<Clase> getListClase() {
        return listClase;
    }

    public void setListClase(List<Clase> listClase) {
        this.listClase = listClase;
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
    public void listClaseAll() {
        listClase = null;
        ClaseDB claseDB = new ClaseDB();
        listClase = claseDB.getClaseAll();
    }
    
    
    public void agregarClase() {
        int result = 0;
        if (this.opcionSave !=1){
            Clase clase = new Clase();
            clase.setIdClase(idClase);
            clase.setDescripcion(descripcion);
           System.out.println(" cccvvvv agregarClase " + grupo.getDescripcion()+" ddd "+ grupo.getIdGrupo());
            
            //Grupo grupo=new Grupo(idGrupo,"");
            Grupo grupo=new Grupo(this.grupo.getIdGrupo(),"",'1');
            
            clase.setGrupo(grupo);
            
            ClaseDB claseDB = new ClaseDB();
            try {
                result = claseDB.insertClases(clase);
                if (result==1){
                 mensaje = "* Clase con código "+idClase +", se registró satisfactoriamente." ;
                }
            } catch (HibernateException ex) {
                 mensaje = "* Clase con código "+idClase +", no se pudo registrar." ;
                log.error("Se generó errores al ingresar clase:"+ ex);
            } catch (Exception ex) {
                 mensaje = "* Clase con código "+idClase +", no se pudo registrar." ;
                log.error("Se generó errores al ingresar clase:"+ ex);
            }
        }else{
           
            try {
                updateClase();
                result=1;
                 mensaje = "* Clase con código "+idClase +", se actulizó satisfactoriamente." ;
            } catch (HibernateException ex) {
                mensaje = "* Clase con código "+idClase +", no se pudo actualizar." ;
                log.error("Se generó errores al actualizar clase:"+ ex);
            } catch (Exception ex) {
                mensaje = "* Clase con código "+idClase +", no se pudo actualizar." ;
                log.error("Se generó errores al actualizar clase:"+ ex);
            }
        }
        
        
        if (result == 1) {
            this.listClaseAll();
        } 

        
      
    }
    
    
    public void updateClase() throws HibernateException, Exception {
            Clase clase = new Clase();
            clase.setIdClase(this.idClase);
            clase.setDescripcion(this.getDescripcion());
             System.out.print(" cccvvvv agregarClase " + grupo.getDescripcion() +"  gggthis.grupo.getIdGrupo()= "+this.grupo.getIdGrupo());
            Grupo grupo =new Grupo(this.grupo.getIdGrupo(),"",'1');
            clase.setGrupo(grupo);
            ClaseDB claseDB = new ClaseDB();
            claseDB.updateClase(clase, idClase);
    }
    
    
     public void pintarFrmClase() {

          System.out.println("codigo clase: " + idClase);
          System.out.println("codigo descripcion: " + descripcion);
        //Clase clase = null;
        //ClaseDB claseDB = new ClaseDB();
        //clase = claseDB.getClaseById(idClase);
        
        if(this.editClase != null){
            this.idClase = editClase.getIdClase();
            this.descripcion = editClase.getDescripcion();
            this.idGrupo=editClase.getGrupo().getIdGrupo();
            this.grupo=editClase.getGrupo();
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
         clearFrmClase();
         this.mensaje="";
    }
    
    public void remove(){
        try {
            System.out.println("Ingreso aqui. codigo de eliminacion "+ idClase);
            ClaseDB  claseDB=new ClaseDB();
            
            //Clase clase=claseDB.getClaseById(idClase);
            claseDB.deleteClase(idClase);
            mensaje = "* Clase con código "+idClase +", se eliminó correctamente." ;
            listClaseAll();
        } catch (HibernateException ex) {
            mensaje = "* Clase con código "+idClase +", no se pudo eliminar." ;
            log.error("Se generó errores al eliminar clase:"+ ex);
             System.out.println("Se generó errores al eliminar clase:"+ ex);
        } catch (Exception ex) {
             mensaje = "* Clase con código "+idClase +", no se pudo eliminar." ;
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

    /**
     * @return the editClase
     */
    public Clase getEditClase() {
        return editClase;
    }

    /**
     * @param editClase the editClase to set
     */
    public void setEditClase(Clase editClase) {
        this.editClase = editClase;
    }
    
    
    
    
    public void clearFrmClase(){
        this.descripcion=null;
        this.idClase=null;
        this.grupo=null;

       
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
     * @return the grupo
     */
    public Grupo getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}

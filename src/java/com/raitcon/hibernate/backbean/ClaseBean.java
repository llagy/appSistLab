/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;

import com.raitcon.hibernate.bean.Clase;
import com.raitcon.hibernate.db.ClaseDB;
import java.io.Serializable;
import java.util.HashSet;
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
    private String desClase;
    private List<Clase> listClase;
    private String mensaje;
    private Integer opcionSave;
    
    
    public ClaseBean(){
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

    public String getDesClase() {
        return desClase;
    }

    public void setDesClase(String desClase) {
        this.desClase = desClase;
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
            clase.setDesClase(desClase);
            clase.setCodGrupo(idGrupo);
            
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
        
      
    }
    
    
    public void updateClase() throws HibernateException, Exception {
            Clase clase = new Clase();
            clase.setIdClase(this.idClase);
            clase.setDesClase(this.getDesClase());
            clase.setCodGrupo(idGrupo);
            ClaseDB claseDB = new ClaseDB();
            claseDB.updateClase(clase, idClase);
    }
    
    
     public void pintarFrmClase() {

        System.out.println("codigo clase: " + idClase);
        Clase clase = null;
        ClaseDB claseDB = new ClaseDB();
        clase = claseDB.getClaseById(idClase);
        
        if(clase != null){
            this.idClase = clase.getIdClase();
            this.desClase = clase.getDesClase();
            this.idGrupo=clase.getCodGrupo();
            
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
         this.mensaje="";
    }

    
}

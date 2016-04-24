/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;

import static com.raitcon.hibernate.backbean.ClaseBean.log;
import com.raitcon.hibernate.bean.Clase;
import com.raitcon.hibernate.bean.TipoPaciente;
import com.raitcon.hibernate.db.ClaseDB;
import com.raitcon.hibernate.db.TipoPacienteDB;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Guillermo Lap
 */
@ManagedBean(name = "tipoPacienteBean")
@ViewScoped
public class TipoPacienteBean implements Serializable {
    private static final long serialVersionUID = -2377612760546575078L;
    protected static Logger log = Logger.getLogger(TipoPacienteBean.class); 
    private int idTipoPaciente;
    private String descripcion;
    private List<TipoPaciente> listTipoPaciente;
    private String mensaje;
    private Integer opcionSave;
    
    
    public TipoPacienteBean(){
      opcionSave=0;  
    }

    public int getIdTipoPaciente() {
        return idTipoPaciente;
    }

    public void setIdTipoPaciente(int idTipoPaciente) {
        this.idTipoPaciente = idTipoPaciente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<TipoPaciente> getListTipoPaciente() {
        return listTipoPaciente;
    }

    public void setListTipoPaciente(List<TipoPaciente> listTipoPaciente) {
        this.listTipoPaciente = listTipoPaciente;
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
    public void listTipoPacienteAll() {
        this.listTipoPaciente = null;
        TipoPacienteDB tipoPacienteDB = new TipoPacienteDB();
        this.listTipoPaciente = tipoPacienteDB.getTipoPacienteAll();
    }
    
  /*  
    public void agregarPaciente() {
        int result = 0;
        if (this.opcionSave !=1){
            Tipaciente clase = new Clase();
            clase.setIdClase(idTipoPaciente);
            clase.setDesClase(desClase);
            
            
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
    */
    
   /* public void updateClase() throws HibernateException, Exception {
            Clase clase = new Clase();
            clase.setIdClase(this.idClase);
            clase.setDesClase(this.getDesClase());
            clase.setCodGrupo(idGrupo);
            ClaseDB claseDB = new ClaseDB();
            claseDB.updateClase(clase, idClase);
    }
    */
    
     public void pintarFrmTipoPaciente() {

        System.out.println("codigo tipopaciente: " + idTipoPaciente);
        TipoPaciente tipoPaciente = null;
        TipoPacienteDB tipoPacienteDB = new TipoPacienteDB();
        tipoPaciente = tipoPacienteDB.getTipoPacienteById(idTipoPaciente);
        
        if(tipoPaciente != null){
            this.idTipoPaciente = tipoPaciente.getIdTipoPaciente();
            this.descripcion = tipoPaciente.getDescripcion();
            
            
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
    
  /*  public void remove(){
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
        }*/
}

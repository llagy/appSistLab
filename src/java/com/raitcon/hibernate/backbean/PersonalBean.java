package com.raitcon.hibernate.backbean;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.raitcon.hibernate.bean.Ocupacion;
import com.raitcon.hibernate.bean.Personal;
import com.raitcon.hibernate.bean.Sexo;
import com.raitcon.hibernate.db.OcupacionDB;
import com.raitcon.hibernate.db.PersonalDB;
import com.raitcon.hibernate.db.SexoDB;
import org.apache.log4j.Logger;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
/**
 *
 * @author Mike
 */
@ManagedBean(name = "personalBean")
@ViewScoped
public class PersonalBean implements Serializable {

    private static final long serialVersionUID = -2377612760546575078L;
    protected static Logger log = Logger.getLogger(PersonalBean.class); 
    private String codPersonal;
    private String dni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private Character sexo;
    private String descSexo;
    private String estadoCivil;
    private String especialidad;
    private Ocupacion ocupacion;
    private Integer idOcupacion;
    private String descOcupacion;
    private String mail;
    private String telefono;
    private String direccion;   
    private String mensaje;
    private List<Personal> listPersonal;
    private Integer opcionSave;
    private Character estado;

    
    
    public PersonalBean(){
        opcionSave=0;
    }

    public String getDescSexo() {
        return descSexo;
    }

    public void setDescSexo(String descSexo) {
        this.descSexo = descSexo;
    }
    
    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }
    
    
    public String getDescOcupacion() {
        return descOcupacion;
    }

    public void setDescOcupacion(String descOcupacion) {
        this.descOcupacion = descOcupacion;
    }
   
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
   
    public List<Personal> getListPersonal() {
        return listPersonal;
    }

    public void setListPersonal(List<Personal> listPersonal) {
        this.listPersonal = listPersonal;
    }

    public String getCodPersonal() {
        return codPersonal;
    }

    public void setCodPersonal(String codPersonal) {
        this.codPersonal = codPersonal;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

   

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public Integer getIdOcupacion() {
        return idOcupacion;
    }

    public void setIdOcupacion(Integer idOcupacion) {
        this.idOcupacion = idOcupacion;
    }
    
    public Integer getOpcionSave() {
        return opcionSave;
    }

    public void setOpcionSave(Integer opcionSave) {
        this.opcionSave = opcionSave;
    }

    //Metodos de Mantenimiento (CRUD)
    public void listPersonalAll() {
        listPersonal = null;
        PersonalDB personalDB = new PersonalDB();
        listPersonal = personalDB.getPersonalAll();
    }

  /*  public void listPersonalByCod() {
        String codPersonal = "";
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();

            Map params = externalContext.getRequestParameterMap();
            codPersonal = ((String) params.get("formPers:codPersonal"));
        } catch (Exception e) {
            System.out.println("Error al capturar parametro codPersonal:" + e.getMessage());
        }
        System.out.println("codPersonal:" + codPersonal);

        listPersonal = null;
        PersonalDB personalDB = new PersonalDB();
        listPersonal = personalDB.getPersonalByCod(codPersonal);
    }*/
    
  
    public void agregarPersonal() {
        int result = 0;
        if (this.opcionSave !=1){
            Personal personal = new Personal();
            personal.setCodPersonal(codPersonal);
            personal.setNombres(nombres);
            personal.setApPaterno(apellidoPaterno);
            personal.setApMaterno(apellidoMaterno);
            personal.setFechaNacimiento(fechaNacimiento);
            personal.setEspecialidad(especialidad);
            personal.setDni(dni);
            personal.setTelefono(telefono);
            personal.setDireccion(direccion);
            personal.setSexo(sexo);
            personal.setEstadoCivil(estadoCivil);
            personal.setEstado('1');
            personal.setMail(mail);
            ocupacion =new Ocupacion();
            ocupacion.setCodOcupacion(this.idOcupacion);
            ocupacion.setDescripcion(descOcupacion);
            personal.setOcupacion(ocupacion);
            PersonalDB personaDB = new PersonalDB();
            try {
                result = personaDB.insertPersonal(personal);
                if (result==1){
                 mensaje = "* Personal con código "+codPersonal +", se registró satisfactoriamente." ;
                }
            } catch (HibernateException ex) {
                 mensaje = "* Personal con código "+codPersonal +", no se pudo registrar." ;
                log.error("Se generó errores al ingresar personal:"+ ex);
            } catch (Exception ex) {
                 mensaje = "* Personal con código "+codPersonal +", no se pudo registrar." ;
                log.error("Se generó errores al ingresar personal:"+ ex);
            }
        }else{
           
            try {
                updatePersonal();
                result=1;
                 mensaje = "* Personal con código "+codPersonal +", se actulizó satisfactoriamente." ;
            } catch (HibernateException ex) {
                mensaje = "* Personal con código "+codPersonal +", no se pudo actualizar." ;
                log.error("Se generó errores al actualizar personal:"+ ex);
            } catch (Exception ex) {
                mensaje = "* Personal con código "+codPersonal +", no se pudo actualizar." ;
                log.error("Se generó errores al actualizar personal:"+ ex);
            }
        }
        
        /*if (result == 1) {
            mensaje = "* Personal con código "+codPersonal +", se registró satisfactoriamente." ;
        } else {
            mensaje = "* Personal con código "+codPersonal +", no se pudo registrar." ;
        }*/
    }

    public void updatePersonal() throws HibernateException, Exception {
            Personal personal = new Personal();
            personal.setCodPersonal(codPersonal);
            personal.setNombres(nombres);
            personal.setApPaterno(apellidoPaterno);
            personal.setApMaterno(apellidoMaterno);
            personal.setFechaNacimiento(fechaNacimiento);
            personal.setEspecialidad(especialidad);
            personal.setDni(dni);
            personal.setTelefono(telefono);
            personal.setDireccion(direccion);
            personal.setSexo(sexo);
            personal.setEstadoCivil(estadoCivil);
            personal.setMail(mail);
            ocupacion =new Ocupacion();
            ocupacion.setCodOcupacion(this.idOcupacion);
            ocupacion.setDescripcion(descOcupacion);
            personal.setOcupacion(ocupacion);
        PersonalDB personalDB = new PersonalDB();
        personalDB.updatePersonal(personal, codPersonal);
    }

    public void deletePersonal() throws HibernateException, Exception {

        String codPersonal="";
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();

            Map params = externalContext.getRequestParameterMap();
            codPersonal = (String) params.get("formPers:codPersonal");
        } catch (Exception e) {
            System.out.println("Error al capturar parametro codPersonal:" + e.getMessage());
        }
        System.out.println("codPersonal:" + codPersonal);

        PersonalDB persDB = new PersonalDB();
        Personal pers = persDB.getPersonalByCod(codPersonal);
       
        if(pers !=null){
            pers.setEstado('0');
            persDB.desactivarPersonal(pers);
            this.mensaje = "* Personal con código "+codPersonal +", se eliminó correctamente." ;
         }
        else{
            this.mensaje = "* Personal con código "+codPersonal +", no se pudo eliminar." ;
            
        }
            
    }

    public void pintarFormularioPersonal() {

        System.out.println("codigo personal: " + codPersonal);
        Personal pers = null;
        PersonalDB persDB = new PersonalDB();
        pers = persDB.getPersonalByCod(codPersonal);
        
        if(pers != null){
            this.codPersonal = pers.getCodPersonal();
            this.dni = pers.getDni();
            this.nombres = pers.getNombres();
            this.apellidoPaterno = pers.getApPaterno();
            this.apellidoMaterno = pers.getApMaterno();
            this.direccion = pers.getDireccion();
            this.fechaNacimiento = pers.getFechaNacimiento();
            this.especialidad=pers.getEspecialidad();
            this.telefono=pers.getTelefono();
            this.mail=pers.getMail();
            this.estadoCivil=pers.getEstadoCivil();
            this.especialidad=pers.getEspecialidad();
            this.ocupacion=pers.getOcupacion();
            this.sexo = pers.getSexo();
            this.idOcupacion=pers.getOcupacion().getCodOcupacion();
            
            //Activamos opcion para guardar
            getOpcSave();
        }
       

    }
    
    
    public void pintarFormSex() {

        System.out.println("codigo sexo: " + sexo);
        Sexo sex = null;
        List<Sexo> listSexo;
        SexoDB sexoDB = new SexoDB();
        listSexo = sexoDB.getSexoByCod(sexo);
        for (Sexo o : listSexo) {
            sex = o;
        }
        if(sex != null){
        this.sexo = sex.getCodSexo();
        this.descSexo = sex.getDescripcion();
        }
    }
    
    
    public void pintarFormOcup() {

        System.out.println("codigo Ocupacion: " + idOcupacion);
        Ocupacion ocup = null;
        List<Ocupacion> listOcup;
        OcupacionDB ocupDB = new OcupacionDB();
        listOcup = ocupDB.getOcupacionById(idOcupacion);
        for (Ocupacion o : listOcup) {
            ocup = o;
        }
        if(ocup != null){
        this.idOcupacion = ocup.getCodOcupacion();
        this.descOcupacion = ocup.getDescripcion();
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

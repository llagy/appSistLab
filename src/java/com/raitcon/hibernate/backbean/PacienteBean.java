/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;


import com.raitcon.hibernate.bean.Departamento;
import com.raitcon.hibernate.bean.Distrito;
import com.raitcon.hibernate.bean.Estacivil;
import com.raitcon.hibernate.bean.Instruccion;
import com.raitcon.hibernate.bean.Ocupacion;
import com.raitcon.hibernate.bean.Paciente;
import com.raitcon.hibernate.bean.Provincia;
import com.raitcon.hibernate.bean.Sexo;
import com.raitcon.hibernate.bean.TipoPaciente;
import com.raitcon.hibernate.db.DepartamentoDB;
import com.raitcon.hibernate.db.DistritoDB;
import com.raitcon.hibernate.db.EstaCivilDB;
import com.raitcon.hibernate.db.InstruccionDB;
import com.raitcon.hibernate.db.OcupacionDB;
import com.raitcon.hibernate.db.PacienteDB;
import com.raitcon.hibernate.db.ProvinciaDB;
import com.raitcon.hibernate.db.SexoDB;
import com.raitcon.hibernate.db.TipoPacienteDB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
 * @author Mike
 */
@ManagedBean(name = "pacienteBean")
@ViewScoped
public class PacienteBean implements Serializable {
    
     private static final long serialVersionUID = -2377612760546575078L;
    protected static Logger log = Logger.getLogger(PacienteBean.class); 
    private String codPaciente;
    private String codPcteFind;
    private Integer idTipoPac;
    private String descTipPac;
    private Character codSexo;
    private String descSexo;
    private Sexo sexo;
    private Integer idEstaCivil;
    private String descEstaCivil;
    private Integer idOcupacion;
    private String descOcupacion;
    private Integer idInstruccion;
    private String descInstruccion;
    private String dni;
    private String nombre1;
    private String nombre2;
    private String apPaterno;
    private String apMaterno;
    private Date fechaNacimiento;
    private Date fechaIngreso;
    private Ocupacion ocupacion;
    
    private String email;
    private String telefono;
    private String direccion;   
    private byte[] foto;
    private String mensaje;
    private List<Paciente> listPaciente;
    private Integer opcionSave;
    private Character estado;
    private Integer  codDpto;
    private String descDpto;
    private Integer codProv;
    private String descProv;
    private Integer codDistrito;
    private String descDistrito;
    Paciente editPaciente;
    
    
    public PacienteBean(){
        this.opcionSave=0;
        System.out.println("Se instancia constructor");
        this.listPacienteAll();
    }

    public Integer getIdTipoPac() {
        return idTipoPac;
    }

    public void setIdTipoPac(Integer idTipoPac) {
        this.idTipoPac = idTipoPac;
    }

    public String getDescTipPac() {
        return descTipPac;
    }

    public void setDescTipPac(String descTipPac) {
        this.descTipPac = descTipPac;
    }

    public Integer getIdEstaCivil() {
        return idEstaCivil;
    }

    public void setIdEstaCivil(Integer idEstaCivil) {
        this.idEstaCivil = idEstaCivil;
    }

    public String getDescEstaCivil() {
        return descEstaCivil;
    }

    public void setDescEstaCivil(String descEstaCivil) {
        this.descEstaCivil = descEstaCivil;
    }

    public Integer getIdInstruccion() {
        return idInstruccion;
    }

    public void setIdInstruccion(Integer idInstruccion) {
        this.idInstruccion = idInstruccion;
    }

    public String getDescInstruccion() {
        return descInstruccion;
    }

    public void setDescInstruccion(String descInstruccion) {
        this.descInstruccion = descInstruccion;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public List<Paciente> getListPaciente() {
        return listPaciente;
    }

    public void setListPaciente(List<Paciente> listPaciente) {
        this.listPaciente = listPaciente;
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

    public Integer getCodDpto() {
        return codDpto;
    }

    public void setCodDpto(Integer codDpto) {
        this.codDpto = codDpto;
    }

    public String getDescDpto() {
        return descDpto;
    }

    public void setDescDpto(String descDpto) {
        this.descDpto = descDpto;
    }

    public Integer getCodProv() {
        return codProv;
    }

    public void setCodProv(Integer codProv) {
        this.codProv = codProv;
    }

    public String getDescProv() {
        return descProv;
    }

    public void setDescProv(String descProv) {
        this.descProv = descProv;
    }

    public Integer getCodDistrito() {
        return codDistrito;
    }

    public void setCodDistrito(Integer codDistrito) {
        this.codDistrito = codDistrito;
    }

    public String getDescDistrito() {
        return descDistrito;
    }

    public void setDescDistrito(String descDistrito) {
        this.descDistrito = descDistrito;
    }
    
    
   
    
   
    public List<Paciente> getListPacientes() {
        return listPaciente;
    }

    public void setListPacientes(List<Paciente> listPacientes) {
        this.listPaciente = listPacientes;
    }

    public String getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(String codPaciente) {
        this.codPaciente = codPaciente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

     

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
     public Character getCodSexo() {
        return codSexo;
    }

    public void setCodSexo(Character codSexo) {
        this.codSexo = codSexo;
    }

    public Paciente getEditPaciente() {
        return editPaciente;
    }

    public void setEditPaciente(Paciente editPaciente) {
        this.editPaciente = editPaciente;
    }

    public String getCodPcteFind() {
        return codPcteFind;
    }

    public void setCodPcteFind(String codPcteFind) {
        this.codPcteFind = codPcteFind;
    }
    
    

    //Metodos de Mantenimiento (CRUD)
    public void listPacienteAll() {
        listPaciente = null;
        PacienteDB pacienteDB = new PacienteDB();
        listPaciente = pacienteDB.getPacienteAll();
    }
    
     public void listPacienteById() {
        listPaciente = null;
        PacienteDB pacienteDB = new PacienteDB();
        Paciente pcte= pacienteDB.getPacienteByCod(this.codPcteFind);
        if (pcte!=null){
         listPaciente= new ArrayList<Paciente>();
        listPaciente.add(pcte);
        }
    }

  
    
  
    public void agregarPaciente() {
        System.out.println("Llegoo aquii 111");
        int result = 0;
        if (this.opcionSave !=1){
            try {
                
                Paciente paciente = new Paciente();
                paciente.setCodPaciente(codPaciente);
                paciente.setNombre1(nombre1);
                paciente.setNombre2(nombre2);
                paciente.setApPaterno(apPaterno);
                paciente.setApMaterno(apMaterno);
                paciente.setFechaNacimiento(fechaNacimiento);
                paciente.setFechaIngreso(fechaIngreso);
                paciente.setTelefono(telefono);
                paciente.setDireccion(direccion);
                sexo=new Sexo(codSexo, descSexo);
                paciente.setSexo(sexo);
                paciente.setEstado('1');
                paciente.setEmail(email);
                ocupacion =new Ocupacion();
                ocupacion.setCodOcupacion(this.idOcupacion);
                ocupacion.setDescripcion(descOcupacion);
                paciente.setOcupacion(ocupacion);
                TipoPaciente tipPaciente=new TipoPaciente();
                tipPaciente.setIdTipoPaciente(this.idTipoPac);
                paciente.setTipoPaciente(tipPaciente);
                Estacivil estaCivil=new Estacivil();
                estaCivil.setCodEstacivil(idEstaCivil);
                paciente.setEstacivil(estaCivil);
                Instruccion instruccion=new Instruccion();
                instruccion.setCodInstruccion(idInstruccion);
                paciente.setInstruccion(instruccion);
                Distrito distrito=new Distrito();
                distrito.setCodDistrito(this.codDistrito);
                paciente.setDistrito(distrito);
                PacienteDB pacienteDB = new PacienteDB();

                    result = pacienteDB.insertPaciente(paciente);
                    if (result==1){
                     mensaje = "* Paciente con código "+codPaciente +", se registró satisfactoriamente." ;
                    }
            } catch (HibernateException ex) {
                 mensaje = "* Paciente con código "+codPaciente +", no se pudo registrar." ;
                log.error("Se generó errores al ingresar paciente:"+ ex);
            } catch (Exception ex) {
                 mensaje = "* Paciente con código "+codPaciente +", no se pudo registrar." ;
                log.error("Se generó errores al ingresar paciente:"+ ex);
            }
        }else{
           
            try {
                updatePaciente();
                result=1;
                 mensaje = "* Paciente con código "+codPaciente +", se actualizó satisfactoriamente." ;
            } catch (HibernateException ex) {
                mensaje = "* Paciente con código "+codPaciente +", no se pudo actualizar." ;
                System.out.println("Se generó errores al actualizar paciente:"+ ex);
                log.error("Se generó errores al actualizar paciente:"+ ex);
            } catch (Exception ex) {
                mensaje = "* Paciente con código "+codPaciente +", no se pudo actualizar." ;
                System.out.println("Se generó errores al actualizar paciente:"+ ex);
                log.error("Se generó errores al actualizar paciente:"+ ex);
            }
        }
        this.listPacienteAll();
        
        
    }

    public void updatePaciente() throws HibernateException, Exception {
            Paciente paciente = new Paciente();
            System.out.println("codPaciente::"+codPaciente);
            paciente.setCodPaciente(codPaciente);
            paciente.setNombre1(nombre1);
            paciente.setNombre2(nombre2);
            paciente.setApPaterno(apPaterno);
            paciente.setApMaterno(apMaterno);
            paciente.setFechaNacimiento(fechaNacimiento);
            paciente.setFechaIngreso(fechaIngreso);
            paciente.setTelefono(telefono);
            paciente.setDireccion(direccion);
            sexo=new Sexo(codSexo, descSexo);
            paciente.setSexo(sexo);
            paciente.setEstado('1');
            paciente.setEmail(email);
            ocupacion =new Ocupacion();
            ocupacion.setCodOcupacion(this.idOcupacion);
            ocupacion.setDescripcion(descOcupacion);
            paciente.setOcupacion(ocupacion);
            TipoPaciente tipPaciente=new TipoPaciente();
            tipPaciente.setIdTipoPaciente(this.idTipoPac);
            paciente.setTipoPaciente(tipPaciente);
            Estacivil estaCivil=new Estacivil();
            estaCivil.setCodEstacivil(idEstaCivil);
            paciente.setEstacivil(estaCivil);
            Instruccion instruccion=new Instruccion();
            instruccion.setCodInstruccion(idInstruccion);
            paciente.setInstruccion(instruccion);
            Distrito distrito =new Distrito();
            distrito.setCodDistrito(codDistrito);
            paciente.setDistrito(distrito);
            PacienteDB pacienteDB = new PacienteDB();
        
        pacienteDB.updatePaciente(paciente, codPaciente);
    }

    public void deletePaciente() throws HibernateException, Exception {

        String codPaciente="";
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();

            Map params = externalContext.getRequestParameterMap();
            codPaciente = (String) params.get("formPers:codPaciente");
        } catch (Exception e) {
            System.out.println("Error al capturar parametro codPaciente:" + e.getMessage());
        }
        System.out.println("codPaciente:" + codPaciente);

        PacienteDB pcteDB = new PacienteDB();
        Paciente pcte = pcteDB.getPacienteByCod(codPaciente);
       
        if(pcte !=null){
            pcte.setEstado('0');
            pcteDB.desactivarPaciente(pcte);
            this.mensaje = "* Paciente con código "+codPaciente +", se eliminó correctamente." ;
         }
        else{
            this.mensaje = "* Paciente con código "+codPaciente +", no se pudo eliminar." ;
            
        }
            
    }

    public void pintarFrmPcte() {

        System.out.println("codigo personal: " +this.editPaciente.getCodPaciente());
       // Paciente pcte = null;
        //PacienteDB persDB = new PacienteDB();
        //pcte = persDB.getPacienteByCod(codPaciente);
        // if(pcte != null){
        if(this.editPaciente != null){
            this.codPaciente = editPaciente.getCodPaciente();
            this.nombre1 = editPaciente.getNombre1();
            this.nombre2=editPaciente.getNombre2();
            this.apPaterno = editPaciente.getApPaterno();
            this.apMaterno = editPaciente.getApMaterno();
            this.direccion = editPaciente.getDireccion();
            this.fechaNacimiento = editPaciente.getFechaNacimiento();
            this.fechaIngreso=editPaciente.getFechaIngreso();
            this.telefono=editPaciente.getTelefono();
            this.email=editPaciente.getEmail();
           
            this.ocupacion=editPaciente.getOcupacion();
            this.sexo = editPaciente.getSexo();
            this.codSexo=editPaciente.getSexo().getCodSexo();
            this.idOcupacion=editPaciente.getOcupacion().getCodOcupacion();
            this.descOcupacion=editPaciente.getOcupacion().getDescripcion();
            this.idEstaCivil=editPaciente.getEstacivil().getCodEstacivil();
            this.idInstruccion=editPaciente.getInstruccion().getCodInstruccion();
            this.idTipoPac=editPaciente.getTipoPaciente().getIdTipoPaciente();
            this.codDpto=editPaciente.getDistrito().getProvincia().getDepartamento().getCodDepa();
            this.codProv=editPaciente.getDistrito().getProvincia().getCodProvincia();
            this.codDistrito=editPaciente.getDistrito().getCodDistrito();
            //Activamos opcion para guardar
            getOpcSave();
        }
       

    }
    
    
    public void pintarFormSex() {

        System.out.println("codigo idSexo: " + codSexo);
        Sexo sex = null;
        List<Sexo> listSexo;
        SexoDB sexoDB = new SexoDB();
        listSexo = sexoDB.getSexoByCod(codSexo);
        for (Sexo o : listSexo) {
            sex = o;
        }
        if(sex != null){
        this.codSexo = sex.getCodSexo();
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
    
    
    public void pintarFrmDpto() {

        System.out.println("Código Departamento: " + codDpto);
        Departamento departamento = null;
        DepartamentoDB departamentoDB = new DepartamentoDB();
        departamento = departamentoDB.getDepartamentoById(codDpto);
        
        if(departamento != null){
            this.codDpto = departamento.getCodDepa();
            this.descDpto = departamento.getDesDepa();
            this.codProv=null;
            this.codDistrito=null;
            //Activamos opcion para guardar
            //getOpcSave();
        }
     }
    
    public void pintarFrmProv() {

        System.out.println("Código Provincia: " + codProv);
        Provincia prov = null;
        ProvinciaDB ProvinciaDB = new ProvinciaDB();
        prov = ProvinciaDB.getProvinciaById(codProv);
        
        if(prov != null){
            this.codProv = prov.getCodProvincia();
            this.descProv = prov.getDesProvincia();
            ///this.codDpto=prov.getDepartamento().getCodDepa();
            //Activamos opcion para guardar
            //getOpcSave();
        }
     }
    
    public void pintarFrmDistrito() {

        System.out.println("Código Distrito: " + codDistrito);
        Distrito distrito = null;
        DistritoDB ditritoDB = new DistritoDB();
        distrito = ditritoDB.getDistritoById(codDistrito);
        
        if(distrito != null){
            this.codDistrito = distrito.getCodDistrito();
            this.descProv = distrito.getDesDistrito();
            ///this.codDpto=prov.getDepartamento().getCodDepa();
            //Activamos opcion para guardar
            //getOpcSave();
        }
     }
    
    public void pintarFrmTipoPaciente() {

        System.out.println("codigo tipopaciente: " + idTipoPac);
        TipoPaciente tipoPaciente = null;
        TipoPacienteDB tipoPacienteDB = new TipoPacienteDB();
        tipoPaciente = tipoPacienteDB.getTipoPacienteById(idTipoPac);
        
        if(tipoPaciente != null){
            this.idTipoPac = tipoPaciente.getIdTipoPaciente();
            this.descTipPac= tipoPaciente.getDescripcion();
            
            
           
        }
    }
    
     public void pintarFrmEstaCivil() {

        System.out.println("Código Estado Civil: " + idEstaCivil);
        Estacivil estaCivil = null;
        EstaCivilDB departamentoDB = new EstaCivilDB();
        estaCivil = departamentoDB.getEstaCivilById(idEstaCivil);
        
        if(estaCivil != null){
            this.idEstaCivil = estaCivil.getCodEstacivil();
            this.descEstaCivil = estaCivil.getDescripcion();
          }
     }
     
     
     public void pintarFrmInstruccion() {

        System.out.println("Código Instruccion: " + idInstruccion);
        Instruccion instruccion = null;
        InstruccionDB instruccionDB = new InstruccionDB();
        instruccion = instruccionDB.getInstruccionById(idInstruccion);
        
        if(instruccion != null){
            this.idInstruccion = instruccion.getCodInstruccion();
            this.descInstruccion = instruccion.getDescripcion();
          }
     }
    
    public void getOpcSave(){
         this.opcionSave=1;
         System.out.println("opcionSave:"+opcionSave);
         this.mensaje="";
    }
    
    public void getOpcNew(){
         this.opcionSave=0;
         System.out.println("opcionSave:"+opcionSave);
         clearFrmPaciente();
         //this.mensaje="";
    }
    
    
    public void clearFrmPaciente(){
        this.codPaciente=null;
        this.codDistrito=null;
        this.codDpto=null;
        this.codProv=null;
        this.codSexo=null;
        this.apMaterno=null;
        this.apPaterno=null;
        this.descDistrito=null;
        this.descDpto=null;
        this.descEstaCivil=null;
        this.descInstruccion=null;
        this.descOcupacion=null;
        this.descProv=null;
        this.descSexo=null;
        this.descTipPac=null;
        this.direccion=null;
        this.dni=null;
        this.email=null;
        this.fechaIngreso=null;
        this.fechaNacimiento=null;
        this.foto=null;
        this.idEstaCivil=null;
        this.idInstruccion=null;
        this.idOcupacion=null;
        this.idTipoPac=null;
        this.mensaje=null;
        this.nombre1=null;
        this.nombre2=null;
        this.ocupacion=null;
        this.sexo=null;
        this.telefono=null;
       
    }
    
}

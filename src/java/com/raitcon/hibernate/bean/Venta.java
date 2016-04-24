package com.raitcon.hibernate.bean;
// Generated 23/04/2016 06:58:33 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Venta generated by hbm2java
 */
@Entity
@Table(name="venta"
    ,catalog="db_laboratorio"
)
public class Venta  implements java.io.Serializable {


     private String codCompVenta;
     private Procedencia procedencia;
     private TipoPago tipoPago;
     private TipoDocumento tipoDocumento;
     private String talonario;
     private String codVenta;
     private int ejercicio;
     private Character estadoProceso;
     private String codPaciente;
     private String ruc;
     private Character estado;
     private Date fecha;
     private Integer codPersonal;
     private Set<DetVenta> detVentas = new HashSet<DetVenta>(0);

    public Venta() {
    }

	
    public Venta(String codCompVenta, TipoDocumento tipoDocumento, String talonario, String codVenta, int ejercicio, String ruc) {
        this.codCompVenta = codCompVenta;
        this.tipoDocumento = tipoDocumento;
        this.talonario = talonario;
        this.codVenta = codVenta;
        this.ejercicio = ejercicio;
        this.ruc = ruc;
    }
    public Venta(String codCompVenta, Procedencia procedencia, TipoPago tipoPago, TipoDocumento tipoDocumento, String talonario, String codVenta, int ejercicio, Character estadoProceso, String codPaciente, String ruc, Character estado, Date fecha, Integer codPersonal, Set<DetVenta> detVentas) {
       this.codCompVenta = codCompVenta;
       this.procedencia = procedencia;
       this.tipoPago = tipoPago;
       this.tipoDocumento = tipoDocumento;
       this.talonario = talonario;
       this.codVenta = codVenta;
       this.ejercicio = ejercicio;
       this.estadoProceso = estadoProceso;
       this.codPaciente = codPaciente;
       this.ruc = ruc;
       this.estado = estado;
       this.fecha = fecha;
       this.codPersonal = codPersonal;
       this.detVentas = detVentas;
    }
   
     @Id 
    
    @Column(name="cod_comp_venta", unique=true, nullable=false, length=20)
    public String getCodCompVenta() {
        return this.codCompVenta;
    }
    
    public void setCodCompVenta(String codCompVenta) {
        this.codCompVenta = codCompVenta;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_procedencia")
    public Procedencia getProcedencia() {
        return this.procedencia;
    }
    
    public void setProcedencia(Procedencia procedencia) {
        this.procedencia = procedencia;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_tipo_pago")
    public TipoPago getTipoPago() {
        return this.tipoPago;
    }
    
    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tipo_documento", nullable=false)
    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }
    
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
    @Column(name="talonario", nullable=false, length=5)
    public String getTalonario() {
        return this.talonario;
    }
    
    public void setTalonario(String talonario) {
        this.talonario = talonario;
    }
    
    @Column(name="cod_venta", nullable=false, length=20)
    public String getCodVenta() {
        return this.codVenta;
    }
    
    public void setCodVenta(String codVenta) {
        this.codVenta = codVenta;
    }
    
    @Column(name="ejercicio", nullable=false)
    public int getEjercicio() {
        return this.ejercicio;
    }
    
    public void setEjercicio(int ejercicio) {
        this.ejercicio = ejercicio;
    }
    
    @Column(name="estado_proceso", length=1)
    public Character getEstadoProceso() {
        return this.estadoProceso;
    }
    
    public void setEstadoProceso(Character estadoProceso) {
        this.estadoProceso = estadoProceso;
    }
    
    @Column(name="cod_paciente", length=11)
    public String getCodPaciente() {
        return this.codPaciente;
    }
    
    public void setCodPaciente(String codPaciente) {
        this.codPaciente = codPaciente;
    }
    
    @Column(name="ruc", nullable=false, length=11)
    public String getRuc() {
        return this.ruc;
    }
    
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    
    @Column(name="estado", length=1)
    public Character getEstado() {
        return this.estado;
    }
    
    public void setEstado(Character estado) {
        this.estado = estado;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha", length=19)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    @Column(name="cod_personal")
    public Integer getCodPersonal() {
        return this.codPersonal;
    }
    
    public void setCodPersonal(Integer codPersonal) {
        this.codPersonal = codPersonal;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="venta")
    public Set<DetVenta> getDetVentas() {
        return this.detVentas;
    }
    
    public void setDetVentas(Set<DetVenta> detVentas) {
        this.detVentas = detVentas;
    }




}



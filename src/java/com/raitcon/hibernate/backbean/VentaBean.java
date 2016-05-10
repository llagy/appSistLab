/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;

import com.raitcon.hibernate.bean.DetVenta;
import com.raitcon.hibernate.bean.Paciente;
import com.raitcon.hibernate.bean.Personal;
import com.raitcon.hibernate.bean.Procedencia;
import com.raitcon.hibernate.bean.TipoPago;
import com.raitcon.hibernate.bean.Venta;
import com.raitcon.hibernate.db.VentaDB;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author mriverar
 */
@ManagedBean(name = "ventaBean")
@ViewScoped
public class VentaBean {
    
    private static final long serialVersionUID = -2377612760546575178L;
    protected static Logger log = Logger.getLogger(VentaBean.class);
    private String codCompVenta;
    private Venta venta;
    private String codVenta;
    private DetVenta detVenta;
    private String talonario;
    private Character estado;
    private Character estadoProc;
    private Paciente paciente;
    private Procedencia procedencia;
    private String ruc;
    private TipoPago tipoPago;
    private Date fecha ;
    private Personal personal;
    private Integer opcBoton;
    private List<Venta>listVenta;
    private List<DetVenta> listDetVenta;
    private Date fechaIni;
    private Date fechaFin;
    private BigDecimal total;
    private Integer ejercicio;
    
    public VentaBean(){
        System.out.println("Se instancia constructor de ventaBean");
        this.fechaFin=new Date();
        this.fechaIni=restarDiasFecha(this.fechaFin,-5);
        this.findVentaByFecha();
    }
    public String getCodCompVenta() {
        return codCompVenta;
    }

    public void setCodCompVenta(String codCompVenta) {
        this.codCompVenta = codCompVenta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public String getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(String codVenta) {
        this.codVenta = codVenta;
    }

    public DetVenta getDetVenta() {
        return detVenta;
    }

    public void setDetVenta(DetVenta detVenta) {
        this.detVenta = detVenta;
    }

    public String getTalonario() {
        return talonario;
    }

    public void setTalonario(String talonario) {
        this.talonario = talonario;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Character getEstadoProc() {
        return estadoProc;
    }

    public void setEstadoProc(Character estadoProc) {
        this.estadoProc = estadoProc;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Procedencia getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(Procedencia procedencia) {
        this.procedencia = procedencia;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Integer getOpcBoton() {
        return opcBoton;
    }

    public void setOpcBoton(Integer opcBoton) {
        this.opcBoton = opcBoton;
    }

    public List<Venta> getListVenta() {
        return listVenta;
    }

    public void setListVenta(List<Venta> listVenta) {
        this.listVenta = listVenta;
    }

    public List<DetVenta> getListDetVenta() {
        return listDetVenta;
    }

    public void setListDetVenta(List<DetVenta> listDetVenta) {
        this.listDetVenta = listDetVenta;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Integer ejercicio) {
        this.ejercicio = ejercicio;
    }
    
    
    public void findVentaByFecha(){
        //this.codCompVenta=venta.getCodCompVenta();
        log.info("Buscamos todos las Ventas en rango de fechas");
        System.out.println("fecha ini"+this.fechaIni);
        System.out.println("fecha fin"+this.fechaFin);
        VentaDB estudioDB=new VentaDB();
        
        this.listVenta=estudioDB.findVentasByFecha(fechaIni, fechaFin);
       
   }
    
    public static Date restarDiasFecha(Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE,dias);
        return new Date(cal.getTimeInMillis());
    }
    
}

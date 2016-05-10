package com.raitcon.hibernate.bean;
// Generated 09/05/2016 10:48:05 PM by Hibernate Tools 3.2.1.GA



import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TipoPago generated by hbm2java
 */
@Entity
@Table(name="tipo_pago"
    ,catalog="db_laboratorio"
)
public class TipoPago  implements java.io.Serializable {


     private int idTipoPago;
     private String descripcion;
     private Set<Venta> ventas = new HashSet<Venta>(0);

    public TipoPago() {
    }

	
    public TipoPago(int idTipoPago, String descripcion) {
        this.idTipoPago = idTipoPago;
        this.descripcion = descripcion;
    }
    public TipoPago(int idTipoPago, String descripcion, Set<Venta> ventas) {
       this.idTipoPago = idTipoPago;
       this.descripcion = descripcion;
       this.ventas = ventas;
    }
   
     @Id 
    
    @Column(name="id_tipo_pago", unique=true, nullable=false)
    public int getIdTipoPago() {
        return this.idTipoPago;
    }
    
    public void setIdTipoPago(int idTipoPago) {
        this.idTipoPago = idTipoPago;
    }
    
    @Column(name="descripcion", nullable=false, length=45)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="tipoPago")
    public Set<Venta> getVentas() {
        return this.ventas;
    }
    
    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }




}



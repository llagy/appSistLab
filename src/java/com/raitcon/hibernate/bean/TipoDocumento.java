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
 * TipoDocumento generated by hbm2java
 */
@Entity
@Table(name="tipo_documento"
    ,catalog="db_laboratorio"
)
public class TipoDocumento  implements java.io.Serializable {


     private int idTipoDocumento;
     private String descripcion;
     private Set<Venta> ventas = new HashSet<Venta>(0);

    public TipoDocumento() {
    }

	
    public TipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }
    public TipoDocumento(int idTipoDocumento, String descripcion, Set<Venta> ventas) {
       this.idTipoDocumento = idTipoDocumento;
       this.descripcion = descripcion;
       this.ventas = ventas;
    }
   
     @Id 
    
    @Column(name="id_tipo_documento", unique=true, nullable=false)
    public int getIdTipoDocumento() {
        return this.idTipoDocumento;
    }
    
    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }
    
    @Column(name="descripcion", length=45)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="tipoDocumento")
    public Set<Venta> getVentas() {
        return this.ventas;
    }
    
    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }




}



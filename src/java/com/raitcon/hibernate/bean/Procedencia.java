package com.raitcon.hibernate.bean;
// Generated 09/05/2016 10:48:05 PM by Hibernate Tools 3.2.1.GA



import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Procedencia generated by hbm2java
 */
@Entity
@Table(name="procedencia"
    ,catalog="db_laboratorio"
)
public class Procedencia  implements java.io.Serializable {


     private Integer idProcedencia;
     private String descripcion;
     private Set<Venta> ventas = new HashSet<Venta>(0);

    public Procedencia() {
    }

    public Procedencia(String descripcion, Set<Venta> ventas) {
       this.descripcion = descripcion;
       this.ventas = ventas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_procedencia", unique=true, nullable=false)
    public Integer getIdProcedencia() {
        return this.idProcedencia;
    }
    
    public void setIdProcedencia(Integer idProcedencia) {
        this.idProcedencia = idProcedencia;
    }
    
    @Column(name="descripcion", length=45)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="procedencia")
    public Set<Venta> getVentas() {
        return this.ventas;
    }
    
    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }




}



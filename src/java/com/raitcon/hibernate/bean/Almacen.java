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
 * Almacen generated by hbm2java
 */
@Entity
@Table(name="almacen"
    ,catalog="db_laboratorio"
)
public class Almacen  implements java.io.Serializable {


     private int idAlmacen;
     private String nombre;
     private Integer codDistrito;
     private String estado;
     private Set<Insumo> insumos = new HashSet<Insumo>(0);
     private Set<Insumo> insumos_1 = new HashSet<Insumo>(0);

    public Almacen() {
    }

	
    public Almacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }
    public Almacen(int idAlmacen, String nombre, Integer codDistrito, String estado, Set<Insumo> insumos, Set<Insumo> insumos_1) {
       this.idAlmacen = idAlmacen;
       this.nombre = nombre;
       this.codDistrito = codDistrito;
       this.estado = estado;
       this.insumos = insumos;
       this.insumos_1 = insumos_1;
    }
   
     @Id 
    
    @Column(name="id_almacen", unique=true, nullable=false)
    public int getIdAlmacen() {
        return this.idAlmacen;
    }
    
    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }
    
    @Column(name="nombre", length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Column(name="cod_distrito")
    public Integer getCodDistrito() {
        return this.codDistrito;
    }
    
    public void setCodDistrito(Integer codDistrito) {
        this.codDistrito = codDistrito;
    }
    
    @Column(name="estado", length=45)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="almacen")
    public Set<Insumo> getInsumos() {
        return this.insumos;
    }
    
    public void setInsumos(Set<Insumo> insumos) {
        this.insumos = insumos;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="almacen")
    public Set<Insumo> getInsumos_1() {
        return this.insumos_1;
    }
    
    public void setInsumos_1(Set<Insumo> insumos_1) {
        this.insumos_1 = insumos_1;
    }




}



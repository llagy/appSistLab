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
 * Marca generated by hbm2java
 */
@Entity
@Table(name="marca"
    ,catalog="db_laboratorio"
)
public class Marca  implements java.io.Serializable {


     private int idMarca;
     private String descripcion;
     private Character estado;
     private Set<Insumo> insumos = new HashSet<Insumo>(0);

    public Marca() {
    }

	
    public Marca(int idMarca) {
        this.idMarca = idMarca;
    }
    public Marca(int idMarca, String descripcion, Character estado, Set<Insumo> insumos) {
       this.idMarca = idMarca;
       this.descripcion = descripcion;
       this.estado = estado;
       this.insumos = insumos;
    }
   
     @Id 
    
    @Column(name="id_marca", unique=true, nullable=false)
    public int getIdMarca() {
        return this.idMarca;
    }
    
    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }
    
    @Column(name="descripcion", length=45)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Column(name="estado", length=1)
    public Character getEstado() {
        return this.estado;
    }
    
    public void setEstado(Character estado) {
        this.estado = estado;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="marca")
    public Set<Insumo> getInsumos() {
        return this.insumos;
    }
    
    public void setInsumos(Set<Insumo> insumos) {
        this.insumos = insumos;
    }




}



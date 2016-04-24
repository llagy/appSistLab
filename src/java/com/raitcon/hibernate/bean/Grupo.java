package com.raitcon.hibernate.bean;
// Generated 23/04/2016 06:58:33 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Grupo generated by hbm2java
 */
@Entity
@Table(name="grupo"
    ,catalog="db_laboratorio"
    , uniqueConstraints = @UniqueConstraint(columnNames="estado") 
)
public class Grupo  implements java.io.Serializable {


     private int idGrupo;
     private String descripcion;
     private Integer estado;
     private Set<Clase> clases = new HashSet<Clase>(0);

    public Grupo() {
    }

	
    public Grupo(int idGrupo, String descripcion) {
        this.idGrupo = idGrupo;
        this.descripcion = descripcion;
    }
    public Grupo(int idGrupo, String descripcion, Integer estado, Set<Clase> clases) {
       this.idGrupo = idGrupo;
       this.descripcion = descripcion;
       this.estado = estado;
       this.clases = clases;
    }
   
     @Id 
    
    @Column(name="id_grupo", unique=true, nullable=false)
    public int getIdGrupo() {
        return this.idGrupo;
    }
    
    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }
    
    @Column(name="descripcion", nullable=false, length=60)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Column(name="estado", unique=true)
    public Integer getEstado() {
        return this.estado;
    }
    
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="grupo")
    public Set<Clase> getClases() {
        return this.clases;
    }
    
    public void setClases(Set<Clase> clases) {
        this.clases = clases;
    }




}



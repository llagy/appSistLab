package com.raitcon.hibernate.bean;
// Generated 23/04/2016 11:00:37 PM by Hibernate Tools 3.2.1.GA


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
 * Autoanalizador generated by hbm2java
 */
@Entity
@Table(name="autoanalizador"
    ,catalog="db_laboratorio"
)
public class Autoanalizador  implements java.io.Serializable {


     private Integer idAutoanalizador;
     private String descripcion;
     private Character estado;
     private Set<Prueba> pruebas = new HashSet<Prueba>(0);
     private Set<Prueba> pruebas_1 = new HashSet<Prueba>(0);

    public Autoanalizador() {
    }

	
    public Autoanalizador(String descripcion) {
        this.descripcion = descripcion;
    }
    public Autoanalizador(String descripcion, Character estado, Set<Prueba> pruebas, Set<Prueba> pruebas_1) {
       this.descripcion = descripcion;
       this.estado = estado;
       this.pruebas = pruebas;
       this.pruebas_1 = pruebas_1;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_autoanalizador", unique=true, nullable=false)
    public Integer getIdAutoanalizador() {
        return this.idAutoanalizador;
    }
    
    public void setIdAutoanalizador(Integer idAutoanalizador) {
        this.idAutoanalizador = idAutoanalizador;
    }
    
    @Column(name="descripcion", nullable=false, length=45)
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
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="autoanalizador")
    public Set<Prueba> getPruebas() {
        return this.pruebas;
    }
    
    public void setPruebas(Set<Prueba> pruebas) {
        this.pruebas = pruebas;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="autoanalizador")
    public Set<Prueba> getPruebas_1() {
        return this.pruebas_1;
    }
    
    public void setPruebas_1(Set<Prueba> pruebas_1) {
        this.pruebas_1 = pruebas_1;
    }




}



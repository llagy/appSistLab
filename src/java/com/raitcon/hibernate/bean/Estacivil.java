package com.raitcon.hibernate.bean;
// Generated 25/03/2016 09:41:30 AM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Estacivil generated by hbm2java
 */
@Entity
@Table(name="estacivil"
    ,catalog="db_laboratorio"
)
public class Estacivil  implements java.io.Serializable {


     private Integer codEstacivil;
     private String descripcion;

    public Estacivil() {
    }

    public Estacivil(String descripcion) {
       this.descripcion = descripcion;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="cod_estacivil", unique=true, nullable=false)
    public Integer getCodEstacivil() {
        return this.codEstacivil;
    }
    
    public void setCodEstacivil(Integer codEstacivil) {
        this.codEstacivil = codEstacivil;
    }
    
    @Column(name="descripcion", length=80)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}



package com.raitcon.hibernate.bean;
// Generated 25/03/2016 09:41:30 AM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Instruccion generated by hbm2java
 */
@Entity
@Table(name="instruccion"
    ,catalog="db_laboratorio"
)
public class Instruccion  implements java.io.Serializable {


     private int codInstruccion;
     private String descripcion;

    public Instruccion() {
    }

	
    public Instruccion(int codInstruccion) {
        this.codInstruccion = codInstruccion;
    }
    public Instruccion(int codInstruccion, String descripcion) {
       this.codInstruccion = codInstruccion;
       this.descripcion = descripcion;
    }
   
     @Id 
    
    @Column(name="cod_instruccion", unique=true, nullable=false)
    public int getCodInstruccion() {
        return this.codInstruccion;
    }
    
    public void setCodInstruccion(int codInstruccion) {
        this.codInstruccion = codInstruccion;
    }
    
    @Column(name="descripcion", length=45)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}


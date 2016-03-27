package com.raitcon.hibernate.bean;
// Generated 25/03/2016 09:18:59 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sexo generated by hbm2java
 */
@Entity
@Table(name="sexo"
    ,catalog="db_laboratorio"
)
public class Sexo  implements java.io.Serializable {


     private char codSexo;
     private String descripcion;

    public Sexo() {
    }

    public Sexo(char codSexo, String descripcion) {
       this.codSexo = codSexo;
       this.descripcion = descripcion;
    }
   
     @Id 
    
    @Column(name="cod_sexo", unique=true, nullable=false, length=1)
    public char getCodSexo() {
        return this.codSexo;
    }
    
    public void setCodSexo(char codSexo) {
        this.codSexo = codSexo;
    }
    
    @Column(name="descripcion", nullable=false, length=45)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}


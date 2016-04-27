package com.raitcon.hibernate.bean;
// Generated 23/04/2016 11:00:37 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Prueba generated by hbm2java
 */
@Entity
@Table(name="prueba"
    ,catalog="db_laboratorio"
)
public class Prueba  implements java.io.Serializable {


     private int idPrueba;
     private TipoResultado tipoResultado;
     private Estudio estudio;
     private Autoanalizador autoanalizador;
     private String descripcion;
     private String resultadoDefect;
     private String undMedida;
     private String resultado2;
     private String resultado3;
     private String resultado4;
     private String resultado5;
     private String resultado6;
     private String resultado7;
     private String resultado8;
     private String resultado9;
     private Character estado;
     private String nombreReal;
     private Set<PruebaValRef> pruebaValRefs = new HashSet<PruebaValRef>(0);
     private Set<PruebaValRef> pruebaValRefs_1 = new HashSet<PruebaValRef>(0);

    public Prueba() {
    }

	
    public Prueba(int idPrueba, Estudio estudio, String resultadoDefect) {
        this.idPrueba = idPrueba;
        this.estudio = estudio;
        this.resultadoDefect = resultadoDefect;
    }
    public Prueba(int idPrueba, TipoResultado tipoResultado, Estudio estudio, Autoanalizador autoanalizador, String descripcion, String resultadoDefect, String undMedida, String resultado2, String resultado3, String resultado4, String resultado5, String resultado6, String resultado7, String resultado8, String resultado9, Character estado, String nombreReal, Set<PruebaValRef> pruebaValRefs, Set<PruebaValRef> pruebaValRefs_1) {
       this.idPrueba = idPrueba;
       this.tipoResultado = tipoResultado;
       this.estudio = estudio;
       this.autoanalizador = autoanalizador;
       this.descripcion = descripcion;
       this.resultadoDefect = resultadoDefect;
       this.undMedida = undMedida;
       this.resultado2 = resultado2;
       this.resultado3 = resultado3;
       this.resultado4 = resultado4;
       this.resultado5 = resultado5;
       this.resultado6 = resultado6;
       this.resultado7 = resultado7;
       this.resultado8 = resultado8;
       this.resultado9 = resultado9;
       this.estado = estado;
       this.nombreReal = nombreReal;
       this.pruebaValRefs = pruebaValRefs;
       this.pruebaValRefs_1 = pruebaValRefs_1;
    }
   
     @Id 
    
    @Column(name="id_prueba", unique=true, nullable=false)
    public int getIdPrueba() {
        return this.idPrueba;
    }
    
    public void setIdPrueba(int idPrueba) {
        this.idPrueba = idPrueba;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_tipo_resultado")
    public TipoResultado getTipoResultado() {
        return this.tipoResultado;
    }
    
    public void setTipoResultado(TipoResultado tipoResultado) {
        this.tipoResultado = tipoResultado;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_estudio", nullable=false)
    public Estudio getEstudio() {
        return this.estudio;
    }
    
    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_autoanalizador")
    public Autoanalizador getAutoanalizador() {
        return this.autoanalizador;
    }
    
    public void setAutoanalizador(Autoanalizador autoanalizador) {
        this.autoanalizador = autoanalizador;
    }
    
    @Column(name="descripcion", length=80)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Column(name="resultado_defect",length=300)
    public String getResultadoDefect() {
        return this.resultadoDefect;
    }
    
    public void setResultadoDefect(String resultadoDefect) {
        this.resultadoDefect = resultadoDefect;
    }
    
    @Column(name="und_medida", length=15)
    public String getUndMedida() {
        return this.undMedida;
    }
    
    public void setUndMedida(String undMedida) {
        this.undMedida = undMedida;
    }
    
    @Column(name="resultado2", length=100)
    public String getResultado2() {
        return this.resultado2;
    }
    
    public void setResultado2(String resultado2) {
        this.resultado2 = resultado2;
    }
    
    @Column(name="resultado3", length=100)
    public String getResultado3() {
        return this.resultado3;
    }
    
    public void setResultado3(String resultado3) {
        this.resultado3 = resultado3;
    }
    
    @Column(name="resultado4", length=100)
    public String getResultado4() {
        return this.resultado4;
    }
    
    public void setResultado4(String resultado4) {
        this.resultado4 = resultado4;
    }
    
    @Column(name="resultado5", length=100)
    public String getResultado5() {
        return this.resultado5;
    }
    
    public void setResultado5(String resultado5) {
        this.resultado5 = resultado5;
    }
    
    @Column(name="resultado6", length=100)
    public String getResultado6() {
        return this.resultado6;
    }
    
    public void setResultado6(String resultado6) {
        this.resultado6 = resultado6;
    }
    
    @Column(name="resultado7", length=100)
    public String getResultado7() {
        return this.resultado7;
    }
    
    public void setResultado7(String resultado7) {
        this.resultado7 = resultado7;
    }
    
    @Column(name="resultado8", length=100)
    public String getResultado8() {
        return this.resultado8;
    }
    
    public void setResultado8(String resultado8) {
        this.resultado8 = resultado8;
    }
    
    @Column(name="resultado9", length=100)
    public String getResultado9() {
        return this.resultado9;
    }
    
    public void setResultado9(String resultado9) {
        this.resultado9 = resultado9;
    }
    
    @Column(name="estado", length=1)
    public Character getEstado() {
        return this.estado;
    }
    
    public void setEstado(Character estado) {
        this.estado = estado;
    }
    
    @Column(name="nombre_real", length=100)
    public String getNombreReal() {
        return this.nombreReal;
    }
    
    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="prueba")
    public Set<PruebaValRef> getPruebaValRefs() {
        return this.pruebaValRefs;
    }
    
    public void setPruebaValRefs(Set<PruebaValRef> pruebaValRefs) {
        this.pruebaValRefs = pruebaValRefs;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="prueba")
    public Set<PruebaValRef> getPruebaValRefs_1() {
        return this.pruebaValRefs_1;
    }
    
    public void setPruebaValRefs_1(Set<PruebaValRef> pruebaValRefs_1) {
        this.pruebaValRefs_1 = pruebaValRefs_1;
    }




}



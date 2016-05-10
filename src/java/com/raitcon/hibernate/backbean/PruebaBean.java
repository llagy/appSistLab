/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;

import com.raitcon.hibernate.bean.Estudio;
import com.raitcon.hibernate.bean.Prueba;
import com.raitcon.hibernate.bean.ValRef;
//import com.raitcon.hibernate.bean.PruebaValRef;
import com.raitcon.hibernate.db.PruebaDB;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author mriverar
 */
@ManagedBean(name = "pruebaBean")
@ViewScoped
public class PruebaBean implements Serializable {
    
    private static final long serialVersionUID = -2377612760546575178L;
    protected static Logger log = Logger.getLogger(PruebaBean.class);
    
    private Integer idEstudio;
    private Estudio estudio;
    private Prueba prueba;
    private Integer idPrueba;
    private String descripcion;
    private String unidMedida;
    private String nameReal;
    private BigDecimal precio1;
    private BigDecimal precio2;
    private BigDecimal precio3;
    private BigDecimal precio4;
    private Character estado;
    private String resulDefect;
    private String result1;
    private String result2;
    private String result3;
    private String result4;
    private String result5;
    private String result6;
    private String result7;
    private String result8;
    private String result9;
    private Integer idTipoResultado;
    private Integer idAutoanalizador;
    private Integer opcBoton;
    private List<Prueba> listPrueba;
   private List<ValRef>listValRef;
    
    public PruebaBean(){
        System.out.println("Se instancia constructor de pruebaBean");
    }
    public Integer getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(Integer idEstudio) {
        this.idEstudio = idEstudio;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getUnidMedida() {
        return unidMedida;
    }

    public void setUnidMedida(String unidMedida) {
        this.unidMedida = unidMedida;
    }

    
    public Integer getIdPrueba() {
        return idPrueba;
    }

    public void setIdPrueba(Integer idPrueba) {
        this.idPrueba = idPrueba;
    }
    
    

    public String getNameReal() {
        return nameReal;
    }

    public void setNameReal(String nameReal) {
        this.nameReal = nameReal;
    }

    public BigDecimal getPrecio1() {
        return precio1;
    }

    public void setPrecio1(BigDecimal precio1) {
        this.precio1 = precio1;
    }

    public BigDecimal getPrecio2() {
        return precio2;
    }

    public void setPrecio2(BigDecimal precio2) {
        this.precio2 = precio2;
    }

    public BigDecimal getPrecio3() {
        return precio3;
    }

    public void setPrecio3(BigDecimal precio3) {
        this.precio3 = precio3;
    }

    public BigDecimal getPrecio4() {
        return precio4;
    }

    public void setPrecio4(BigDecimal precio4) {
        this.precio4 = precio4;
    }
    
    

    public String getResulDefect() {
        return resulDefect;
    }

    public void setResulDefect(String resulDefect) {
        this.resulDefect = resulDefect;
    }

    public String getResult1() {
        return result1;
    }

    public void setResult1(String result1) {
        this.result1 = result1;
    }

    public String getResult2() {
        return result2;
    }

    public void setResult2(String result2) {
        this.result2 = result2;
    }

    public String getResult3() {
        return result3;
    }

    public void setResult3(String result3) {
        this.result3 = result3;
    }

    public String getResult4() {
        return result4;
    }

    public void setResult4(String result4) {
        this.result4 = result4;
    }

    public String getResult5() {
        return result5;
    }

    public void setResult5(String result5) {
        this.result5 = result5;
    }

    public String getResult6() {
        return result6;
    }

    public void setResult6(String result6) {
        this.result6 = result6;
    }

    public String getResult7() {
        return result7;
    }

    public void setResult7(String result7) {
        this.result7 = result7;
    }

    public String getResult8() {
        return result8;
    }

    public void setResult8(String result8) {
        this.result8 = result8;
    }

    public String getResult9() {
        return result9;
    }

    public void setResult9(String result9) {
        this.result9 = result9;
    }

    public Integer getIdTipoResultado() {
        return idTipoResultado;
    }

    public void setIdTipoResultado(Integer idTipoResultado) {
        this.idTipoResultado = idTipoResultado;
    }

    public Integer getIdAutoanalizador() {
        return idAutoanalizador;
    }

    public void setIdAutoanalizador(Integer idAutoanalizador) {
        this.idAutoanalizador = idAutoanalizador;
    }

    public Prueba getPrueba() {
        return prueba;
    }

    public void setPrueba(Prueba prueba) {
        this.prueba = prueba;
    }

    public Integer getOpcBoton() {
        return opcBoton;
    }

    public void setOpcBoton(Integer opcBoton) {
        this.opcBoton = opcBoton;
    }
    
    

    public List<Prueba> getListPrueba() {
        return listPrueba;
    }

    public void setListPrueba(List<Prueba> listPrueba) {
        this.listPrueba = listPrueba;
    }

    public List<ValRef> getListValRef() {
        return listValRef;
    }

    public void setListPruebaValRef(List<ValRef> listValRef) {
        this.listValRef = listValRef;
    }

    
    
    
    public void findPruebaByEstudio(){ 
        this.idEstudio=estudio.getIdEstudio();
        log.info("Buscamos todas las pruebas que pertenezcan al código de estudio:"+idEstudio);
        PruebaDB pruebaDB=new PruebaDB();
        
        this.listPrueba=pruebaDB.findPruebasByEstudio(idEstudio);
        opcBoton=1;
   }
    
    public void frmPintarPrueba(){
        System.out.println("invocando frmPintarPrueba");
        this.idPrueba=prueba.getIdPrueba();
        this.descripcion=prueba.getDescripcion();
        this.resulDefect=prueba.getResultadoDefect();
        this.result1=prueba.getResultado1();
        this.result2=prueba.getResultado2();
        this.result3=prueba.getResultado3();
        this.result4=prueba.getResultado4();
        this.result5=prueba.getResultado5();
        this.result6=prueba.getResultado6();
        this.result7=prueba.getResultado7();
        this.result8=prueba.getResultado8();
        this.result9=prueba.getResultado9();
                
        listValRef=new ArrayList<ValRef>(prueba.getValRefs());
        
   }
    
    
    
}

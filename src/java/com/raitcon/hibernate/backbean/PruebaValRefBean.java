/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;

import static com.raitcon.hibernate.backbean.PruebaBean.log;
import com.raitcon.hibernate.bean.Prueba;
import com.raitcon.hibernate.bean.PruebaValRef;
import com.raitcon.hibernate.db.PruebaDB;
import com.raitcon.hibernate.db.PruebaValRefDB;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author mriverar
 */
@ManagedBean(name = "pruebaValRefBean")
@ViewScoped
public class PruebaValRefBean implements Serializable {
    private static final long serialVersionUID = -2377612760546575178L;
    protected static Logger log = Logger.getLogger(PruebaValRefBean.class);
    
    private Prueba prueba;
    private Integer idPrueba;
    private List<PruebaValRef> listPruebaValRefBean;
    
    
    public PruebaValRefBean(){
        System.out.println("Se instancia constructor de pruebaValRefBean");
    }

    public Prueba getPrueba() {
        return prueba;
    }

    public void setPrueba(Prueba prueba) {
        this.prueba = prueba;
    }

    public Integer getIdPrueba() {
        return idPrueba;
    }

    public void setIdPrueba(Integer idPrueba) {
        this.idPrueba = idPrueba;
    }

    public List<PruebaValRef> getListPruebaValRefBean() {
        return listPruebaValRefBean;
    }

    public void setListPruebaValRefBean(List<PruebaValRef> listPruebaValRefBean) {
        this.listPruebaValRefBean = listPruebaValRefBean;
    }
    
    
            
    public void findPruebaValRefByPrueba(){ 
        this.idPrueba=prueba.getIdPrueba();
        log.info("Buscamos todas los valores de referencias que pertenezcan al código de prueba:"+idPrueba);
        PruebaValRefDB pruebaValRefDB=new PruebaValRefDB();
        
        this.listPruebaValRefBean=pruebaValRefDB.findPruebaValRefByPrueba(idPrueba);
    
   }
}

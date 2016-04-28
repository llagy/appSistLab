/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.Prueba;
import com.raitcon.hibernate.bean.PruebaValRef;
import com.raitcon.hibernate.factory.HibernateSessionFactory;
import com.raitcon.hibernate.factory.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author mriverar
 */
public class PruebaValRefDB {
    
  protected static Logger log = Logger.getLogger(PruebaValRefDB.class);
     private Session session = null;
     
      public PruebaValRefDB() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }  
    
     public List<PruebaValRef> findPruebaValRefByPrueba(Integer idPrueba) {
        List<PruebaValRef> estudioList = null;
        try {
            System.out.println("metodo findPruebaValRefByPrueba");
            session = HibernateSessionFactory.getSession();
            Query q = session.createQuery("from PruebaValRef as pruebaValRef WHERE id_prueba="+idPrueba);
            estudioList = (List<PruebaValRef>) q.list();
        } catch (Exception e) {
            log.debug("Error findPruebaValRefByPrueba:"+e.getMessage() );
            e.printStackTrace();
        }
        return estudioList;
    }  
    
    
}

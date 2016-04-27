/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.Estudio;
import com.raitcon.hibernate.bean.Prueba;
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
public class PruebaDB {
   
   protected static Logger log = Logger.getLogger(PruebaDB.class);
     private Session session = null;
     
      public PruebaDB() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }  
    
     public List<Prueba> findPruebasByEstudio(Integer idEstudio) {
        List<Prueba> estudioList = null;
        try {
            System.out.println("metodo findPruebasByEstudio");
            session = HibernateSessionFactory.getSession();
            Query q = session.createQuery("from Prueba as prueba WHERE id_estudio="+idEstudio);
            estudioList = (List<Prueba>) q.list();
        } catch (Exception e) {
            log.debug("Error findPruebasByEstudio:"+e.getMessage() );
            e.printStackTrace();
        }
        return estudioList;
    }
}

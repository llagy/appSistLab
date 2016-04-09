/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.Distrito;
import com.raitcon.hibernate.factory.HibernateSessionFactory;
import com.raitcon.hibernate.factory.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Guillermo Lap
 */
public class DistritoDB {
     protected static Logger log = Logger.getLogger(DistritoDB.class);
    private Session session = null;
    
    public DistritoDB(){
         this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Distrito> getDistritoAll() {
        List<Distrito> distritoList = null;
        try {
            System.out.println("metodo getDistritoAll");
            session = HibernateSessionFactory.getSession();
            Query q = session.createQuery("from Distrito as distrito");
            distritoList = (List<Distrito>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return distritoList;
    }
    
    
    public List<Distrito> getDistritoByIdProv(Integer idProv) {

        List<Distrito> DistList = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Distrito WHERE cod_provincia =" + idProv);
            System.out.println("Query: " + q.toString());
            DistList = (List<Distrito>) q.list();
            tx.commit();
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return DistList;
    }
    
    
    public Distrito getDistritoById(Integer idProv) {

        Distrito distrito = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Distrito WHERE cod_distrto =" + idProv);
            System.out.println("Query: " + q.toString());
            distrito = (Distrito) q.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return distrito;
    }
}

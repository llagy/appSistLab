/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.db;


import com.raitcon.hibernate.bean.Provincia;
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
public class ProvinciaDB {
    
    protected static Logger log = Logger.getLogger(ProvinciaDB.class);
    private Session session = null;
    
    public ProvinciaDB(){
         this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Provincia> getProvinciaAll() {
        List<Provincia> provinciaList = null;
        try {
            System.out.println("metodo getProvinciaAll");
            session = HibernateSessionFactory.getSession();
            Query q = session.createQuery("from Provincia as provincia");
            provinciaList = (List<Provincia>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return provinciaList;
    }
    
    
    public List<Provincia> getProvinciaByIdDepa(Integer idDepa) {

        List<Provincia> provList = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Provincia WHERE cod_depa =" + idDepa);
            System.out.println("Query: " + q.toString());
            provList = (List<Provincia>) q.list();
            tx.commit();
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return provList;
    }
    
    public Provincia getProvinciaById(Integer idProv) {

        Provincia prov = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Provincia WHERE cod_provincia =" + idProv);
            System.out.println("Query: " + q.toString());
            prov = (Provincia) q.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return prov;
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.Ocupacion;
import com.raitcon.hibernate.factory.HibernateSessionFactory;
import com.raitcon.hibernate.factory.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Miki
 */
public class OcupacionDB {
    
    protected static Logger log = Logger.getLogger(OcupacionDB.class);
    private Session session = null;
    
    public OcupacionDB(){
         this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Ocupacion> getOcupacionAll() {
        List<Ocupacion> ocupacionList = null;
        try {
            System.out.println("metodo getOcupacionAll");
            session = HibernateSessionFactory.getSession();
            Query q = session.createQuery("from Ocupacion as ocupacion");
            ocupacionList = (List<Ocupacion>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ocupacionList;
    }
    
    
    public List getOcupacionById(Integer id) {

        List<Ocupacion> sexList = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Ocupacion WHERE cod_ocupacion =" + id);
            System.out.println("Query: " + q.toString());
            sexList = (List<Ocupacion>) q.list();
            tx.commit();
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return sexList;
    }
    
    
    
}

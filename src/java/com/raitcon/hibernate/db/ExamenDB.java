/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.Examen;
import com.raitcon.hibernate.factory.HibernateSessionFactory;
import com.raitcon.hibernate.factory.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author mriverar
 */
public class ExamenDB {
    
     protected static Logger log = Logger.getLogger(ExamenDB.class);
     private Session session = null;
     
      public ExamenDB() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    
    public List<Examen> getExamenAll() {
        List<Examen> examenList = null;
        try {
            System.out.println("metodo getExamenAll");
            session = HibernateSessionFactory.getSession();
            Query q = session.createQuery("from Examen as examen");
            examenList = (List<Examen>) q.list();
        } catch (Exception e) {
            log.debug("Error getExamenAll:"+e.getMessage() );
            e.printStackTrace();
        }
        return examenList;
    }
    
    
    
    public List<Examen> findExamenByName(String descExamen) {
       List<Examen> examenList = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Examen WHERE UPPER(descripcion) LIKE UPPER('%" + descExamen + "%')");
            
            System.out.println("Query: " + q.toString());
            
            examenList=(List<Examen>) q.list();
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return examenList;
    }
    
    public List<Examen> findExamenByCode(String code) {
       List<Examen> examenList = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Examen WHERE UPPER(cod_examen) LIKE UPPER('%" + code + "%')");
            
            System.out.println("Query: " + q.toString());
            
            examenList=(List<Examen>) q.list();
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return examenList;
    }
    
    public List<Examen> findExamenByClase(Integer idClase) {
       List<Examen> examenList = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Examen WHERE id_clase=" + idClase);
            
            System.out.println("Query: " + q.toString());
            
            examenList=(List<Examen>) q.list();
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return examenList;
    }
    
    
    
}

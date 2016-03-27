/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.Clase;
import com.raitcon.hibernate.factory.HibernateSessionFactory;
import com.raitcon.hibernate.factory.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Miki
 */
public class ClaseDB {
    
    protected static Logger log = Logger.getLogger(ClaseDB.class);
    private Session session = null;
    
    
    public ClaseDB(){
        
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    
    
    public List<Clase> getClaseAll() {
        List<Clase> claseList = null;
        try {
            System.out.println("metodo getClaseAll");
            session = HibernateSessionFactory.getSession();
            Query q = session.createQuery("from Clase as clase");
            claseList = (List<Clase>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claseList;
    }
    
    public Integer insertClases(Clase clase) throws HibernateException, Exception {
        try {
            System.out.println("metodo insert");
            session = HibernateSessionFactory.getSession();
            System.out.println("session: " + session);
            System.out.println("Try");
            Transaction ts = session.beginTransaction();
            System.out.println("Transaction");
            session.save(clase);
            System.out.println("Save");
            ts.commit();
            System.out.println("Se inserto clase correctamente");
            return 1;
        } catch (HibernateException ex1) {
            System.out.println("HibernateException : " + ex1);
        } catch (Exception ex2) {
            System.out.println("Exception : " + ex2);
        } finally {
            session.close();
        }
        return -1;
    }
    
    
     public void updateClase(Clase clase, Integer code) throws HibernateException, Exception {

        try {
            System.out.println("metodo update clase");
            session = HibernateSessionFactory.getSession();
            System.out.println("try");
            Transaction ts = session.beginTransaction();
            System.out.println("Transaction");
            Clase clasUpdate = (Clase) session.get(Clase.class, code);
            
            clasUpdate.setIdClase(clase.getIdClase());
            clasUpdate.setDesClase(clase.getDesClase());
         
            session.update(clasUpdate);
            
            System.out.println("Update clase");
            ts.commit();
            System.out.println("Se modificó correctamente clase ");
        } catch (HibernateException ex1) {
            throw ex1;
        } catch (Exception ex2) {
            throw ex2;
        } finally {
            session.close();
        }
     
     }
     
     
     public Clase getClaseById(Integer idClase) {
       
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Clase WHERE IdClase =" + idClase);
            System.out.println("Query: " + q.toString());
            Clase clase=(Clase) q.uniqueResult();
            tx.commit();
            return clase;
            
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    
}

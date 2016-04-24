/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.Instruccion;
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
 * @author Miki Lap
 */
public class InstruccionDB {
    
    
    protected static Logger log = Logger.getLogger(InstruccionDB.class);
    private Session session = null;
    
    
    public InstruccionDB(){
        
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    
    
    public List<Instruccion> getInstruccionAll() {
        List<Instruccion> instruccionList = null;
        try {
            System.out.println("metodo getInstruccionAll");
            session = HibernateSessionFactory.getSession();
            Query q = session.createQuery("from Instruccion as instruccion");
            instruccionList = (List<Instruccion>) q.list();
        } catch (Exception e) {
            log.error("Se generó errores al consultar a la tabla instrucción");
            e.printStackTrace();
        }
        return instruccionList;
    }
    
    public Integer insertInstruccion(Instruccion instruccion) throws HibernateException, Exception {
        try {
            System.out.println("metodo insert");
            session = HibernateSessionFactory.getSession();
            System.out.println("session: " + session);
            System.out.println("Try");
            Transaction ts = session.beginTransaction();
            System.out.println("Transaction");
            session.save(instruccion);
            System.out.println("Save");
            ts.commit();
            System.out.println("Se inserto instruccion correctamente");
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
    
    
     public void updateInstruccion(Instruccion instruccion, Integer code) throws HibernateException, Exception {

        try {
            System.out.println("metodo update instruccion");
            session = HibernateSessionFactory.getSession();
            System.out.println("try");
            Transaction ts = session.beginTransaction();
            System.out.println("Transaction");
            Instruccion instruccionUpdate = (Instruccion) session.get(Instruccion.class, code);
            
            instruccionUpdate.setCodInstruccion(instruccion.getCodInstruccion());
            instruccionUpdate.setDescripcion(instruccion.getDescripcion());
         
            session.update(instruccionUpdate);
            
            System.out.println("Update Instruccion");
            ts.commit();
            System.out.println("Se modificó correctamente instruccion ");
        } catch (HibernateException ex1) {
            throw ex1;
        } catch (Exception ex2) {
            throw ex2;
        } finally {
            session.close();
        }
     
     }
     
     
     public Instruccion getInstruccionById(Integer idInstruccion) {
       
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Instruccion WHERE cod_instruccion =" + idInstruccion);
            System.out.println("Query: " + q.toString());
            Instruccion instruccion=(Instruccion) q.uniqueResult();
            tx.commit();
            return instruccion;
            
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
     
     
     public void deleteInstruccion(Integer id) throws HibernateException, Exception {
        session = HibernateSessionFactory.getSession();
        try {
            Transaction ts = session.beginTransaction();
            Instruccion instUpdate = (Instruccion) session.get(Instruccion.class, id);
            session.delete(instUpdate);
            ts.commit();
            System.out.println(" Instruccion se eliminó correctamente");
        } catch (HibernateException ex1) {
            throw ex1;
        } catch (Exception ex2) {
            throw ex2;
        } finally {
            session.close();
        }
     }
    
}

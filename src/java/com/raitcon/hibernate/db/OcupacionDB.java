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
import org.hibernate.HibernateException;
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
            Query q = session.createQuery("from Ocupacion as ocupacion WHERE estado='1'");
            ocupacionList = (List<Ocupacion>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ocupacionList;
    }
    
    
    public List getOcupacionById(Integer id) {

        List<Ocupacion> ocupacionList = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Ocupacion WHERE cod_ocupacion =" + id);
            System.out.println("Query: " + q.toString());
            ocupacionList = (List<Ocupacion>) q.list();
            tx.commit();
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return ocupacionList;
    }
    
    
     public Ocupacion getOcupacionByIdUniqueOcupacion(int codocupacion) {
       
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Ocupacion WHERE cod_Ocupacion ='" + codocupacion + "' AND estado='1'");
            System.out.println("Query: " + q.toString());
            return (Ocupacion) q.uniqueResult();
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    
       public Integer insertaOcupacion(Ocupacion ocupacion) throws HibernateException, Exception {
        try {
            System.out.println("metodo insert");
            session = HibernateSessionFactory.getSession();
            System.out.println("session: " + session);
            System.out.println("Try");
            Transaction ts = session.beginTransaction();
            System.out.println("Transaction");
            session.save(ocupacion);
            System.out.println("Save");
            ts.commit();
            System.out.println("Se inserto correctamente");
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
       
       public void updateOcupacion(Ocupacion ocupacion, int codOcupacion) throws HibernateException, Exception {

        try {
            System.out.println("metodo update grupo");
            session = HibernateSessionFactory.getSession();
            System.out.println("try");
            Transaction ts = session.beginTransaction();
            System.out.println("Transaction");
            Ocupacion ocupacionUpdate = (Ocupacion) session.get(Ocupacion.class, codOcupacion);
            
            ocupacionUpdate.setCodOcupacion(ocupacion.getCodOcupacion());
            ocupacionUpdate.setDescripcion(ocupacion.getDescripcion());
           
            session.update(ocupacionUpdate);
            
            System.out.println("Update ocupacion");
            ts.commit();
            System.out.println("Se modificÃ³ correctamente ocupacion ");
        } catch (HibernateException ex1) {
            throw ex1;
        } catch (Exception ex2) {
            throw ex2;
        } finally {
            session.close();
        }

    }
       
       
            public void desactivarOcupacion(Ocupacion ocupacion) throws HibernateException, Exception {

        try {
            System.out.println("metodo desactivar grupo");
            session = HibernateSessionFactory.getSession();
            System.out.println("try");
            Transaction ts = session.beginTransaction();
            System.out.println("Transaction");
            Ocupacion ocupacionUpdate = (Ocupacion) session.get(Ocupacion.class, ocupacion.getCodOcupacion());
            ocupacionUpdate.setEstado(ocupacion.getEstado());
            session.update(ocupacionUpdate);
         
            System.out.println("Desactivar ocupacion");
            ts.commit();
            System.out.println("Se desactivÃ³ ocupacion ");
        } catch (HibernateException ex1) {
            throw ex1;
        } catch (Exception ex2) {
            throw ex2;
        } finally {
            session.close();
        }

    }
            
            
     public void deleteOcupacion(Ocupacion ocupacion) throws HibernateException, Exception {
        session = HibernateSessionFactory.getSession();
        try {
            Transaction ts = session.beginTransaction();
            session.delete(ocupacion);
            ts.commit();
            System.out.println("Se elimno correctamente");
        } catch (HibernateException ex1) {
            throw ex1;
        } catch (Exception ex2) {
            throw ex2;
        } finally {
            session.close();
        }

    }


    
    
}

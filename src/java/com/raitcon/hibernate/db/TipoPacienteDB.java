/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.TipoPaciente;
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
public class TipoPacienteDB {
   
    protected static Logger log = Logger.getLogger(TipoPacienteDB.class);
    private Session session = null;
    
    
    public TipoPacienteDB(){
        
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    
    
    public List<TipoPaciente> getTipoPacienteAll() {
        List<TipoPaciente> tipoPacienteList = null;
        try {
            System.out.println("metodo getTipoPacienteAll");
            session = HibernateSessionFactory.getSession();
            Query q = session.createQuery("from TipoPaciente as tipoPaciente");
            tipoPacienteList = (List<TipoPaciente>) q.list();
        } catch (Exception e) {
            log.error("Se generó errores al consultar a la tabla tipoPaciente");
            e.printStackTrace();
        }
        return tipoPacienteList;
    }
    
    public Integer insertTipoPaciente(TipoPaciente tipPac) throws HibernateException, Exception {
        try {
            System.out.println("metodo insert");
            session = HibernateSessionFactory.getSession();
            System.out.println("session: " + session);
            System.out.println("Try");
            Transaction ts = session.beginTransaction();
            System.out.println("Transaction");
            session.save(tipPac);
            System.out.println("Save");
            ts.commit();
            System.out.println("Se inserto TipoPaciente correctamente");
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
    
    
     public void updateTipoPaciente(TipoPaciente tipoPac, Integer code) throws HibernateException, Exception {

        try {
            System.out.println("metodo update TipoPaciente");
            session = HibernateSessionFactory.getSession();
            System.out.println("try");
            Transaction ts = session.beginTransaction();
            System.out.println("Transaction");
            TipoPaciente tipPacUpdate = (TipoPaciente) session.get(TipoPaciente.class, code);
            
            tipPacUpdate.setIdTipoPaciente(tipoPac.getIdTipoPaciente());
            tipPacUpdate.setDescripcion(tipoPac.getDescripcion());
         
            session.update(tipPacUpdate);
            
            System.out.println("Update TipoPaciente");
            ts.commit();
            System.out.println("Se modificó correctamente TipoPaciente ");
        } catch (HibernateException ex1) {
            throw ex1;
        } catch (Exception ex2) {
            throw ex2;
        } finally {
            session.close();
        }
     
     }
     
     
     public TipoPaciente getTipoPacienteById(Integer id) {
       
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from TipoPaciente WHERE id_tipo_paciente =" + id);
            System.out.println("Query: " + q.toString());
            TipoPaciente tipoPac=(TipoPaciente) q.uniqueResult();
            tx.commit();
            return tipoPac;
            
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
     
     
     public void deleteTipoPaciente(Integer id) throws HibernateException, Exception {
        session = HibernateSessionFactory.getSession();
        try {
            Transaction ts = session.beginTransaction();
            TipoPaciente tipPacUpdate = (TipoPaciente) session.get(TipoPaciente.class, id);
            session.delete(tipPacUpdate);
            ts.commit();
            System.out.println(" TipoPaciente se eliminó correctamente");
        } catch (HibernateException ex1) {
            throw ex1;
        } catch (Exception ex2) {
            throw ex2;
        } finally {
            session.close();
        }
     }
}

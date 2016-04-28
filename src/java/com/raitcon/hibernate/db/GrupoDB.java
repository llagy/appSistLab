/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.Clase;
import com.raitcon.hibernate.bean.Grupo;
import static com.raitcon.hibernate.db.ClaseDB.log;
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
public class GrupoDB {
    
    protected static Logger log = Logger.getLogger(ClaseDB.class);
    private Session session = null;
    
    
    public GrupoDB(){
        
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    
    
    public List<Grupo> getGrupoAll() {
        List<Grupo> grupoList = null;
        try {
            System.out.println("metodo getGrupoAll");
            session = HibernateSessionFactory.getSession();
            Query q = session.createQuery("from Grupo as grupo WHERE estado='1'");
            grupoList = (List<Grupo>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grupoList;
    }
    
    public Integer insertGrupo(Grupo grupo) throws HibernateException, Exception {
        try {
            System.out.println("metodo insert");
            session = HibernateSessionFactory.getSession();
            System.out.println("session: " + session);
            System.out.println("Try");
            Transaction ts = session.beginTransaction();
            System.out.println("Transaction");
            session.save(grupo);
            System.out.println("Save");
            ts.commit();
            System.out.println("Se inserto grupo correctamente");
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
    
    
     public void updateGrupo(Grupo grupo, Integer code) throws HibernateException, Exception {

        try {
            System.out.println("metodo update grupo");
            session = HibernateSessionFactory.getSession();
            System.out.println("try");
            Transaction ts = session.beginTransaction();
            System.out.println("Transaction");
            Grupo grupoUpdate = (Grupo) session.get(Grupo.class, code);
            
            grupoUpdate.setIdGrupo(grupo.getIdGrupo());
            grupoUpdate.setDescripcion(grupo.getDescripcion());
         
            session.update(grupoUpdate);
            
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
     
     
     public Grupo getGrupoById(Integer idGrupo) {
       
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Grupo WHERE id_grupo =" + idGrupo);
            System.out.println("Query: " + q.toString());
            Grupo grupo=(Grupo) q.uniqueResult();
            tx.commit();
            return grupo;
            
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
     
     
     public void deleteGrupo(Integer idGrupo) throws HibernateException, Exception {
        session = HibernateSessionFactory.getSession();
        try {
            Transaction ts = session.beginTransaction();
            Grupo grupoUpdate = (Grupo) session.get(Grupo.class, idGrupo);
            session.delete(grupoUpdate);
            ts.commit();
            System.out.println(" Grupo ee eliminó correctamente");
        } catch (HibernateException ex1) {
            throw ex1;
        } catch (Exception ex2) {
            throw ex2;
        } finally {
            session.close();
        }
     }
     
     
     public void desactivarGrupo(Grupo grupo) throws HibernateException, Exception {

        try {
            System.out.println("metodo desactivar grupo");
            session = HibernateSessionFactory.getSession();
            System.out.println("try");
            Transaction ts = session.beginTransaction();
            System.out.println("Transaction");
            Grupo grupoUpdate = (Grupo) session.get(Grupo.class, grupo.getIdGrupo());
            grupoUpdate.setEstado(grupo.getEstado());
            session.update(grupoUpdate);
         
            System.out.println("Desactivar clase");
            ts.commit();
            System.out.println("Se desactivÃ³ clase ");
        } catch (HibernateException ex1) {
            throw ex1;
        } catch (Exception ex2) {
            throw ex2;
        } finally {
            session.close();
        }

    }

    
    
}

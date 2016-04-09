/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.Departamento;
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
public class DepartamentoDB {
    
    protected static Logger log = Logger.getLogger(DepartamentoDB.class);
    private Session session = null;
    
    public DepartamentoDB(){
         this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Departamento> getDepartamentoAll() {
        List<Departamento> departamentoList = null;
        try {
            System.out.println("metodo getDepartamentoAll");
            session = HibernateSessionFactory.getSession();
            Query q = session.createQuery("from Departamento as departamento");
            departamentoList = (List<Departamento>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departamentoList;
    }
    
    
    public Departamento getDepartamentoById(Integer id) {

        Departamento dpto = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Departamento WHERE cod_depa =" + id);
            System.out.println("Query: " + q.toString());
            dpto = (Departamento)q.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return dpto;
    }
    
    
    
}

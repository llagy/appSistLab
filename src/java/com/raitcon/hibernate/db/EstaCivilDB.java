/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.Estacivil;
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
public class EstaCivilDB {
    
    protected static Logger log = Logger.getLogger(EstaCivilDB.class);
    private Session session = null;
    
    public EstaCivilDB(){
         this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Estacivil> getEstaCivilAll() {
        List<Estacivil> estacivilList = null;
        try {
            System.out.println("metodo getEstaCivilAll");
            session = HibernateSessionFactory.getSession();
            Query q = session.createQuery("from Estacivil as estacivil");
            estacivilList = (List<Estacivil>) q.list();
        } catch (Exception e) {
            log.error("Error al consultar estado civil:"+e.toString());
            e.printStackTrace();
        }
        return estacivilList;
    }
    
    public Estacivil getEstaCivilById(Integer id) {

        Estacivil estaCivil = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Estacivil WHERE cod_estacivil =" + id);
            System.out.println("Query: " + q.toString());
            estaCivil = (Estacivil)q.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return estaCivil;
    }
   
    
}

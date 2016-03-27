/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.Ocupacion;
import com.raitcon.hibernate.bean.Sexo;
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
public class SexoDB {
    
    
    protected static Logger log = Logger.getLogger(SexoDB.class);
    private Session session = null;
    
    
    public SexoDB(){
       this.session = HibernateUtil.getSessionFactory().getCurrentSession(); 
    }
    
    public List<Sexo> getSexoAll() {
        
        List<Sexo> sexoList = null;
        try {
            System.out.println("metodo getSexoAll");
            session = HibernateSessionFactory.getSession();
            Query q = session.createQuery("from Sexo as sexo");
            sexoList = (List<Sexo>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sexoList;
    }
    
    
      public List getSexoByCod(Character codSex) {

        List<Sexo> sexList = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Sexo WHERE cod_sexo ='" + codSex +"'");
            System.out.println("Query: " + q.toString());
            sexList = (List<Sexo>) q.list();
            tx.commit();
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return sexList;
    }
    
}

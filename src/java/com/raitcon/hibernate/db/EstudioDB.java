/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.Estudio;
import com.raitcon.hibernate.bean.Examen;
import static com.raitcon.hibernate.db.ExamenDB.log;
import com.raitcon.hibernate.factory.HibernateSessionFactory;
import com.raitcon.hibernate.factory.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author mriverar
 */
public class EstudioDB {
    

protected static Logger log = Logger.getLogger(ExamenDB.class);
     private Session session = null;
     
      public EstudioDB() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    
    public List<Estudio> findEstudioByExamen(String codExamen) {
        List<Estudio> estudioList = null;
        try {
            System.out.println("metodo findEstudioByExamen");
            session = HibernateSessionFactory.getSession();
            Query q = session.createQuery("from Estudio as examen WHERE cod_examen='"+codExamen+"'");
            estudioList = (List<Estudio>) q.list();
        } catch (Exception e) {
            log.debug("Error findEstudioByExamen:"+e.getMessage() );
            e.printStackTrace();
        }
        return estudioList;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.Estudio;
import com.raitcon.hibernate.bean.Venta;
import static com.raitcon.hibernate.db.EstudioDB.log;
import com.raitcon.hibernate.factory.HibernateSessionFactory;
import com.raitcon.hibernate.factory.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author mriverar
 */
public class VentaDB {

  protected static Logger log = Logger.getLogger(VentaDB.class);
  private Session session = null;
     
     public VentaDB() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    
    public List<Venta> findVentasByFecha(Date fDesde, Date fHasta) {
        List<Venta> estudioList = null;
        SimpleDateFormat dtFecha = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String sDesde=dtFecha.format(fDesde);
        dtFecha = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String sHasta=dtFecha.format(fHasta);
        try {
            System.out.println("metodo findVentasByFecha");
            session = HibernateSessionFactory.getSession();
            Query q = session.createQuery("from Venta as venta WHERE fecha>='"+sDesde+"' AND fecha<='"+sHasta+"' AND estado='1'");
            estudioList = (List<Venta>) q.list();
        } catch (Exception e) {
            log.debug("Error findVentasByFecha:"+e.getMessage() );
            e.printStackTrace();
        }
        return estudioList;
    }
    
}

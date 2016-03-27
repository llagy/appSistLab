package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.SubMenu;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



import com.raitcon.hibernate.factory.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 * A data access object (DAO) providing persistence and search support for
 * TpatFtp entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.alignet.hibernate.Ftp.TpatFtp
 * @author MyEclipse Persistence Tools
 */

public class SubMenuDB  {
	private static final Log log = LogFactory.getLog(SubMenuDB.class);
        
        private Session session=null;
	

        
        public SubMenuDB(){
             this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
	
	
	       
        
     public List getSubMenuByIdMenu(Integer IdMenu) {
        List<SubMenu> menuList = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("Select Distinct submenu from SubMenu as submenu, Menu "
                    + "as menu WHERE  submenu.menu.idMenu="+IdMenu+" order by id_sub_menu");
            //Query q = session.createQuery ("from SubMenu as submenu WHERE menu.idMenu =" +IdMenu);
            menuList = (List<SubMenu>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al consultar SubMenu:::"+e.getMessage());
        }
        return menuList;
      } 
     
     
   
	
}
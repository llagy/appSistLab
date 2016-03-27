/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.Usuario;
import com.raitcon.hibernate.bean.Menu;
import com.raitcon.hibernate.bean.Rol;
import com.raitcon.hibernate.bean.RolesAccion;
import com.raitcon.hibernate.factory.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mike
 */
public class RolesAccionDB {
    
    
    Session session = null;
    public RolesAccionDB(){
        
         this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
     
    
    
    
     public List getRolesAccionAll() {
        List<RolesAccion> rolesAccionList = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from RolesAccion as RolesAccion");
            rolesAccionList = (List<RolesAccion>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rolesAccionList;
     } 
     
     public List getRolesAccionById(Integer idRole) {
        List<RolesAccion> rolesAccionList = null;
        Rol roles=new Rol(1);
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = 
                    session.createQuery ("Select rolesAccion from RolesAccion rolesAccion, Roles roles WHERE roles.idRol="+idRole);
            rolesAccionList = (List<RolesAccion>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error:"+ e.getMessage());
        }
        return rolesAccionList;
     } 
     
     public List getMenubyIdRol(Integer idRol) {
        List<Menu> menuList = null;
        try {
           org.hibernate.Transaction tx = session.beginTransaction();
          List<RolesAccion> listRolesAccion=null;
            
            Query q = session.createQuery ("Select distinct menu from  Menu as menu,RolesAccion rolesAccion,"
                    + " Rol rol WHERE   menu.idMenu=rolesAccion.menu.idMenu AND "
                    + "rolesAccion.rol.idRol="+idRol +
                    " order by menu.peso");
           // Query q = session.createQuery ("FROM RolesAccion as rolesAccion WHERE rolesAccion.roles.idRol="+idRol);
           // listRolesAccion=(List<RolesAccion>) q.list();
             menuList=(List<Menu>) q.list();
            //for(RolesAccion o:listRolesAccion ){
               // menuList.add(o.getMenu());
           // }
        } catch (Exception e) {
            e.printStackTrace();
            
            System.out.println("Se genero errores:"+ e.getMessage());
        }
        return menuList;
      }
    
}

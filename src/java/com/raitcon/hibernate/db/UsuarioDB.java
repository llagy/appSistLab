/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.Usuario;
import com.raitcon.hibernate.factory.HibernateUtil;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mike
 */
public class UsuarioDB  {
    
   private static final Log log = LogFactory.getLog(UsuarioDB.class);
	//property constants
	public static final String ID_USUARIO = "idusuario";
	public static final String LOGIN = "login";
	public static final String PASSWORD = "password";
	public static final String NOMBRE = "nombre";
        public static final String APELLIDOS = "apellidos";
        public static final String STATE = "state";
        
         Session session = null;
         
    public UsuarioDB(){
             this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
        
     public List getUsuariosAll() {
        List<Usuario> usuariosList = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Usuario as usuarios");
            usuariosList = (List<Usuario>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuariosList;
   } 
     
     public  Usuario  getValidateUser(String userName, String pwd){
         
          Usuario usuarios = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Usuario as usuario WHERE login='"+userName+"' AND password='"+pwd+"'");
           usuarios= (Usuario) q.uniqueResult();
        } catch (Exception e) {
            log.error("Error:"+e.getMessage());
             e.printStackTrace();
        }
        return  usuarios;
     }
}


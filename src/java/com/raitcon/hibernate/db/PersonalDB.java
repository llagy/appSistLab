package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.Personal;
import com.raitcon.hibernate.factory.HibernateSessionFactory;
import com.raitcon.hibernate.factory.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PersonalDB {

    protected static Logger log = Logger.getLogger(PersonalDB.class);
    private Session session = null;

    public PersonalDB() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public Integer insertPersonal(Personal pers) throws HibernateException, Exception {
        try {
            System.out.println("metodo insert");
            session = HibernateSessionFactory.getSession();
            System.out.println("session: " + session);
            System.out.println("Try");
            Transaction ts = session.beginTransaction();
            System.out.println("Transaction");
            session.save(pers);
            System.out.println("Save");
            ts.commit();
            System.out.println("Se inserto correctamente");
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

    public void updatePersonal(Personal personal, String code) throws HibernateException, Exception {

        try {
            System.out.println("metodo update personal");
            session = HibernateSessionFactory.getSession();
            System.out.println("try");
            Transaction ts = session.beginTransaction();
            System.out.println("Transaction");
            Personal persUpdate = (Personal) session.get(Personal.class, code);
            
            persUpdate.setApMaterno(personal.getApMaterno());
            persUpdate.setApPaterno(personal.getApPaterno());
            persUpdate.setDireccion(personal.getDireccion());
            persUpdate.setDni(personal.getDni());
            persUpdate.setEspecialidad(personal.getEspecialidad());
            persUpdate.setEstadoCivil(personal.getEstadoCivil());
            persUpdate.setFechaNacimiento(personal.getFechaNacimiento());
            persUpdate.setMail(personal.getMail());
            persUpdate.setNombres(personal.getNombres());
            persUpdate.setOcupacion(personal.getOcupacion());
            persUpdate.setSexo(personal.getSexo());
            persUpdate.setTelefono(personal.getTelefono());
            session.update(persUpdate);
            
            System.out.println("Update personal");
            ts.commit();
            System.out.println("Se modificó correctamente personal ");
        } catch (HibernateException ex1) {
            throw ex1;
        } catch (Exception ex2) {
            throw ex2;
        } finally {
            session.close();
        }

    }

    
    
     public void desactivarPersonal(Personal personal) throws HibernateException, Exception {

        try {
            System.out.println("metodo desactivar personal");
            session = HibernateSessionFactory.getSession();
            System.out.println("try");
            Transaction ts = session.beginTransaction();
            System.out.println("Transaction");
            Personal persUpdate = (Personal) session.get(Personal.class, personal.getCodPersonal());
            persUpdate.setEstado(personal.getEstado());
            session.update(persUpdate);
         
            System.out.println("Desactivar personal");
            ts.commit();
            System.out.println("Se desactivó personal ");
        } catch (HibernateException ex1) {
            throw ex1;
        } catch (Exception ex2) {
            throw ex2;
        } finally {
            session.close();
        }

    }
    
    
    
    
    public void deletePersonal(Personal personal) throws HibernateException, Exception {
        session = HibernateSessionFactory.getSession();
        try {
            Transaction ts = session.beginTransaction();
            session.delete(personal);
            ts.commit();
            System.out.println("Se elimno correctamente");
        } catch (HibernateException ex1) {
            throw ex1;
        } catch (Exception ex2) {
            throw ex2;
        } finally {
            session.close();
        }

    }

    public List<Personal> getPersonalAll() {
        List<Personal> personalList = null;
        try {
            System.out.println("metodo getPersonalAll");
            session = HibernateSessionFactory.getSession();
            Query q = session.createQuery("from Personal as personal  WHERE estado='1' order by nombres");
            personalList = (List<Personal>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personalList;
    }

    public Personal getPersonalByCod(String codPers) {
       
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Personal WHERE cod_personal ='" + codPers + "' AND estado='1'");
            System.out.println("Query: " + q.toString());
            return (Personal) q.uniqueResult();
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    
    public List getPersonalByIdOcupacion(String idOcupación) {
       
        List<Personal> asignaturaList = null;
        try {
            System.out.println("CodArea:"+idOcupación);
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Personal as personal WHERE id_ocupacion =" +idOcupación);
            asignaturaList = (List<Personal>) q.list();
        } catch (Exception e) {
            System.out.println("Error Cargo:"+idOcupación);
            log.debug("Error:"+e.getMessage() );
            e.printStackTrace();
        }
        return asignaturaList;
      }
    
    
     
}

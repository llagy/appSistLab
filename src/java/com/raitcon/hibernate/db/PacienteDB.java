/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.db;

import com.raitcon.hibernate.bean.Paciente;
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
 * @author Mike Lap
 */
public class PacienteDB {
    
     protected static Logger log = Logger.getLogger(PacienteDB.class);
     private Session session = null;
     
      public PacienteDB() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
      
      public Integer insertPaciente(Paciente pcte) throws HibernateException, Exception {
        try {
            System.out.println("metodo insert");
            session = HibernateSessionFactory.getSession();
            System.out.println("session: " + session);
            System.out.println("Try");
            Transaction ts = session.beginTransaction();
            System.out.println("Transaction");
            session.save(pcte);
            System.out.println("Save");
            ts.commit();
            System.out.println("Se insertó paciente correctamente");
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

    public void updatePaciente(Paciente pcte, String code) throws HibernateException, Exception {

        try {
            System.out.println("metodo update paciente");
            session = HibernateSessionFactory.getSession();
            System.out.println("try");
            Transaction ts = session.beginTransaction();
            System.out.println("Transaction");
            Paciente pcteUpdate = (Paciente) session.get(Paciente.class, code);
            
            pcteUpdate.setApMaterno(pcte.getApMaterno());
            pcteUpdate.setApPaterno(pcte.getApPaterno());
            pcteUpdate.setDireccion(pcte.getDireccion());
            pcteUpdate.setFechaNacimiento(pcte.getFechaNacimiento());
            pcteUpdate.setFechaIngreso(pcte.getFechaIngreso());
            pcteUpdate.setEmail(pcte.getEmail());
            pcteUpdate.setNombre1(pcte.getNombre1());
            pcteUpdate.setNombre2(pcte.getNombre2());
            pcteUpdate.setFoto(pcte.getFoto());
            pcteUpdate.setOcupacion(pcte.getOcupacion());
            pcteUpdate.setInstruccion(pcte.getInstruccion());
            pcteUpdate.setSexo(pcte.getSexo());
            pcteUpdate.setEstacivil(pcte.getEstacivil());
            pcteUpdate.setTipoPaciente(pcte.getTipoPaciente());
            pcteUpdate.setTelefono(pcte.getTelefono());
            session.update(pcteUpdate);
            
            System.out.println("Update paciente");
            ts.commit();
            System.out.println("Se modificó correctamente paciente ");
        } catch (HibernateException ex1) {
            throw ex1;
        } catch (Exception ex2) {
            throw ex2;
        } finally {
            session.close();
        }

    }

    
    
     public void desactivarPaciente(Paciente pcte) throws HibernateException, Exception {

        try {
            System.out.println("metodo desactivar paciente");
            session = HibernateSessionFactory.getSession();
            System.out.println("try");
            Transaction ts = session.beginTransaction();
            System.out.println("Transaction");
            Paciente pcteUpdate = (Paciente) session.get(Paciente.class, pcte.getCodPaciente());
            pcteUpdate.setEstado(pcte.getEstado());
            session.update(pcteUpdate);
         
            System.out.println("Desactivar paciente");
            ts.commit();
            System.out.println("Se desactivó paciente ");
        } catch (HibernateException ex1) {
            throw ex1;
        } catch (Exception ex2) {
            throw ex2;
        } finally {
            session.close();
        }

    }
    
    
    
    
    public void deletePaciente(Paciente pcte) throws HibernateException, Exception {
        session = HibernateSessionFactory.getSession();
        try {
            Transaction ts = session.beginTransaction();
            session.delete(pcte);
            ts.commit();
            System.out.println("Se eliminó paciente correctamente ");
        } catch (HibernateException ex1) {
            throw ex1;
        } catch (Exception ex2) {
            throw ex2;
        } finally {
            session.close();
        }

    }

    public List<Paciente> getPacienteAll() {
        List<Paciente> pacienteList = null;
        try {
            System.out.println("metodo getPacienteAll");
            session = HibernateSessionFactory.getSession();
            Query q = session.createQuery("from Paciente as paciente  WHERE estado='1' order by cod_paciente");
            pacienteList = (List<Paciente>) q.list();
        } catch (Exception e) {
            log.debug("Error getPacienteAll:"+e.getMessage() );
            e.printStackTrace();
        }
        return pacienteList;
    }

    public Paciente getPacienteByCod(String codPcte) {
       
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Paciente WHERE cod_paciente ='" + codPcte + "' AND estado='1'");
            System.out.println("Query: " + q.toString());
            return (Paciente) q.uniqueResult();
        } catch (Exception e) {
            log.debug("Error:" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    
    public List getPacienteByIdOcupacion(String idOcupación) {
       
        List<Paciente> pacienteList = null;
        try {
            System.out.println("CodArea:"+idOcupación);
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Paciente as paciente WHERE id_ocupacion =" +idOcupación);
            pacienteList = (List<Paciente>) q.list();
        } catch (Exception e) {
            System.out.println("Error  paciente cargo:"+idOcupación);
            log.debug("Error paciente cargo:"+e.getMessage() );
            e.printStackTrace();
        }
        return pacienteList;
      }
    
    
    
}

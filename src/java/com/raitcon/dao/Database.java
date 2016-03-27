/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Mike
 */
public class Database {
    
    
     public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sist_academico",
                    "MIGUEL", "m261082");
            return con;
        } catch (Exception ex) {
            System.out.println("database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }
 
    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}

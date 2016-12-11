/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facitec.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionManager {
    
    private static final String DB = "bd_insumos";
    private static final String URL = "jdbc:postgresql://localhost:5432/"+DB;
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";
    
    public static Connection con;
    public static Statement st;
    
    public static void conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Cargando driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cargar el driver"+ex);
        }
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            st = con.createStatement();
            System.out.println("Conectando a: "+DB);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al desconectar"+ex);
        }
    }
    
    public static void desconectar(){
        if (con!=null) {
            try {
                con.close();
                st.close();
                System.out.println("Desconectando");
            } catch (SQLException ex) {
                Logger.getLogger(ConexionManager.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error al desconectar"+ex);
            }
            
        }
    }
    
}

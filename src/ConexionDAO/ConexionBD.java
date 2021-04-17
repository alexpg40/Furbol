/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.Utilidades;

/**
 *
 * @author alex
 */
public class ConexionBD {
    
    private static final String DB_URL = Utilidades.readXML("url");
    private static final String USER = Utilidades.readXML("user");
    private static final String PASS = Utilidades.readXML("password");
    
    static Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    
    public static Connection establecerConexion() {
        try {
            //System.out.println("Conectando a la Base de Datos...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            System.out.println("Se ha producido una SQLException:" + ex.getMessage());
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Se ha producido una ClassNotFoundException:" + ex.getMessage());
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return conn;
        }
    }
    public static void cerrarConexion() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

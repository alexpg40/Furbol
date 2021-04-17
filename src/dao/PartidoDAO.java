/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ConexionDAO.ConexionBD;
import furbol.Jugador;
import furbol.Partido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class PartidoDAO {
    
    private Partido partido;
    private static Connection conn;
    
    public static ArrayList<Partido> todosPartidos(){
        ArrayList<Partido> ret = new ArrayList<>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM Partido");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idPartido");
                    int idequipolocal = prs.getInt("nombre");
                    int idequipovisitante = prs.getInt("apellido");
                    int goleslocal = prs.getInt("goleslocal");
                    int golesvisitante = prs.getInt("golesvisitante");
                    Date fecha = prs.getDate("fecha");
                    Partido p = new Partido(id, idequipolocal, idequipovisitante, goleslocal, golesvisitante, fecha);
                    ret.add(p);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(JugadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(JugadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ret;}
    
}

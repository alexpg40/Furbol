/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ConexionDAO.ConexionBD;
import furbol.Equipo;
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
public class EquipoDAO {
    
    private Equipo equipo;
    private static Connection conn;
    
    public static ArrayList<Equipo> todosEquipos(){
        ArrayList<Equipo> ret = new ArrayList<>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM Equipo");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idEquipo");
                    String nombre = prs.getString("nombre");
                    int goles_favor = prs.getInt("goles_favor");
                    int goles_contra = prs.getInt("goles_contra");
                    int victoria = prs.getInt("victorias");
                    int empates = prs.getInt("empates");
                    int derrotas = prs.getInt("derrotas");
                    Equipo e = new Equipo(id, nombre, goles_favor, goles_contra, victoria, empates, derrotas);
                    ret.add(e);
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

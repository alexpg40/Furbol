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

    public static ArrayList<Partido> todosPartidos() {
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
                    int idequipolocal = prs.getInt("idEquipoLocal");
                    int idequipovisitante = prs.getInt("idEquipoVisitante");
                    int goleslocal = prs.getInt("goles_local");
                    int golesvisitante = prs.getInt("goles_visitante");
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
        return ret;
    }

    public static void guardarPartidos(ArrayList<Partido> partidos) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("INSERT INTO Partido (idPartido, idEquipoLocal, idEquipoVisitante, goles_local, goles_visitante) VALUES (?, ?, ?, ?, ?)");
                for (Partido p : partidos) {
                    pstmt.setInt(1, p.getId());
                    pstmt.setInt(2, p.getIdequipolocal());
                    pstmt.setInt(3, p.getIdequipovisitante());
                    pstmt.setInt(4, p.getGoleslocal());
                    pstmt.setInt(5, p.getGolesvisitante());
                    pstmt.executeLargeUpdate();
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
    }

    public static void actualizarPartido(Partido p) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                int idPartido = p.getId();
                pstmt = conn.prepareStatement("UPDATE Partido SET idEquipoLocal = ?, idEquipoVisitante = ?, goles_local = ?, goles_visitante = ?, fecha = ? WHERE idPartido = " + String.valueOf(idPartido));
                int idEquipoLocal = p.getIdequipolocal();
                int idEquipoVisitante = p.getIdequipovisitante();
                int goles_local = p.getGoleslocal();
                int goles_visitante = p.getGolesvisitante();
                Date fecha = p.getFecha();
                pstmt.setInt(1, idEquipoLocal);
                pstmt.setInt(2, idEquipoVisitante);
                pstmt.setInt(3, goles_local);
                pstmt.setInt(4, goles_visitante);
                pstmt.setDate(5, fecha);
                pstmt.executeUpdate();

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
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ConexionDAO.ConexionBD;
import furbol.Jugador;
import java.sql.Connection;
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
public class JugadorDAO {

    private Jugador jugador;
    private static Connection conn;

    public JugadorDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public ArrayList<Jugador> todosJugadores() {
        ArrayList<Jugador> ret = new ArrayList<Jugador>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM Jugador");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idJugador");
                    String nombre = prs.getString("nombre");
                    String apellido = prs.getString("apellido");
                    int goles = prs.getInt("goles");
                    char posicion = prs.getString("posicion").charAt(0);
                    int idequipo = prs.getInt("idEquipo");
                    Jugador jugador = new Jugador(id, nombre, apellido, goles, posicion, idequipo);
                    ret.add(jugador);
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

}

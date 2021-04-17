/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furbol;

import dao.CompeticionDAO;
import dao.EquipoDAO;
import dao.JugadorDAO;
import dao.PartidoDAO;
import java.util.ArrayList;
import utilidades.Utilidades;

public class Furbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JugadorDAO j = new JugadorDAO();
        ArrayList<Competicion> competiciones = CompeticionDAO.todasCompeticiones();
        
        Utilidades.leerArrayList(competiciones);
        
        
    }
}

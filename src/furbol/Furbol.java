/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furbol;

import java.util.LinkedHashSet;
import utilidades.Utilidades;

public class Furbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LinkedHashSet<Equipo> clasificacion = new LinkedHashSet<>(Utilidades.arraytoArrayList(Utilidades.EQUIPOS));
        
        Competicion LigaSantander = new Competicion();
        Competicion newCompeticion = LigaSantander.newCompeticion("Liga Santander", 2021, Utilidades.arraytoArrayList(Utilidades.EQUIPOS));
        Utilidades.leerArrayList(newCompeticion.gamesOf(Utilidades.EQUIPOS[0]));
        
    }
}

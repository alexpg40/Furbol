/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furbol;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import utilidades.Utilidades;

public class Furbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Equipo> equipos = Utilidades.arraytoArrayList(Utilidades.EQUIPOS);
        
        LinkedHashSet<Equipo> clasificacion = new LinkedHashSet<>(Utilidades.arraytoArrayList(Utilidades.EQUIPOS));
        
        Competicion LigaSantander = new Competicion();
        Competicion newCompeticion = LigaSantander.newCompeticion("Liga Santander", 2021, Utilidades.arraytoArrayList(Utilidades.EQUIPOS));
        newCompeticion.getPartidos().get(0).playMatch(20, 5);
        newCompeticion.infoCompeticion();
        newCompeticion.imprimirClasificacion();
        
    }
}

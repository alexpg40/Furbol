/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furbol;

import java.util.ArrayList;
import utilidades.Utilidades;

public class Furbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ESPERO QUEYA FUNCIONE
        //PRUEBA asdasdCsOMMT
        ArrayList<Equipo> equipos = Utilidades.arraytoArrayList(Utilidades.EQUIPOS);
        ArrayList<Equipo> equiposc = Equipo.clasificacion(equipos);
        Utilidades.leerArrayList(equiposc);
        
    }
}
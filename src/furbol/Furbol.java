/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furbol;

import java.util.ArrayList;

public class Furbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Jugador j = new Jugador("Joao", "Felix", 20, 'D', 1);
        j.guardarObjeto();
        Jugador.leerObjeto();
        
        Equipo ATM = new Equipo("Atletico de Madrid", 20,5,10,3,2);
        Equipo GT = new Equipo("Getafe", 12,1,8,5,2);
        Equipo VAL = new Equipo("Valencia", 12,1,8,5,2);
        Equipo RAC = new Equipo("Racing de Santader", 17,9,9,4,2);
        Equipo OV = new Equipo("Oviedo", 6,20,1,5,9);
        Equipo SPO = new Equipo("Sporting de Gijón", 2,14,0,7,8);
        
        ArrayList<Equipo> clasificacion = new ArrayList<>();
        clasificacion.add(VAL);
        clasificacion.add(SPO);
        clasificacion.add(OV);
        clasificacion.add(RAC);
        clasificacion.add(GT);
        clasificacion.add(ATM);
        
        
        ArrayList<Equipo> ordenada = Equipo.clasificacion(clasificacion);
       
        for (Equipo e : ordenada) {
            System.out.println(e);
        }
        int n = 1;
        
    }
}

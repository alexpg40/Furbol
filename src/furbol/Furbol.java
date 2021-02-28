/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furbol;
public class Furbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Jugador j = new Jugador("Joao", "Felix", 20, 'D', 1);
        j.guardarObjeto();
        Jugador.leerObjeto();
    }
}

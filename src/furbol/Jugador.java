/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furbol;

import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex Perez
 */
public class Jugador implements Serializable{
    
    private static final long serialVersionUID = 923841203981203L;
    private String nombre;
    private String apellido;
    private int goles;
    private char posicion;
    private int idequipo;
    
    public Jugador(){
        
    }
    
    public Jugador(String nombre, String apellido, int goles, char posicion, int idequipo){
        this.nombre= nombre;
        this.apellido = apellido;
        this.goles = goles;
        this.posicion = posicion;
        this.idequipo = idequipo;   
    }
    
    public Jugador(Jugador j){
        this.nombre = j.nombre;
        this.apellido = j.apellido;
        this.goles = j.goles;
        this.posicion = j.posicion;
        this.idequipo = j.idequipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public char getPosicion() {
        return posicion;
    }

    public void setPosicion(char posicion) {
        this.posicion = posicion;
    }

    public int getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(int idequipo) {
        this.idequipo = idequipo;
    }
    
    public void guardarObjeto(){
        OutputStream os;
        ObjectOutput out = null;
        try {
            os = new FileOutputStream("jugador.txt");
            out = new ObjectOutputStream(os);
            out.writeObject(this);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");;
        } catch (IOException ex) {
            System.out.println("Error");            
        } finally  {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    System.out.println("Error");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", apellido=" + apellido + ", goles=" + goles + ", posicion=" + posicion + ", idequipo=" + idequipo + '}';
    }
    
    public static void leerObjeto(){
        InputStream is;
        ObjectInput in = null;
        try {
            is = new FileInputStream("jugador.txt");
            in = new ObjectInputStream(is);
            Jugador j = (Jugador) in.readObject();
            System.out.println(j);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Error");
        } catch (ClassNotFoundException ex) {
            System.out.println("Fallo al convertir el objeto a jugador");
        } finally{
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el Stream");
                }
            }
        }
    }
    
    public static void guardarJugadores(ArrayList<Jugador> jugadores){
        OutputStream os;
        ObjectOutput ob;
        try {
            os = new FileOutputStream("jugadores.txt");
            ob = new ObjectOutputStream(os);
            for (Jugador j : jugadores) {
                ob.writeObject(j);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

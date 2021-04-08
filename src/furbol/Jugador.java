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
import utilidades.Utilidades;

/**
 *
 * @author Alex Perez
 */
public class Jugador implements Serializable {

    private static final long serialVersionUID = 923841203981203L;
    private int id;
    private String nombre;
    private String apellido;
    private int goles;
    private char posicion;
    private int idequipo;

    public Jugador() {

    }

    public Jugador(String nombre, String apellido, int idequipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idequipo = idequipo;
    }

    public Jugador(int id, String nombre, String apellido, int goles, char posicion, int idequipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.goles = goles;
        this.posicion = posicion;
        this.idequipo = idequipo;
    }

    public Jugador(Jugador j) {
        this.id = j.id;
        this.nombre = j.nombre;
        this.apellido = j.apellido;
        this.goles = j.goles;
        this.posicion = j.posicion;
        this.idequipo = j.idequipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", apellido=" + apellido + ", goles=" + goles + ", posicion=" + posicion + ", idequipo=" + idequipo + '}';
    }

    public static ArrayList<Jugador> getJugadorByIdEquipo(int idequipo) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        for (Jugador j : Utilidades.JUGADORES) {
            if (j.idequipo == idequipo) {
                jugadores.add(j);
            }
        }
        return jugadores;
    }

    public Equipo playIn() {
        Equipo e = new Equipo();
        e = Equipo.getEquipoByID(this.idequipo);
        return e;
    }

    public static Jugador createPlayer(String nombre, String apellido, String equipo) {
        Jugador ret = new Jugador(nombre, apellido, Equipo.getEquipoByName(equipo).getId());
        return ret;
    }

}

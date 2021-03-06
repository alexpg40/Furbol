/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furbol;

import java.io.Serializable;
import java.util.ArrayList;
import utilidades.Utilidades;

/**
 *
 * @author Alex Perez
 */
public class Equipo implements Comparable<Equipo>, Serializable {

    private int id;
    private String nombre;
    private int golesFavor;
    private int golesContra;
    private int golaverage;
    private int win;
    private int draw;
    private int lost;
    private int puntuacion = win * 3 + draw;
    private int partidos = win + draw + lost;

    public Equipo() {
    }

    public Equipo(String nombre){
        this.nombre = nombre;
    }
    
    public Equipo(int id, String nombre, int golesFavor, int golesContra, int win, int draw, int lost) {
        this.id = id;
        this.nombre = nombre;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
        this.partidos = win + draw + lost;
        this.puntuacion = win * 3 + draw;
        this.win = win;
        this.draw = draw;
        this.lost = lost;
        this.golaverage = golesFavor - golesContra;
    }

    public Equipo(Equipo e) {
        this.nombre = e.nombre;
        this.golesFavor = e.golesFavor;
        this.golesContra = e.golesContra;
        this.partidos = e.win + e.draw + e.lost;
        this.puntuacion = e.win * 3 + e.draw;
        this.win = e.win;
        this.draw = e.draw;
        this.lost = e.lost;
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

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getPartidos() {
        return partidos;
    }

    public void setPartidos(int partidos) {
        this.partidos = partidos;
    }

    public int getGolaverage() {
        return golaverage;
    }

    /**
     * Compara la puntuacion entre dos equipo
     *
     * @param o
     * @return si el primer equipo gana devuelve 1, si pierde -1 y si estan
     * igualados 0.
     */
    @Override
    public int compareTo(Equipo o) {
        if (this.puntuacion > o.puntuacion) {
            return 1;
        } else if(this.puntuacion < o.puntuacion){
            return -1;
        } else {
            return this.nombre.compareTo(o.nombre);
        }
    }
    
    public static Equipo getEquipoByID(int id, ArrayList<Equipo> equipos){
        for (Equipo e : equipos) {
            if (e.id == id) {
                return e;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.nombre + "|" + this.puntuacion + "|" + this.partidos + "|" + this.win + "|" + this.draw + "|" + this.lost + "|" + this.golaverage;
    }

    public static Equipo createTeam(String name){
        Equipo team = new Equipo(name);
    return team;
    }
   
    public static Equipo getEquipoByName(String nombre, ArrayList<Equipo> equipos){
        Equipo ret = new Equipo();
        for (Equipo e : equipos) {
            if (e.nombre.equals(nombre)) {
                ret = e;
            }
        }
    return ret;
    }
    
}

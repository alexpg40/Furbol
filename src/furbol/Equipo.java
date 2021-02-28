/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furbol;

/**
 *
 * @author Alex Perez
 */
public class Equipo {
    
    private String nombre;
    private int golesFavor;
    private int golesContra;
    private int win;
    private int draw;
    private int lost;
    private int puntuacion = win*3 + draw;
    private int partidos = win + draw + lost;

    public Equipo(){
    }
    
    public Equipo(String nombre, int golesFavor, int golesContra, int partidos, int puntuacion, int win, int draw, int lost) {
        this.nombre = nombre;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
        this.partidos = win + draw + lost;
        this.puntuacion = win*3 + draw;
        this.win = win;
        this.draw = draw;
        this.lost = lost;
    }
    
    public Equipo(Equipo e){
        this.nombre = e.nombre;
        this.golesFavor = e.golesFavor;
        this.golesContra = e.golesContra;
        this.partidos = e.win + e.draw + e.lost;
        this.puntuacion = e.win*3 + e.draw;
        this.win = e.win;
        this.draw = e.draw;
        this.lost = e.lost;
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
    
}

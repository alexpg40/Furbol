/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furbol;

import java.util.ArrayList;

/**
 *
 * @author Alex Perez
 */
public class Equipo implements Comparable<Equipo> {

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

    public Equipo(String nombre, int golesFavor, int golesContra, int win, int draw, int lost) {
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
        Integer n = this.getPuntuacion();
        Integer n2 = o.getPuntuacion();
        return n.compareTo(n2);
    }

    public static ArrayList<Equipo> clasificacion(ArrayList<Equipo> array) {
        ArrayList<Equipo> ret = new ArrayList<>();
        while (!array.isEmpty()) {
            if (ret.isEmpty()) {
                ret.add(array.get(0));
                array.remove(array.get(0));
            } else {
                while (!array.isEmpty()) {
                    if (ret.get(0).compareTo(array.get(0)) == -1) {
                        ret.add(0, array.get(0));
                        array.remove(array.get(0));
                    } else {
                        for (int i = 0; i < ret.size(); i++) {
                            if (ret.get(i).compareTo(array.get(0)) == -1) {
                                ret.add(i, array.get(0));
                                array.remove(array.get(0));
                                break;
                            } else if (ret.get(i).compareTo(array.get(0)) == 0) {
                                if (ret.get(i).getGolaverage() > array.get(0).getGolaverage()) {
                                    ret.add(i + 1, array.get(0));
                                    array.remove(array.get(0));
                                    break;
                                } else if (ret.get(i).getGolaverage() < array.get(0).getGolaverage()) {
                                    ret.add(i, array.get(0));
                                    array.remove(array.get(0));
                                    break;
                                } else if (ret.get(i).getGolaverage() == array.get(0).getGolaverage()) {
                                    if (ret.get(i).getNombre().charAt(0) < array.get(0).getNombre().charAt(0)) {
                                        ret.add(i + 1, array.get(0));
                                        array.remove(array.get(0));
                                        break;
                                    } else {
                                        ret.add(i, array.get(0));
                                        array.remove(array.get(0));
                                        break;
                                    }
                                }
                            } else if ((ret.get(i).compareTo(array.get(0)) == 1) && (i == ret.size() - 1)) {
                                ret.add(i + 1, array.get(0));
                                array.remove(array.get(0));
                                break;
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.puntuacion;
    }

}

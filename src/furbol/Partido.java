/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furbol;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Alex Perez
 */
public class Partido {

    private int id;
    private int idequipolocal;
    private int idequipovisitante;
    private int goleslocal;
    private int golesvisitante;
    private Date fecha;

    public Partido() {

    }
    
    public Partido(int id, int idequipolocal, int idequipovisitante){
        this.id = id;
        this.idequipolocal = idequipolocal;
        this.idequipovisitante = idequipovisitante;
    }
    
    public Partido(int id, int idequipolocal, int idequipovisitante, int goleslocal, int golesvisitante, Date fecha) {
        this.id = id;
        this.idequipolocal = idequipolocal;
        this.idequipovisitante = idequipovisitante;
        this.goleslocal = goleslocal;
        this.golesvisitante = golesvisitante;
        this.fecha = fecha;
    }

    public Partido(Partido p) {
        this.idequipolocal = p.idequipolocal;
        this.idequipovisitante = p.idequipovisitante;
        this.goleslocal = p.goleslocal;
        this.golesvisitante = p.golesvisitante;
    }

    public int getIdequipolocal() {
        return idequipolocal;
    }

    public void setIdequipolocal(int idequipolocal) {
        this.idequipolocal = idequipolocal;
    }

    public int getIdequipovisitante() {
        return idequipovisitante;
    }

    public void setIdequipovisitante(int idequipovisitante) {
        this.idequipovisitante = idequipovisitante;
    }

    public int getGoleslocal() {
        return goleslocal;
    }

    public void setGoleslocal(int goleslocal) {
        this.goleslocal = goleslocal;
    }

    public int getGolesvisitante() {
        return golesvisitante;
    }

    public void setGolesvisitante(int golesvisitante) {
        this.golesvisitante = golesvisitante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public static ArrayList<Partido> generateMatches(ArrayList<Equipo> participantes){
        ArrayList<Partido> ret = new ArrayList<>();
        for (int i = 0; i < participantes.size(); i++) {
            for (Equipo e : participantes) {
                if (!e.equals(participantes.get(i))) {
                    int id = ret.size() +1;
                    Partido partido = new Partido( id, e.getId(), participantes.get(i).getId());
                    ret.add(partido);
                }
            }
        }
    return ret;}

    @Override
    public String toString() {
        return "Partido{" + "id=" + id + ", idequipolocal=" + idequipolocal + ", idequipovisitante=" + idequipovisitante + ", goleslocal=" + goleslocal + ", golesvisitante=" + golesvisitante + ", fecha=" + fecha + '}';
    }
    
    
    
}

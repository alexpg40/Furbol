/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furbol;

import java.sql.Date;

/**
 *
 * @author Alex Perez
 */
public class Partido {

    private int idequipolocal;
    private int idequipovisitante;
    private int goleslocal;
    private int golesvisitante;
    private Date fecha;

    public Partido() {

    }
    
    public Partido(int idequipolocal, int idequipovisitante){
        this.idequipolocal = idequipolocal;
        this.idequipovisitante = idequipovisitante;
    }
    
    public Partido(int idequipolocal, int idequipovisitante, String resultado, int goleslocal, int golesvisitante) {
        this.idequipolocal = idequipolocal;
        this.idequipovisitante = idequipovisitante;
        this.goleslocal = goleslocal;
        this.golesvisitante = golesvisitante;
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
    
    @Override
    public String toString() {
        return Equipo.getEquipoByID(this.idequipolocal).getNombre() + " vs " + Equipo.getEquipoByID(this.idequipovisitante).getNombre();
    }

    
    
}

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
public class Partido {

    private int idequipolocal;
    private int idequipovisitante;
    private String resultado;
    private int goleslocal;
    private int golesvisitante;

    public Partido() {

    }

    public Partido(int idequipolocal, int idequipovisitante, String resultado, int goleslocal, int golesvisitante) {
        this.idequipolocal = idequipolocal;
        this.idequipovisitante = idequipovisitante;
        this.resultado = resultado;
        this.goleslocal = goleslocal;
        this.golesvisitante = golesvisitante;
    }

    public Partido(Partido p) {
        this.idequipolocal = p.idequipolocal;
        this.idequipovisitante = p.idequipovisitante;
        this.resultado = p.resultado;
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

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
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

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furbol;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 *
 * @author alex
 */
public class Competicion {
    
    private int id;
    private String nombre;
    private int temporada;
    private ArrayList<Equipo> participantes = new ArrayList<>();
    private LinkedHashSet<Equipo> clasificacion;
    private ArrayList<Partido> partidos = new ArrayList<>();
    
    public Competicion() {
        
    }    
    
    public Competicion(int id, String nombre, int temporada){
        this.id = id;
        this.nombre = nombre;
        this.temporada = temporada;
    }
    
    public Competicion(String nombre, int temporada, ArrayList<Equipo> participantes) {
        this.nombre = nombre;
        this.temporada = temporada;
        this.participantes = participantes;
        this.clasificacion = new LinkedHashSet<>(participantes);
    }
    
    public Competicion(Competicion e) {
        this.nombre = e.nombre;
        this.temporada = e.temporada;
        this.clasificacion = e.clasificacion;
        this.participantes = e.participantes;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getTemporada() {
        return temporada;
    }
    
    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }
    
    public LinkedHashSet<Equipo> getClasificacion() {
        return clasificacion;
    }
    
    public void setClasificacion(LinkedHashSet<Equipo> clasificacion) {
        this.clasificacion = clasificacion;
    }
    
    public ArrayList<Equipo> getParticipantes() {
        return participantes;
    }
    
    public void setParticipantes(ArrayList<Equipo> participantes) {
        this.participantes = participantes;
    }
    
    public ArrayList<Partido> getPartidos() {
        return partidos;
    }
    
    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }
    
    public Equipo winner() {
        Iterator it = this.getClasificacion().iterator();
        return (Equipo) it.next();
    }
    
    public Competicion newCompeticion(String nombre, int temporada, ArrayList<Equipo> participantes) {
        Competicion ret = new Competicion(nombre, temporada, participantes);
        ArrayList<Partido> matches = Partido.generateMatches(participantes);
        ret.setPartidos(matches);;
        return ret;
    }
    
    public void infoCompeticion() {
        System.out.println("El nombre de la competicion es " + this.nombre);
        System.out.println("Participan los siguentes equipos:");
        for (Equipo e : this.participantes) {
            System.out.println(e.getNombre());
        }
    }
    
    public ArrayList<Partido> gamesOf(Equipo e) {
        System.out.println("Partidos de " + e.getNombre() + "\n");
        ArrayList<Partido> ret = new ArrayList<>();
        for (Partido p : this.partidos) {
            if (p.getIdequipolocal() == e.getId() || p.getIdequipovisitante() == e.getId()) {
                ret.add(p);
                }
        }
        if (ret.equals(null)) {
            System.out.println("No tiene partidos");
        }
        return ret;
    }
    
    public void imprimirClasificacion(){
        Iterator it = this.clasificacion.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    
}

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
    
    private String nombre;
    private int temporada;
    private LinkedHashSet<Equipo> clasificacion;
    private ArrayList<Partido> partidos;

    public Competicion(){
        
    } 
    
    public Competicion(String nombre,int temporada, LinkedHashSet<Equipo> clasificacion){
        this.nombre = nombre;
        this.temporada = temporada;
        this.clasificacion = clasificacion;
    }
    
    public Competicion(Competicion e){
        this.nombre = e.nombre;
        this.temporada = e.temporada;
        this.clasificacion = e.clasificacion;
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
    
    public Equipo winner(){
        Iterator it = this.getClasificacion().iterator();
        return (Equipo) it.next();
    }
}

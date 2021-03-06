/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;

/**
 *
 * @author lauti
 */
public class Documento implements Serializable, Comparable<Documento>{
    
    private String nombre;
    private String ruta;
    private Double peso;
    
    private static final long serialVersionUID = 6529685098267757988L;


    public Documento(String nombre, String ruta) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.peso = 0D;
    }
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "Documento: " + "nombre:" + nombre + ", ruta:" + ruta + '}';
    }

    @Override
    public int compareTo(Documento o) {
        return o.peso.compareTo(this.peso);
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
    
    public void incrementarPeso(Double peso){
        this.peso = this.peso + peso;
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author lauti
 */
public class Termino implements Serializable{
    
   //La palabra en cuestion
    private String palabra;
    //nr: cantidad de documentos en los que el termino aparece
    private Integer nr;
    //MaxTf: maxima cantidad de veces que aparece el termino por documento
    private Integer maxTf;
    //Posteo: significa que la palabra aparezca en un documento. Se almacena el documento y la Tf 
    private TreeMap<Documento, Integer> posteos;
    

    public Termino(String palabra) {
        this.palabra = palabra;
        nr = 0;
        maxTf = 1;
        posteos = new TreeMap<>();
    }
    

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public Integer getMaxTf() {
        return maxTf;
    }

    public void setMaxTf(Integer maxTf) {
        this.maxTf = maxTf;
    }

    public TreeMap<Documento, Integer> getPosteos() {
        return posteos;
    }

    public void setPosteos(TreeMap<Documento, Integer> posteos) {
        this.posteos = posteos;
    }
    
    public void incremetarNr(){
        this.nr++;
    }
    
    public void verificarMaxTf(Integer maxTf){
        if(this.maxTf < maxTf){
            this.maxTf = maxTf;
        }
    }

    void agregarPosteo(Documento doc) {
        if(posteos.containsKey(doc)){
            incrementarPosteo(doc);
        }
        else{
            posteos.put(doc, 1);
            nr++;
        }
        
    }
    
    private void incrementarPosteo(Documento doc){
        Integer frecNueva = posteos.get(doc);
        frecNueva++;
        maxTf = Math.max(frecNueva, maxTf);
        posteos.replace(doc, maxTf);
    }
    
    public void ordenarPosteo(){
    
        Set<Entry<Documento, Integer>> set = posteos.entrySet();
        ArrayList<Entry<Documento, Integer>> lista = new ArrayList<>(set);
        
        Collections.sort(lista, new Comparator<Entry<Documento, Integer>>() {
            @Override
            public int compare(Entry<Documento, Integer> a, Entry<Documento, Integer> b) {
                return b.getValue().compareTo(a.getValue());
            }
        });
       
        posteos.clear();
        
        lista.forEach((entry) -> {
            posteos.put(entry.getKey(), entry.getValue());
        });
        
    }
    
    
}

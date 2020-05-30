/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.HashMap;
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
    private HashMap<Documento, Integer> posteos;

    public Termino(String palabra) {
        this.palabra = palabra;
        nr = 0;
        maxTf = 1;
        posteos = new HashMap<>();
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

    public HashMap<Documento, Integer> getPosteos() {
        return posteos;
    }

    public void setPosteos(HashMap<Documento, Integer> posteos) {
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
        maxTf = Math.max(frecNueva, maxTf);
        posteos.replace(doc, frecNueva);
    }
    
    
}

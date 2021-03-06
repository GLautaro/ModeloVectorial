/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author lauti
 */
public class Termino implements Serializable, Comparable<Termino> {

    //La palabra en cuestion
    private String palabra;
    //nr: cantidad de documentos en los que el termino aparece
    private Integer nr;
    //Posteo: significa que la palabra aparezca en un documento. Se almacena el documento y la Tf 
    private ArrayList<Posteo> posteos;
     private static final long serialVersionUID = 6529685098267757690L;

    public Termino(String palabra) {
        this.palabra = palabra;
        nr = 0;
        posteos = new ArrayList<>();
    }

    public Termino(String palabra, Integer nr) {
        this.palabra = palabra;
        this.nr = nr;
        posteos = new ArrayList<>();
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




    public ArrayList<Posteo> getPosteos() {
        return posteos;
    }

    public void setPosteos(ArrayList<Posteo> posteos) {
        this.posteos = posteos;
    }

    public void incremetarNr() {
        this.nr++;
    }

  

    void agregarPosteo(Documento doc) {
        if(posteos.isEmpty()){
             this.posteos.add(new Posteo(doc.getNombre()));
                nr++;
                return;
        }
        for (Posteo posteo : this.posteos) {
            if (posteo.getDocumento() == doc.getNombre()) {
                posteo.incrementarTf();
                return;
            }
        }
    this.posteos.add(new Posteo(doc.getNombre()));
        nr++;
             

    }


    public void ordenarPosteo() {    
     
         Collections.sort(posteos);

    }

    @Override
    public int compareTo(Termino o) {
        return this.nr.compareTo(o.nr);
    }

}

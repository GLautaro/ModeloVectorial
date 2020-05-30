/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author lauti
 */
public class Vocabulario implements Serializable{
    
    private HashMap<String, Termino> vocabulario;
    
    private static final long serialVersionUID = 6529685098267757001L;

    public Vocabulario() {
        vocabulario = new HashMap<>();
    }

    public HashMap<String, Termino> getVocabulario() {
        return vocabulario;
    }
    
    
    public Termino getTermino (String palabra){
        return vocabulario.get(palabra);
    }
    
    public boolean existeTermino(String palabra){
        return vocabulario.containsKey(palabra);
    }
    
    public void agregarPosteo(Documento doc, String ter){
        Termino t;
        if((t = vocabulario.get(ter)) != null){
            t.agregarPosteo(doc);
        }
        else{
            t = new Termino(ter);
            t.agregarPosteo(doc);
            vocabulario.put(ter, t);
        } 
    }
    
    
    
    
    
}

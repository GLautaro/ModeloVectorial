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

    public Vocabulario() {
        vocabulario = new HashMap<>();
    }

    
    public Termino getTermino (String palabra){
        return vocabulario.get(palabra);
    }
    
    public boolean existeTermino(String palabra){
        return vocabulario.containsKey(palabra);
    }
    
    
    
    
    
}

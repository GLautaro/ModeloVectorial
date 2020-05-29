/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Documento;
import entidades.Termino;
import entidades.Vocabulario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import soporte.Serializador;
import utils.ParserPalabra;
/**
 *
 * @author agu_9
 */
public class ModeloVectorial {
    
    
    public ArrayList<String> procesarTextoBusqueda(String q) {
        
        ArrayList<String> listadoPalabras = new ArrayList<>();
        String separador = "[1234567890,-.!¡?¿()_ /:%&;#\"$*{}]$=+@|°¬'+~^<>«»*";
        StringTokenizer st = new StringTokenizer(q, separador);
        int cantPalabras = st.countTokens();
        for (int i = 0; i < cantPalabras; i++) {
            String palabra = ParserPalabra.limpiarPalabra(st.nextToken());
            listadoPalabras.add(palabra);
        }
        
        return listadoPalabras;

    }
    
    
    public void procesarBusqueda(String q, Integer r){
        ArrayList<Documento> LD = null;
        ArrayList<Termino> queryTerminos = new ArrayList<>();
        Serializador sr = new Serializador();
        Vocabulario vocabulario = sr.readVocabulario();   
        HashMap<String, Termino> terminos = vocabulario.getVocabulario();
        
        ArrayList<String> query = procesarTextoBusqueda(q);
        
        for (String palabra : query) {
            Termino termActual = terminos.get(palabra);
            if(!queryTerminos.contains(termActual)){
                queryTerminos.add(termActual);
            }                
        }
        
        System.out.println(queryTerminos);

    }
    
    
}

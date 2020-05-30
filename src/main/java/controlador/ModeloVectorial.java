/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Documento;
import entidades.Posteo;
import entidades.Termino;
import entidades.Vocabulario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
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
    
    
    public List<Documento> procesarBusqueda(String q, Integer r){
        //Lista de documentos a retornar
        List<Documento> LD = new ArrayList<>();
        //Lista de terminos a procesar
        ArrayList<Termino> queryTerminos;
        queryTerminos = new ArrayList<>();
        //Nos permite obtener el vocabulario serializado y la lista de documentos.
        Serializador sr = new Serializador();
        Vocabulario vocabulario = sr.readVocabulario(); 
        ArrayList<Documento> documentos = sr.readDocumentos();
        //Hashmap que contiene cada termino
        HashMap<String, Termino> terminos;
        terminos = vocabulario.getVocabulario();
        //Terminos de la consulta
        ArrayList<String> query = procesarTextoBusqueda(q);
        //Comienza a procesar
        
        for (String palabra : query) {
            Termino termActual = terminos.get(palabra);
            if(termActual != null && !queryTerminos.contains(termActual)){
                queryTerminos.add(termActual);
                                                
                /*
                ArrayList<Posteo> posteos = termActual.getPosteos();                 
                for (Posteo posteo : posteos) {
                    LD.add(posteo.getDocumento());                   
                } */       
            }                
        }
        //Tengo la lista de termino a procesar ordenada por Nr.
        Collections.sort(queryTerminos);
        
        //Agregar Documentos a LD
        for (Termino queryTermino : queryTerminos) {
            ArrayList<Posteo> posteos = queryTermino.getPosteos();
            for (Posteo posteo: posteos) {
                Documento doc = posteo.getDocumento();
                if(!LD.contains(doc)){
                    LD.add(doc);
                }                
                float division = ((float)documentos.size()/(float)queryTermino.getNr());
                Double logaritmo = Math.log10(division);
                Double pesoDoc = posteo.getTf() * logaritmo;
                doc.incrementarPeso(pesoDoc);
            }            
        }
        
        Collections.sort(LD);
        
        if(r>LD.size()){
            r=LD.size();
        }
        
        //System.out.println(LD.get(0).getNombre());
        //System.out.println(queryTerminos);
        
        return LD;
    }
    

    
    
}

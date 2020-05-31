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
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import soporte.AlmacenamientoDisco;
import soporte.Serializador;
import utils.Configuracion;
import utils.ParserPalabra;

/**
 *
 * @author agu_9
 */
@ApplicationScoped
public class ModeloVectorial {

    
    private HashMap<String, Documento> documentos = new HashMap<>();
    private AlmacenamientoDisco ad;


    public ModeloVectorial() {

    }

    @PostConstruct
    public void serializacion() {
        Serializador sr = new Serializador();
        documentos = sr.readDocumentos();
        ad = new AlmacenamientoDisco();
    }

    public ArrayList<String> procesarTextoBusqueda(String q) {

        ArrayList<String> listadoPalabras = new ArrayList<>();
        String separador = Configuracion.SEPARADORES;
        StringTokenizer st = new StringTokenizer(q, separador);
        int cantPalabras = st.countTokens();
        for (int i = 0; i < cantPalabras; i++) {
            String palabra = ParserPalabra.limpiarPalabra(st.nextToken());
            listadoPalabras.add(palabra);
        }

        return listadoPalabras;

    }

    public List<Documento> procesarBusqueda(String q, Integer r) {
        //Lista de documentos a retornar
        List<Documento> LD = new ArrayList<>();
        //Terminos de la consulta
        ArrayList<String> query = procesarTextoBusqueda(q);
        //Comienza a procesar
        ArrayList<Termino> terminos = ad.leerPosteos(query);
        
        
        //Tengo la lista de termino a procesar ordenada por Nr.
        Collections.sort(terminos);

        //Agregar Documentos a LD
        for (Termino queryTermino : terminos) {
            ArrayList<Posteo> posteos = queryTermino.getPosteos();

            for (Posteo posteo : posteos) {

                Documento doc = documentos.get(posteo.getDocumento());

                if (!LD.contains(doc)) {
                    LD.add(doc);
                }
                float division = ((float) documentos.size() / (float) queryTermino.getNr());
                Double logaritmo = Math.log10(division);
                Double pesoDoc = posteo.getTf() * logaritmo;
                doc.incrementarPeso(pesoDoc);
            }
        }

        Collections.sort(LD);

        if (r > LD.size()) {
            r = LD.size();
        }

        //System.out.println(LD.get(0).getNombre());
        //System.out.println(queryTerminos);
        return LD.subList(0, r);
    }

}

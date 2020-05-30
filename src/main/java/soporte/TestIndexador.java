/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte;

import controlador.ModeloVectorial;
import entidades.Documento;
import entidades.Termino;

import entidades.Vocabulario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author lauti
 */
public class TestIndexador {

    public static void main(String[] args) {
        
        IndexadorDocumentos inDoc = new IndexadorDocumentos();
        Serializador ser = new Serializador();

        inDoc.indexarDocumentos();
        Vocabulario voc = inDoc.getVocabulario();
        HashMap hs = voc.getVocabulario();
        System.out.println(hs.size());

        // Esta comentada para que no vuelva a hacer la serializacion
        //ser.writeVocabulario(inDoc.getVocabulario());

        //ser.readVocabulario();

        //System.out.println(inDoc.getVocabulario().toString());
        ModeloVectorial mv = new ModeloVectorial();
        ArrayList<Documento> docs = mv.procesarBusqueda("get", 2);

        for (Documento next : docs) {
            System.out.println(next.toString());
        }
        
        
     
    }

}

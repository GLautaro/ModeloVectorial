/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Documento;
import entidades.Vocabulario;
import java.util.HashMap;
import soporte.AlmacenamientoDisco;
import soporte.IndexadorDocumentos;
import soporte.Serializador;

/**
 *
 * @author lauti
 */
public class IndexadorController {
    
    public void iniciarIndexacion(){
    
        IndexadorDocumentos inDoc = new IndexadorDocumentos();
        Serializador ser = new Serializador();
       
        //Inicializa la indexacion
        inDoc.indexarDocumentos();
        //Obtiene el vocabulario
        Vocabulario voc = inDoc.getVocabulario();       
        //Escribe el archivo de documentos
        HashMap<String, Documento> listaDoc = inDoc.getListaDoc();
        ser.writeDocumentos(listaDoc);
        
        AlmacenamientoDisco ad = new AlmacenamientoDisco();
        //Escribe el archivo de posteos
        ad.escrituraPosteos(voc);
    }
    
}

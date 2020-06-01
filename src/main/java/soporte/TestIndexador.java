/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte;



import entidades.Vocabulario;
import java.util.HashMap;

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
        System.out.println(inDoc.getListaDoc().toString());
        
        ser.writeDocumentos(inDoc.getListaDoc());
        
        AlmacenamientoDisco ad = new AlmacenamientoDisco();
        ad.escrituraPosteos(voc);
       /*
        ArrayList<String> terminosBuscar = new ArrayList<>();
        terminosBuscar.add("william");
        terminosBuscar.add("hola");
        terminosBuscar.add("the");
        ArrayList<Termino> posteitos = ad.leerPosteos(terminosBuscar);
        System.out.println(posteitos.toString());
        
        
        // Esta comentada para que no vuelva a hacer la serializacion
        //ser.writeVocabulario(inDoc.getVocabulario());
        //ser.writeDocumentos(inDoc.getListaDoc());
        //ser.readVocabulario();
        //System.out.println(inDoc.getVocabulario().toString());
       
        ModeloVectorial mv = new ModeloVectorial();
        mv.serializacion();
        List<Documento> docs = mv.procesarBusqueda("dante get", 2);
        for (Documento next : docs) {
        System.out.println(next.toString());
        }
        */
    }

}

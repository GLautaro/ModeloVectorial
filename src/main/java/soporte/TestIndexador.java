/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte;

/**
 *
 * @author lauti
 */
public class TestIndexador {
    
    public static void main(String[] args) {
        IndexadorDocumentos inDoc = new IndexadorDocumentos();
        
        inDoc.indexarDocumentos();
        
        System.out.println(inDoc.getVocabulario().toString());
    }
    
}

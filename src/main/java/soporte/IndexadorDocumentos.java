/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte;

import entidades.Documento;
import entidades.Vocabulario;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Constantes;

/**
 *
 * @author lauti
 */
public class IndexadorDocumentos {
    
    private String rutaCarpeta;
    private File carpeta;
    private Vocabulario vocabulario;
    private File[] listaDoc;
    private FilenameFilter filtro;

    public IndexadorDocumentos() {
        this.rutaCarpeta = Constantes.RUTA_ARCHIVO_DOCUMENTOS;
        vocabulario =  new Vocabulario();
        filtro = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                return name.endsWith(".txt");
            }
        };
    }
    
    private void inicializarCarpeta(){
        try {
            carpeta = new File(rutaCarpeta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
               
    }
    
    public void indexarDocumentos(){
        inicializarCarpeta();
        try {
            System.out.println(carpeta.getCanonicalPath());
        } catch (IOException ex) {
            Logger.getLogger(IndexadorDocumentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        listaDoc = carpeta.listFiles(filtro);
        System.out.println(Arrays.toString(listaDoc));
        
        

       
        
        
        
    } 
    
        
    
    
}

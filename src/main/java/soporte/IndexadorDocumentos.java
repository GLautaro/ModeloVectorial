/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte;

import entidades.Vocabulario;
import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lauti
 */
public class IndexadorDocumentos {
    
    private String rutaCarpeta;
    private File carpeta;
    private Vocabulario vocabulario;
    private List<File> listaArchivos;
    private FilenameFilter filtro;

    public IndexadorDocumentos(String rutaCarpeta) {
        this.rutaCarpeta = rutaCarpeta;
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
        
        
        
    } 
    
        
    
    
}

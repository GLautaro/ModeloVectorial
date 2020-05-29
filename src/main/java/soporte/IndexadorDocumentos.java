<<<<<<< HEAD
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
import java.util.StringTokenizer;
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
        this.rutaCarpeta = "C:\\Users\\agu_9\\Desktop\\Iteracion";
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
        for (File file : listaDoc) {
            leerDocumentos(file);
        }
      
    } 
    
    
    private void leerDocumentos(File documento){
        
        try {
            FileReader fr = new FileReader(documento);
            BufferedReader br = new BufferedReader(fr);
            String lineaTexto = br.readLine();            
            String separador = Constantes.SEPARADORES;
            
            String nombreDocumento = documento.getName();
            String rutaDocumento = documento.getPath();
            
            Documento nuevoDoc = new Documento(nombreDocumento, rutaDocumento);
                    
            
            while (lineaTexto != null) {
                StringTokenizer st = new StringTokenizer(lineaTexto, separador);
                int cantPalabras = st.countTokens();
                
                for (int i = 0; i < cantPalabras; i++) {
                    String palabraLimpia = limpiarPalabra(st.nextToken());
                    if(palabraLimpia.trim().length() > 1){
                        vocabulario.agregarPosteo(nuevoDoc, palabraLimpia);  
                       
                    }                                       
                }
                lineaTexto = br.readLine();
                                
            }
             
            
                        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IndexadorDocumentos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IndexadorDocumentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
    }
    
    
    private String limpiarPalabra(String token){
        String palabraLimpia = limpiarVocales(token);
        palabraLimpia = palabraLimpia.toLowerCase();
     
        return palabraLimpia;
    }
    
    
    private String limpiarVocales(String token){
        String original = "áàäéèëíìïóòöúùüç";
        String modificacion = "aaaeeeiiiooouuuc";
    
        for (int z = 0; z < original.length(); z++) {
            token = token.replace(original.charAt(z), modificacion.charAt(z));
        }
     
        return token;
    }

    public Vocabulario getVocabulario() {
        return vocabulario;
    }
        
    
    
}
=======
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
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Configuracion;

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
        this.rutaCarpeta = Configuracion.RUTA_CARPETA_DOCUMENTOS;
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
        for (File file : listaDoc) {
            leerDocumentos(file);
        }
      
    } 
    
    
    private void leerDocumentos(File documento){
        
        try {
            FileReader fr = new FileReader(documento);
            BufferedReader br = new BufferedReader(fr);
            String lineaTexto = br.readLine();            
            String separador = Configuracion.SEPARADORES;
            
            String nombreDocumento = documento.getName();
            String rutaDocumento = documento.getPath();
            
            Documento nuevoDoc = new Documento(nombreDocumento, rutaDocumento);
                    
            
            while (lineaTexto != null) {
                StringTokenizer st = new StringTokenizer(lineaTexto, separador);
                int cantPalabras = st.countTokens();
                
                for (int i = 0; i < cantPalabras; i++) {
                    String palabraLimpia = limpiarPalabra(st.nextToken());
                    if(palabraLimpia.trim().length() > 1){
                        vocabulario.agregarPosteo(nuevoDoc, palabraLimpia);                                                
                    }                                       
                }
                lineaTexto = br.readLine();
                                
            }
            
                       
            
                        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IndexadorDocumentos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IndexadorDocumentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
    }
    
    
    private String limpiarPalabra(String token){
        String palabraLimpia = limpiarVocales(token);
        palabraLimpia = palabraLimpia.toLowerCase();
     
        return palabraLimpia;
    }
    
    
    private String limpiarVocales(String token){
        String original = "áàäéèëíìïóòöúùüç";
        String modificacion = "aaaeeeiiiooouuuc";
    
        for (int z = 0; z < original.length(); z++) {
            token = token.replace(original.charAt(z), modificacion.charAt(z));
        }
     
        return token;
    }

    public Vocabulario getVocabulario() {
        return vocabulario;
    }
        
    
    
}
>>>>>>> 533a2235e38857a267e3bd0adf79e272b32b22d2

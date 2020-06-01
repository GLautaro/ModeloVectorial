/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte;

import entidades.Documento;
import entidades.Termino;
import entidades.Vocabulario;
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Configuracion;
import utils.ParserPalabra;

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
    private HashMap<String, Documento> listaSerialDoc = new HashMap<>();

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
            carpeta = new File("C:\\Users\\agu_9\\Desktop\\DocumentosTP1");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
               
    }
    
    public void indexarDocumentos(){
        inicializarCarpeta();
            
        listaDoc = carpeta.listFiles(filtro);
        for (File file : listaDoc) {
            leerDocumentos(file);
        }
        
        HashMap<String, Termino> terminos = vocabulario.getVocabulario();
        
        terminos.entrySet().forEach((entry) -> {
            entry.getValue().ordenarPosteo();
        });
      
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
            listaSerialDoc.put(nuevoDoc.getNombre(), nuevoDoc);
                    
            
            while (lineaTexto != null) {
                StringTokenizer st = new StringTokenizer(lineaTexto, separador);
                int cantPalabras = st.countTokens();
                
                for (int i = 0; i < cantPalabras; i++) {
                    String palabraLimpia = ParserPalabra.limpiarPalabra(st.nextToken());
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
    
  
    

    public Vocabulario getVocabulario() {
        return vocabulario;
    }

    public HashMap<String, Documento> getListaDoc() {
        return listaSerialDoc;
    }
        
    
    
}


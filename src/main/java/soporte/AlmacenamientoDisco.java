/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte;

import entidades.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lauti
 */
public class AlmacenamientoDisco {
    
    public void escrituraPosteos(Vocabulario voc){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Projects\\ModeloVectorial\\posteos.txt");
            pw = new PrintWriter(fichero);
            
            Collection<Termino> terminos = voc.getVocabulario().values();
            for (Termino termino : terminos) {
                pw.print(termino.getPalabra() + "|" + termino.getNr());
                ArrayList<Posteo> posteos = termino.getPosteos();
                for (Posteo posteo : posteos) {
                    pw.print("|" + posteo.getDocumento() + "|" + posteo.getTf());                    
                }
                pw.println("");                
            }
        } catch (IOException e) {
        } finally {
            try {
                if(fichero != null){ fichero.close();}
            } catch (IOException e2) {
            }
        }
    
    }
    
    public ArrayList<Termino> leerPosteos(ArrayList<String> terminoBusq){
        ArrayList<Termino> terminoReturn = new ArrayList<>();
        FileReader file = null;
        BufferedReader br = null;
        try {
            file = new FileReader("C:\\Projects\\ModeloVectorial\\posteos.txt");
            br = new BufferedReader(file);
            String lineaTexto = br.readLine();
            
            while(lineaTexto != null && !terminoBusq.isEmpty()){
                Termino terminoNuevo = null;
                String[] lineaProcesada = lineaTexto.split("[|]");
                String terminoEncontrado = lineaProcesada[0];
                Integer nr = Integer.parseInt(lineaProcesada[1]);
                if(terminoBusq.contains(terminoEncontrado)){
                    terminoNuevo = new Termino(terminoEncontrado, nr);
                    terminoBusq.remove(terminoEncontrado);
                    for (int i = 2; i < lineaProcesada.length; i+=2) {
                        String nombreDoc = lineaProcesada[i];
                        int tf = Integer.parseInt(lineaProcesada[i+1]);
                        Posteo post = new Posteo(nombreDoc, tf);
                        terminoNuevo.getPosteos().add(post);                  
                        
                    }
                    terminoReturn.add(terminoNuevo);
                }
                lineaTexto = br.readLine();
                            
            }
            
        } catch (FileNotFoundException e) {
        } catch (IOException ex) {
            Logger.getLogger(AlmacenamientoDisco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return terminoReturn;
    }
    
}

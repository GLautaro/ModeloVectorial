/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte;

import entidades.Documento;
import entidades.Vocabulario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Configuracion;

/**
 *
 * @author lauti
 */
public class Serializador {

    public Serializador() {
    }
    
    
    public void writeDocumentos(HashMap <String, Documento> listaDoc){
        try {
            FileOutputStream fos = new FileOutputStream("D:\\DLC\\ModeloVectorial\\documentos.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listaDoc);
            oos.close();
            fos.close();
            System.out.println("Vocabulario serializado en 'documentos.dat'.");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Serializador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public HashMap<String, Documento> readDocumentos(){
        HashMap<String, Documento> documentos = null;
        try {
            
            FileInputStream file = new FileInputStream("D:\\DLC\\ModeloVectorial\\documentos.dat");
          
            ObjectInputStream obj = new ObjectInputStream(file);
            documentos = (HashMap<String, Documento>) obj.readObject();
            obj.close();
            file.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            
        }
        System.out.println("SERIALIZA doc");
        return documentos;
    }

}



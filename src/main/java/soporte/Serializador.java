/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte;

import entidades.Vocabulario;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lauti
 */
public class Serializador {
    
    public void writeVocabulario(Vocabulario vocabulario){
        try {
            FileOutputStream fos = new FileOutputStream("vocabulario.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(vocabulario);
            oos.close();
            fos.close();
            System.out.println("Vocabulario serializado en 'vocabulario.dat'.");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Serializador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    
    }
    
}

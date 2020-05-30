/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;

/**
 *
 * @author agu_9
 */
public class Posteo implements Serializable, Comparable<Posteo> {
    
    
    private Documento documento;
    private Integer tf;
    
    public Posteo(Documento documento) {
        this.documento = documento;
        this.tf = 1;
    }
    
    public Posteo(Documento documento, Integer tf) {
        this.documento = documento;
        this.tf = tf;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Integer getTf() {
        return tf;
    }

    public void setTf(Integer tf) {
        this.tf = tf;
    }
    
    public void incrementarTf(){
        this.tf++;
    }

    @Override
    public int compareTo(Posteo o) {
        return this.tf.compareTo(o.tf);
    }
    

    
    
    
    
}

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
    
    
    private String documento;
    private Integer tf;
    

    
    public Posteo(String documento) {
        this.documento = documento;
        this.tf = 1;
    }
    
    public Posteo(String documento, Integer tf) {
        this.documento = documento;
        this.tf = tf;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
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
        return o.tf.compareTo(this.tf);
    }
    

    
    
    
    
}

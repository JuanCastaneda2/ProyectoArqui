/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.presentacionweb.webmvcrentas.repositorios;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author admin
 */
@Named(value = "registroDataRepositorio")
@SessionScoped
public class RegistroDataRepositorio implements Serializable {

    /**
     * Creates a new instance of RegistroDataRepositorio
     */
    public RegistroDataRepositorio() {
    }
    
}

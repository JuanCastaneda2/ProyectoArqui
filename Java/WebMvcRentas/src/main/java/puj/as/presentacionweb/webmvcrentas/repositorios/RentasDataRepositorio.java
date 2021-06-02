/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.presentacionweb.webmvcrentas.repositorios;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import puj.as.sidecar.entities.Rentas;

/**
 *
 * @author admin
 */
@Named(value = "rentasDataRepositorio")
@SessionScoped
public class RentasDataRepositorio implements Serializable {
    
    private Rentas renta;
    private List<Rentas> rentas;

    /**
     * Creates a new instance of RentasDataRepositorio
     */
    public RentasDataRepositorio() {
    }

    public Rentas getRenta() {
        return renta;
    }

    public void setRenta(Rentas renta) {
        this.renta = renta;
    }

    public List<Rentas> getRentas() {
        return rentas;
    }

    public void setRentas(List<Rentas> rentas) {
        this.rentas = rentas;
    }
    
    
    
}

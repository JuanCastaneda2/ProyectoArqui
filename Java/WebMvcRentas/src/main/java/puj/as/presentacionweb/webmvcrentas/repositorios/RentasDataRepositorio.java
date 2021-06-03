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
import puj.as.sidecar.entities.Renta;

/**
 *
 * @author admin
 */
@Named(value = "rentasDataRepositorio")
@SessionScoped
public class RentasDataRepositorio implements Serializable {
    
    private Renta renta;
    private List<Renta> rentas;

    /**
     * Creates a new instance of RentasDataRepositorio
     */
    public RentasDataRepositorio() {
    }

    public Renta getRenta() {
        return renta;
    }

    public void setRenta(Renta renta) {
        this.renta = renta;
    }

    public List<Renta> getRentas() {
        return rentas;
    }

    public void setRentas(List<Renta> rentas) {
        this.rentas = rentas;
    }
    
    
    
}

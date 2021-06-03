/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.presentacionweb.webmvcrentas.repositorios;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import puj.as.sidecar.entities.Solicitud;

/**
 *
 * @author admin
 */
@Named(value = "solicitudDataRepositorio")
@SessionScoped
public class SolicitudDataRepositorio implements Serializable {

    private Solicitud solicitud;
    /**
     * Creates a new instance of SolicitudDataRepositorio
     */
    public SolicitudDataRepositorio() {
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    
    
}

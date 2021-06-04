/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.sidecar.entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Confirmacion implements Serializable {
    
    int aprobacion;
    String fecha;

    public Confirmacion() {
    }

    public int getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(int aprobacion) {
        this.aprobacion = aprobacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.presentacionweb.webmvcrentas.dtos;

import java.util.Date;
import javax.ws.rs.FormParam;
import puj.as.sidecar.entities.Confirmacion;

/**
 *
 * @author admin
 */
public class ConfirmacionDTO extends Confirmacion {

    @Override
    @FormParam("fecha")
    public void setFecha(String fecha) {
        super.setFecha(fecha); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("fecha")
    public String getFecha() {
        return super.getFecha(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("aprobacion")
    public void setAprobacion(int aprobacion) {
        super.setAprobacion(aprobacion); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("aprobacion")
    public int getAprobacion() {
        return super.getAprobacion(); //To change body of generated methods, choose Tools | Templates.
    }
        
}

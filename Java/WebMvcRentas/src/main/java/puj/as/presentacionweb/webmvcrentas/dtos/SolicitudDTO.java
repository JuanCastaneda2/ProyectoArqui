/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.presentacionweb.webmvcrentas.dtos;

import javax.ws.rs.FormParam;
import puj.as.sidecar.entities.Solicitud;

/**
 *
 * @author admin
 */
public class SolicitudDTO extends Solicitud {

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("id")
    public void setId(int id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("id")
    public int getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("valor")
    public void setValor(int Valor) {
        super.setValor(Valor); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("valor")
    public int getValor() {
        return super.getValor(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("tipo")
    public void setTipo(String Tipo) {
        super.setTipo(Tipo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("tipo")
    public String getTipo() {
        return super.getTipo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("contrasena")
    public void setContrasena(String Contrasena) {
        super.setContrasena(Contrasena); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("contrasena")
    public String getContrasena() {
        return super.getContrasena(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("idUsuario")
    public void setIdUsuario(int IdUsuario) {
        super.setIdUsuario(IdUsuario); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("idUsuario")
    public int getIdUsuario() {
        return super.getIdUsuario(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

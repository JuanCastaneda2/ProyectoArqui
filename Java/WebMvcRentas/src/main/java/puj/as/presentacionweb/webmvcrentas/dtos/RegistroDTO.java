/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.presentacionweb.webmvcrentas.dtos;

import javax.ws.rs.FormParam;
import puj.as.sidecar.entities.Registro;

/**
 *
 * @author admin
 */
public class RegistroDTO extends Registro {

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
    @FormParam("placa")
    public void setPlaca(String placa) {
        super.setPlaca(placa); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("placa")
    public String getPlaca() {
        return super.getPlaca(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("dias")
    public void setDias(Integer dias) {
        super.setDias(dias); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("dias")
    public Integer getDias() {
        return super.getDias(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("monto")
    public void setMonto(Integer monto) {
        super.setMonto(monto); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("monto")
    public Integer getMonto() {
        return super.getMonto(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("nombre")
    public void setNombre(String nombre) {
        super.setNombre(nombre); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("nombre")
    public String getNombre() {
        return super.getNombre(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("registroId")
    public void setRegistroId(String registroId) {
        super.setRegistroId(registroId); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("registroId")
    public String getRegistroId() {
        return super.getRegistroId(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

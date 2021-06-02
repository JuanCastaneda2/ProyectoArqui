/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.sidecar.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "RENTAS", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rentas.findAll", query = "SELECT r FROM Rentas r"),
    @NamedQuery(name = "Rentas.findByIddueno", query = "SELECT r FROM Rentas r WHERE r.iddueno = :iddueno"),
    @NamedQuery(name = "Rentas.findByPlaca", query = "SELECT r FROM Rentas r WHERE r.placa = :placa"),
    @NamedQuery(name = "Rentas.findByTipo", query = "SELECT r FROM Rentas r WHERE r.tipo = :tipo"),
    @NamedQuery(name = "Rentas.findByLocalizacion", query = "SELECT r FROM Rentas r WHERE r.localizacion = :localizacion"),
    @NamedQuery(name = "Rentas.findByModelo", query = "SELECT r FROM Rentas r WHERE r.modelo = :modelo"),
    @NamedQuery(name = "Rentas.findByRentado", query = "SELECT r FROM Rentas r WHERE r.rentado = :rentado")})
public class Rentas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "IDDUENO")
    private int iddueno;
    @Id
    @Basic(optional = false)
    @Column(name = "PLACA")
    private String placa;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "LOCALIZACION")
    private String localizacion;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "RENTADO")
    private Boolean rentado;

    public Rentas() {
    }

    public Rentas(String placa) {
        this.placa = placa;
    }

    public Rentas(String placa, int iddueno) {
        this.placa = placa;
        this.iddueno = iddueno;
    }

    public int getIddueno() {
        return iddueno;
    }

    public void setIddueno(int iddueno) {
        this.iddueno = iddueno;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Boolean getRentado() {
        return rentado;
    }

    public void setRentado(Boolean rentado) {
        this.rentado = rentado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placa != null ? placa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rentas)) {
            return false;
        }
        Rentas other = (Rentas) object;
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "puj.as.sidecar.entities.Rentas[ placa=" + placa + " ]";
    }
    
}

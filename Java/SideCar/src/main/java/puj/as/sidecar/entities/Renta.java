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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "RENTA", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Renta.findAll", query = "SELECT r FROM Renta r"),
    @NamedQuery(name = "Renta.findByIddueno", query = "SELECT r FROM Renta r WHERE r.iddueno = :iddueno"),
    @NamedQuery(name = "Renta.findByPlaca", query = "SELECT r FROM Renta r WHERE r.placa = :placa"),
    @NamedQuery(name = "Renta.findByTipo", query = "SELECT r FROM Renta r WHERE r.tipo = :tipo"),
    @NamedQuery(name = "Renta.findByLocalizacion", query = "SELECT r FROM Renta r WHERE r.localizacion = :localizacion"),
    @NamedQuery(name = "Renta.findByModelo", query = "SELECT r FROM Renta r WHERE r.modelo = :modelo"),
    @NamedQuery(name = "Renta.findByRentado", query = "SELECT r FROM Renta r WHERE r.rentado = :rentado"),
    @NamedQuery(name = "Renta.findByPrecio", query = "SELECT r FROM Renta r WHERE r.precio = :precio")})
public class Renta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDUENO")
    private int iddueno;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PLACA")
    private String placa;
    @Size(max = 50)
    @Column(name = "TIPO")
    private String tipo;
    @Size(max = 50)
    @Column(name = "LOCALIZACION")
    private String localizacion;
    @Size(max = 50)
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "RENTADO")
    private Boolean rentado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private int precio;

    public Renta() {
    }

    public Renta(String placa) {
        this.placa = placa;
    }

    public Renta(String placa, int iddueno, int precio) {
        this.placa = placa;
        this.iddueno = iddueno;
        this.precio = precio;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
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
        if (!(object instanceof Renta)) {
            return false;
        }
        Renta other = (Renta) object;
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "puj.as.sidecar.entities.Renta[ placa=" + placa + " ]";
    }
    
}

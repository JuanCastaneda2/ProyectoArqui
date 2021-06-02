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
@Table(name = "REGISTRO", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r"),
    @NamedQuery(name = "Registro.findByRegistroId", query = "SELECT r FROM Registro r WHERE r.registroId = :registroId"),
    @NamedQuery(name = "Registro.findByNombre", query = "SELECT r FROM Registro r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Registro.findByMonto", query = "SELECT r FROM Registro r WHERE r.monto = :monto"),
    @NamedQuery(name = "Registro.findByDias", query = "SELECT r FROM Registro r WHERE r.dias = :dias"),
    @NamedQuery(name = "Registro.findByPlaca", query = "SELECT r FROM Registro r WHERE r.placa = :placa")})
public class Registro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "REGISTRO_ID")
    private String registroId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "MONTO")
    private Integer monto;
    @Column(name = "DIAS")
    private Integer dias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "PLACA")
    private String placa;

    public Registro() {
    }

    public Registro(String registroId) {
        this.registroId = registroId;
    }

    public Registro(String registroId, String nombre, String placa) {
        this.registroId = registroId;
        this.nombre = nombre;
        this.placa = placa;
    }

    public String getRegistroId() {
        return registroId;
    }

    public void setRegistroId(String registroId) {
        this.registroId = registroId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registroId != null ? registroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if ((this.registroId == null && other.registroId != null) || (this.registroId != null && !this.registroId.equals(other.registroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "puj.as.sidecar.entities.Registro[ registroId=" + registroId + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DarKMeYeR
 */
@Entity
@Table(name = "COBERTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cobertura.findAll", query = "SELECT c FROM Cobertura c"),
    @NamedQuery(name = "Cobertura.findByIdCobertura", query = "SELECT c FROM Cobertura c WHERE c.idCobertura = :idCobertura"),
    @NamedQuery(name = "Cobertura.findByNombre", query = "SELECT c FROM Cobertura c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cobertura.findByDeducible", query = "SELECT c FROM Cobertura c WHERE c.deducible = :deducible"),
    @NamedQuery(name = "Cobertura.findByPrima", query = "SELECT c FROM Cobertura c WHERE c.prima = :prima")})
public class Cobertura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_COBERTURA")
    private String idCobertura;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DEDUCIBLE")
    private int deducible;
    @Basic(optional = false)
    @Column(name = "PRIMA")
    private int prima;
    @JoinColumn(name = "VEHICULO_ID_VEHICULO", referencedColumnName = "ID_VEHICULO")
    @ManyToOne(optional = false)
    private Vehiculo vehiculoIdVehiculo;

    public Cobertura() {
    }

    public Cobertura(String idCobertura) {
        this.idCobertura = idCobertura;
    }

    public Cobertura(String idCobertura, String nombre, int deducible, int prima) {
        this.idCobertura = idCobertura;
        this.nombre = nombre;
        this.deducible = deducible;
        this.prima = prima;
    }

    public String getIdCobertura() {
        return idCobertura;
    }

    public void setIdCobertura(String idCobertura) {
        this.idCobertura = idCobertura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDeducible() {
        return deducible;
    }

    public void setDeducible(int deducible) {
        this.deducible = deducible;
    }

    public int getPrima() {
        return prima;
    }

    public void setPrima(int prima) {
        this.prima = prima;
    }

    public Vehiculo getVehiculoIdVehiculo() {
        return vehiculoIdVehiculo;
    }

    public void setVehiculoIdVehiculo(Vehiculo vehiculoIdVehiculo) {
        this.vehiculoIdVehiculo = vehiculoIdVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCobertura != null ? idCobertura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cobertura)) {
            return false;
        }
        Cobertura other = (Cobertura) object;
        if ((this.idCobertura == null && other.idCobertura != null) || (this.idCobertura != null && !this.idCobertura.equals(other.idCobertura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cobertura[ idCobertura=" + idCobertura + " ]";
    }
    
}

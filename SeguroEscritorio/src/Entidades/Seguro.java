/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
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
@Table(name = "SEGURO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguro.findAll", query = "SELECT s FROM Seguro s"),
    @NamedQuery(name = "Seguro.findByIdSeguro", query = "SELECT s FROM Seguro s WHERE s.idSeguro = :idSeguro"),
    @NamedQuery(name = "Seguro.findByDeducible", query = "SELECT s FROM Seguro s WHERE s.deducible = :deducible"),
    @NamedQuery(name = "Seguro.findByIdVehiculo", query = "SELECT s FROM Seguro s WHERE s.vehiculoIdVehiculo = :vehiculoIdVehiculo"),
    @NamedQuery(name = "Seguro.findByPrima", query = "SELECT s FROM Seguro s WHERE s.prima = :prima")})
public class Seguro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_SEGURO")
    private String idSeguro;
    @Basic(optional = false)
    @Column(name = "DEDUCIBLE")
    private long deducible;
    @Basic(optional = false)
    @Column(name = "PRIMA")
    private long prima;
    @JoinColumn(name = "VEHICULO_ID_VEHICULO", referencedColumnName = "ID_VEHICULO")
    @ManyToOne(optional = false)
    private Vehiculo vehiculoIdVehiculo;

    public Seguro() {
    }

    public Seguro(String idSeguro) {
        this.idSeguro = idSeguro;
    }

    public Seguro(String idSeguro, long deducible, long prima) {
        this.idSeguro = idSeguro;
        this.deducible = deducible;
        this.prima = prima;
    }

    public String getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(String idSeguro) {
        this.idSeguro = idSeguro;
    }

    public long getDeducible() {
        return deducible;
    }

    public void setDeducible(long deducible) {
        this.deducible = deducible;
    }

    public long getPrima() {
        return prima;
    }

    public void setPrima(long prima) {
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
        hash += (idSeguro != null ? idSeguro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguro)) {
            return false;
        }
        Seguro other = (Seguro) object;
        if ((this.idSeguro == null && other.idSeguro != null) || (this.idSeguro != null && !this.idSeguro.equals(other.idSeguro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Seguro[ idSeguro=" + idSeguro + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DarKMeYeR
 */
@Entity
@Table(name = "CIUDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "Ciudad.findByIdCiudad", query = "SELECT c FROM Ciudad c WHERE c.idCiudad = :idCiudad"),
    @NamedQuery(name = "Ciudad.findByNombre", query = "SELECT c FROM Ciudad c WHERE c.nombre = :nombre")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CIUDAD")
    private Short idCiudad;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadIdCiudad")
    private Collection<Empleado> empleadoCollection;
    @JoinColumn(name = "REGION_ID_REGION", referencedColumnName = "ID_REGION")
    @ManyToOne(optional = false)
    private Region regionIdRegion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadIdCiudad")
    private Collection<Taller> tallerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadIdCiudad")
    private Collection<Cliente> clienteCollection;

    public Ciudad() {
    }

    public Ciudad(Short idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Ciudad(Short idCiudad, String nombre) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
    }

    public Short getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Short idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    public Region getRegionIdRegion() {
        return regionIdRegion;
    }

    public void setRegionIdRegion(Region regionIdRegion) {
        this.regionIdRegion = regionIdRegion;
    }

    @XmlTransient
    public Collection<Taller> getTallerCollection() {
        return tallerCollection;
    }

    public void setTallerCollection(Collection<Taller> tallerCollection) {
        this.tallerCollection = tallerCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiudad != null ? idCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.idCiudad == null && other.idCiudad != null) || (this.idCiudad != null && !this.idCiudad.equals(other.idCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Ciudad[ idCiudad=" + idCiudad + " ]";
    }
    
}

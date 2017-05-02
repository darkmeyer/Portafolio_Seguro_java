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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DarKMeYeR
 */
@Entity
@Table(name = "LIQUIDADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Liquidador.findAll", query = "SELECT l FROM Liquidador l"),
    @NamedQuery(name = "Liquidador.findByIdLiquidador", query = "SELECT l FROM Liquidador l WHERE l.idLiquidador = :idLiquidador")})
public class Liquidador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_LIQUIDADOR")
    private String idLiquidador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "liquidadorIdLiquidador")
    private Collection<Siniestro> siniestroCollection;
    @JoinColumn(name = "EMPLEADO_ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @OneToOne(optional = false)
    private Empleado empleadoIdEmpleado;

    public Liquidador() {
    }

    public Liquidador(String idLiquidador) {
        this.idLiquidador = idLiquidador;
    }

    public String getIdLiquidador() {
        return idLiquidador;
    }

    public void setIdLiquidador(String idLiquidador) {
        this.idLiquidador = idLiquidador;
    }

    @XmlTransient
    public Collection<Siniestro> getSiniestroCollection() {
        return siniestroCollection;
    }

    public void setSiniestroCollection(Collection<Siniestro> siniestroCollection) {
        this.siniestroCollection = siniestroCollection;
    }

    public Empleado getEmpleadoIdEmpleado() {
        return empleadoIdEmpleado;
    }

    public void setEmpleadoIdEmpleado(Empleado empleadoIdEmpleado) {
        this.empleadoIdEmpleado = empleadoIdEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLiquidador != null ? idLiquidador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Liquidador)) {
            return false;
        }
        Liquidador other = (Liquidador) object;
        if ((this.idLiquidador == null && other.idLiquidador != null) || (this.idLiquidador != null && !this.idLiquidador.equals(other.idLiquidador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Liquidador[ idLiquidador=" + idLiquidador + " ]";
    }
    
}

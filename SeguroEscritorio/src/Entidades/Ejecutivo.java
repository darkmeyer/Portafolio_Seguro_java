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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DarKMeYeR
 */
@Entity
@Table(name = "EJECUTIVO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ejecutivo.findAll", query = "SELECT e FROM Ejecutivo e"),
    @NamedQuery(name = "Ejecutivo.findByIdEjecutivo", query = "SELECT e FROM Ejecutivo e WHERE e.idEjecutivo = :idEjecutivo")})
public class Ejecutivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_EJECUTIVO")
    private String idEjecutivo;
    @JoinColumn(name = "EMPLEADO_ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @OneToOne(optional = false)
    private Empleado empleadoIdEmpleado;

    public Ejecutivo() {
    }

    public Ejecutivo(String idEjecutivo) {
        this.idEjecutivo = idEjecutivo;
    }

    public String getIdEjecutivo() {
        return idEjecutivo;
    }

    public void setIdEjecutivo(String idEjecutivo) {
        this.idEjecutivo = idEjecutivo;
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
        hash += (idEjecutivo != null ? idEjecutivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ejecutivo)) {
            return false;
        }
        Ejecutivo other = (Ejecutivo) object;
        if ((this.idEjecutivo == null && other.idEjecutivo != null) || (this.idEjecutivo != null && !this.idEjecutivo.equals(other.idEjecutivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Ejecutivo[ idEjecutivo=" + idEjecutivo + " ]";
    }
    
}

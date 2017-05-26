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
@Table(name = "TALLER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taller.findAll", query = "SELECT t FROM Taller t"),
    @NamedQuery(name = "Taller.findByIdTaller", query = "SELECT t FROM Taller t WHERE t.idTaller = :idTaller"),
    @NamedQuery(name = "Taller.findByNombre", query = "SELECT t FROM Taller t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Taller.findByFono", query = "SELECT t FROM Taller t WHERE t.fono = :fono"),
    @NamedQuery(name = "Taller.findByDireccion", query = "SELECT t FROM Taller t WHERE t.direccion = :direccion")})
public class Taller implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tallerIdTaller")
    private Collection<Siniestro> siniestroCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TALLER")
    private String idTaller;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "FONO")
    private String fono;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @JoinColumn(name = "EMPLEADO_ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado empleadoIdEmpleado;
    @JoinColumn(name = "CIUDAD_ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad ciudadIdCiudad;

    public Taller() {
    }

    public Taller(String idTaller) {
        this.idTaller = idTaller;
    }

    public Taller(String idTaller, String nombre, String fono, String direccion) {
        this.idTaller = idTaller;
        this.nombre = nombre;
        this.fono = fono;
        this.direccion = direccion;
    }

    public String getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(String idTaller) throws Exception {
        if(idTaller.length() > 10)
            throw new Exception("Id no puede superar el largo 10");
        else
            this.idTaller = idTaller;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if(nombre.length() > 50)
            throw new Exception("Nombre no puede superar el largo 50");
        else
            this.nombre = nombre;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) throws Exception {
        if(fono.length() > 15)
            throw new Exception("Fono no puede superar el largo 15");
        else
            this.fono = fono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) throws Exception {
        if(direccion.length() > 50)
            throw new Exception("Direccion no puede superar el largo 50");
        else
            this.direccion = direccion;
    }

    public Empleado getEmpleadoIdEmpleado() {
        return empleadoIdEmpleado;
    }

    public void setEmpleadoIdEmpleado(Empleado empleadoIdEmpleado) {
        this.empleadoIdEmpleado = empleadoIdEmpleado;
    }

    public Ciudad getCiudadIdCiudad() {
        return ciudadIdCiudad;
    }

    public void setCiudadIdCiudad(Ciudad ciudadIdCiudad) {
        this.ciudadIdCiudad = ciudadIdCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTaller != null ? idTaller.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taller)) {
            return false;
        }
        Taller other = (Taller) object;
        if ((this.idTaller == null && other.idTaller != null) || (this.idTaller != null && !this.idTaller.equals(other.idTaller))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Taller[ idTaller=" + idTaller + " ]";
    }

    @XmlTransient
    public Collection<Siniestro> getSiniestroCollection() {
        return siniestroCollection;
    }

    public void setSiniestroCollection(Collection<Siniestro> siniestroCollection) {
        this.siniestroCollection = siniestroCollection;
    }
    
}

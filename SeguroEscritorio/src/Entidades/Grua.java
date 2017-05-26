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
@Table(name = "GRUA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grua.findAll", query = "SELECT g FROM Grua g"),
    @NamedQuery(name = "Grua.findByIdGrua", query = "SELECT g FROM Grua g WHERE g.idGrua = :idGrua"),
    @NamedQuery(name = "Grua.findByRut", query = "SELECT g FROM Grua g WHERE g.rut = :rut"),
    @NamedQuery(name = "Grua.findByNombre", query = "SELECT g FROM Grua g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "Grua.findByApellido", query = "SELECT g FROM Grua g WHERE g.apellido = :apellido"),
    @NamedQuery(name = "Grua.findByFono", query = "SELECT g FROM Grua g WHERE g.fono = :fono"),
    @NamedQuery(name = "Grua.findByDireccion", query = "SELECT g FROM Grua g WHERE g.direccion = :direccion")})
public class Grua implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gruaIdGrua")
    private Collection<Siniestro> siniestroCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_GRUA")
    private Short idGrua;
    @Basic(optional = false)
    @Column(name = "RUT")
    private String rut;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "FONO")
    private String fono;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @JoinColumn(name = "CIUDAD_ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad ciudadIdCiudad;

    public Grua() {
    }

    public Grua(Short idGrua) {
        this.idGrua = idGrua;
    }

    public Grua(Short idGrua, String rut, String nombre, String apellido, String fono, String direccion) {
        this.idGrua = idGrua;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fono = fono;
        this.direccion = direccion;
    }

    public Short getIdGrua() {
        return idGrua;
    }

    public void setIdGrua(Short idGrua) {
        this.idGrua = idGrua;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) throws Exception {
        rut = rut.replace(".","");
        rut = rut.replace("-","");
        if(Validaciones.validarRut(rut) && rut.length() >= 8){
                this.rut = rut;
        }else
            throw new Exception("Rut Invalido.");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if(nombre.length() > 50)
            throw new Exception("Nombre no puede superar largo 50");
        else
            this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws Exception {
        if(apellido.length() > 50)
            throw new Exception("Apallido no puede superar largo 50");
        else
            this.apellido = apellido;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) throws Exception {
        if(fono.length() > 15)
            throw new Exception("Fono no puede superar largo 15");
        else
            this.fono = fono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) throws Exception {
        if(direccion.length() > 50)
            throw new Exception("Direccion no puede superar largo 100");
        else
            this.direccion = direccion;
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
        hash += (idGrua != null ? idGrua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grua)) {
            return false;
        }
        Grua other = (Grua) object;
        if ((this.idGrua == null && other.idGrua != null) || (this.idGrua != null && !this.idGrua.equals(other.idGrua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Grua[ idGrua=" + idGrua + " ]";
    }

    @XmlTransient
    public Collection<Siniestro> getSiniestroCollection() {
        return siniestroCollection;
    }

    public void setSiniestroCollection(Collection<Siniestro> siniestroCollection) {
        this.siniestroCollection = siniestroCollection;
    }
    
}

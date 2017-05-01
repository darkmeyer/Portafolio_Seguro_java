/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Liquidador.findByIdLiquidador", query = "SELECT l FROM Liquidador l WHERE l.idLiquidador = :idLiquidador"),
    @NamedQuery(name = "Liquidador.findByRut", query = "SELECT l FROM Liquidador l WHERE l.rut = :rut"),
    @NamedQuery(name = "Liquidador.findByPass", query = "SELECT l FROM Liquidador l WHERE l.pass = :pass"),
    @NamedQuery(name = "Liquidador.findByNombres", query = "SELECT l FROM Liquidador l WHERE l.nombres = :nombres"),
    @NamedQuery(name = "Liquidador.findByApellidos", query = "SELECT l FROM Liquidador l WHERE l.apellidos = :apellidos"),
    @NamedQuery(name = "Liquidador.findByCorreo", query = "SELECT l FROM Liquidador l WHERE l.correo = :correo"),
    @NamedQuery(name = "Liquidador.findByFono", query = "SELECT l FROM Liquidador l WHERE l.fono = :fono"),
    @NamedQuery(name = "Liquidador.findByFechaNacimiento", query = "SELECT l FROM Liquidador l WHERE l.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Liquidador.findByDireccion", query = "SELECT l FROM Liquidador l WHERE l.direccion = :direccion")})
public class Liquidador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_LIQUIDADOR")
    private String idLiquidador;
    @Basic(optional = false)
    @Column(name = "RUT")
    private String rut;
    @Basic(optional = false)
    @Column(name = "PASS")
    private String pass;
    @Basic(optional = false)
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "CORREO")
    private String correo;
    @Basic(optional = false)
    @Column(name = "FONO")
    private String fono;
    @Basic(optional = false)
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "liquidadorIdLiquidador")
    private Collection<Siniestro> siniestroCollection;
    @JoinColumn(name = "CIUDAD_ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad ciudadIdCiudad;

    public Liquidador() {
    }

    public Liquidador(String idLiquidador) {
        this.idLiquidador = idLiquidador;
    }

    public Liquidador(String idLiquidador, String rut, String pass, String nombres, String apellidos, String correo, String fono, Date fechaNacimiento, String direccion) {
        this.idLiquidador = idLiquidador;
        this.rut = rut;
        this.pass = pass;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fono = fono;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public String getIdLiquidador() {
        return idLiquidador;
    }

    public void setIdLiquidador(String idLiquidador) {
        this.idLiquidador = idLiquidador;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public Collection<Siniestro> getSiniestroCollection() {
        return siniestroCollection;
    }

    public void setSiniestroCollection(Collection<Siniestro> siniestroCollection) {
        this.siniestroCollection = siniestroCollection;
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

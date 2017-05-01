/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Ejecutivo.findByIdEjecutivo", query = "SELECT e FROM Ejecutivo e WHERE e.idEjecutivo = :idEjecutivo"),
    @NamedQuery(name = "Ejecutivo.findByRut", query = "SELECT e FROM Ejecutivo e WHERE e.rut = :rut"),
    @NamedQuery(name = "Ejecutivo.findByPass", query = "SELECT e FROM Ejecutivo e WHERE e.pass = :pass"),
    @NamedQuery(name = "Ejecutivo.findByNombres", query = "SELECT e FROM Ejecutivo e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Ejecutivo.findByApellidos", query = "SELECT e FROM Ejecutivo e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Ejecutivo.findByCorreo", query = "SELECT e FROM Ejecutivo e WHERE e.correo = :correo"),
    @NamedQuery(name = "Ejecutivo.findByFechaNacimiento", query = "SELECT e FROM Ejecutivo e WHERE e.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Ejecutivo.findByDireccion", query = "SELECT e FROM Ejecutivo e WHERE e.direccion = :direccion")})
public class Ejecutivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_EJECUTIVO")
    private String idEjecutivo;
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
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @JoinColumn(name = "CIUDAD_ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad ciudadIdCiudad;

    public Ejecutivo() {
    }

    public Ejecutivo(String idEjecutivo) {
        this.idEjecutivo = idEjecutivo;
    }

    public Ejecutivo(String idEjecutivo, String rut, String pass, String nombres, String apellidos, String correo, Date fechaNacimiento, String direccion) {
        this.idEjecutivo = idEjecutivo;
        this.rut = rut;
        this.pass = pass;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public String getIdEjecutivo() {
        return idEjecutivo;
    }

    public void setIdEjecutivo(String idEjecutivo) {
        this.idEjecutivo = idEjecutivo;
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

    public Ciudad getCiudadIdCiudad() {
        return ciudadIdCiudad;
    }

    public void setCiudadIdCiudad(Ciudad ciudadIdCiudad) {
        this.ciudadIdCiudad = ciudadIdCiudad;
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

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author DarKMeYeR
 */
@Entity
@Table(name = "EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleado.findByRut", query = "SELECT e FROM Empleado e WHERE e.rut = :rut"),
    @NamedQuery(name = "Empleado.findByPass", query = "SELECT e FROM Empleado e WHERE e.pass = :pass"),
    @NamedQuery(name = "Empleado.findByNombres", query = "SELECT e FROM Empleado e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Empleado.findByApellidos", query = "SELECT e FROM Empleado e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Empleado.findByCorreo", query = "SELECT e FROM Empleado e WHERE e.correo = :correo"),
    @NamedQuery(name = "Empleado.findByFono", query = "SELECT e FROM Empleado e WHERE e.fono = :fono"),
    @NamedQuery(name = "Empleado.findByFechaNacimiento", query = "SELECT e FROM Empleado e WHERE e.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Empleado.findByDireccion", query = "SELECT e FROM Empleado e WHERE e.direccion = :direccion")})
public class Empleado implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoIdEmpleado")
    private Collection<Presupuesto> presupuestoCollection;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empleadoIdEmpleado")
    private Taller taller;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_EMPLEADO")
    private String idEmpleado;
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
    private String fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @JoinColumn(name = "CIUDAD_ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad ciudadIdCiudad;
    @JoinColumn(name = "CARGO_ID_CARGO", referencedColumnName = "ID_CARGO")
    @ManyToOne(optional = false)
    private Cargo cargoIdCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoIdEmpleado")
    private Collection<Taller> tallerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoIdEmpleado")
    private Collection<Siniestro> siniestroCollection;

    public Empleado() {
    }

    public Empleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(String idEmpleado, String rut, String pass, String nombres, String apellidos, String correo, String fono, String fechaNacimiento, String direccion) {
        this.idEmpleado = idEmpleado;
        this.rut = rut;
        this.pass = pass;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fono = fono;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) throws Exception {        
        if(idEmpleado.length() > 10)            
            throw new Exception("Error ID mayor a largo 10.");
        else
            this.idEmpleado = idEmpleado;        
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) throws Exception {
        if(pass.length() > 10)
            throw new Exception("Password no puede superar los 10 Caracteres.");
        else
            this.pass = BCrypt.hashpw(pass, BCrypt.gensalt());
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) throws Exception {
        if(nombres.length() > 50)
            throw new Exception("Nombres maximo 50 caracteres");
        else
            this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) throws Exception {
        if(apellidos.length() > 50)
            throw new Exception("Apellidos maximo 50 caracteres");
        else
            this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) throws Exception {
        if(correo.length() > 50)
            throw new Exception("Correo maximo 50 caracteres");
        else
            this.correo = correo;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) throws Exception {
        if(fono.length() > 15)
            throw new Exception("Fono maximo 15 Numeros");
        else
            this.fono = fono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) throws Exception {
        if(fechaNacimiento.length() > 10)
            throw new Exception("fecha excede maximo de largo");
        else
            this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) throws Exception {
        if(direccion.length() > 100)
            throw new Exception("Nombres maximo 50 caracteres");
        else
            this.direccion = direccion;
    }

    public Ciudad getCiudadIdCiudad() {
        return ciudadIdCiudad;
    }

    public void setCiudadIdCiudad(Ciudad ciudadIdCiudad) {
        this.ciudadIdCiudad = ciudadIdCiudad;
    }

    public Cargo getCargoIdCargo() {
        return cargoIdCargo;
    }

    public void setCargoIdCargo(Cargo cargoIdCargo) {
        this.cargoIdCargo = cargoIdCargo;
    }

    @XmlTransient
    public Collection<Taller> getTallerCollection() {
        return tallerCollection;
    }

    public void setTallerCollection(Collection<Taller> tallerCollection) {
        this.tallerCollection = tallerCollection;
    }

    @XmlTransient
    public Collection<Siniestro> getSiniestroCollection() {
        return siniestroCollection;
    }

    public void setSiniestroCollection(Collection<Siniestro> siniestroCollection) {
        this.siniestroCollection = siniestroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Empleado[ idEmpleado=" + idEmpleado + " ]";
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }

    @XmlTransient
    public Collection<Presupuesto> getPresupuestoCollection() {
        return presupuestoCollection;
    }

    public void setPresupuestoCollection(Collection<Presupuesto> presupuestoCollection) {
        this.presupuestoCollection = presupuestoCollection;
    }
    
}

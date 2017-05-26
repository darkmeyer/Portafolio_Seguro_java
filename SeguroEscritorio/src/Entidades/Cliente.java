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
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author DarKMeYeR
 */
@Entity
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByRut", query = "SELECT c FROM Cliente c WHERE c.rut = :rut"),
    @NamedQuery(name = "Cliente.findByPass", query = "SELECT c FROM Cliente c WHERE c.pass = :pass"),
    @NamedQuery(name = "Cliente.findByNombres", query = "SELECT c FROM Cliente c WHERE c.nombres = :nombres"),
    @NamedQuery(name = "Cliente.findByApellidos", query = "SELECT c FROM Cliente c WHERE c.apellidos = :apellidos"),
    @NamedQuery(name = "Cliente.findByCorreo", query = "SELECT c FROM Cliente c WHERE c.correo = :correo"),
    @NamedQuery(name = "Cliente.findByFono", query = "SELECT c FROM Cliente c WHERE c.fono = :fono"),
    @NamedQuery(name = "Cliente.findByFechaNacimiento", query = "SELECT c FROM Cliente c WHERE c.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Cliente.findByActivo", query = "SELECT c FROM Cliente c WHERE c.activo = :activo"),
    @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion")})
public class Cliente implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteIdCliente")
    private Collection<Siniestro> siniestroCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private String idCliente;
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
    @Column(name = "ACTIVO")
    private String activo;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @JoinColumn(name = "VEHICULO_ID_VEHICULO", referencedColumnName = "ID_VEHICULO")
    @ManyToOne(optional = false)
    private Vehiculo vehiculoIdVehiculo;
    @JoinColumn(name = "SEGURO_ID_SEGURO", referencedColumnName = "ID_SEGURO")
    @ManyToOne(optional = false)
    private Seguro seguroIdSeguro;
    @JoinColumn(name = "CIUDAD_ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad ciudadIdCiudad;

    public Cliente() {
    }

    public Cliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(String idCliente, String rut, String pass, String nombres, String apellidos, String correo, String fono, String fechaNacimiento, String activo, String direccion) {
        this.idCliente = idCliente;
        this.rut = rut;
        this.pass = pass;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fono = fono;
        this.fechaNacimiento = fechaNacimiento;
        this.activo = activo;
        this.direccion = direccion;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
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
    
    public String getActivo() {
        return activo;
    }
    
    public void setActivo(String activo) {
        this.activo = activo;
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

    public Vehiculo getVehiculoIdVehiculo() {
        return vehiculoIdVehiculo;
    }

    public void setVehiculoIdVehiculo(Vehiculo vehiculoIdVehiculo) {
        this.vehiculoIdVehiculo = vehiculoIdVehiculo;
    }

    public Seguro getSeguroIdSeguro() {
        return seguroIdSeguro;
    }

    public void setSeguroIdSeguro(Seguro seguroIdSeguro) {
        this.seguroIdSeguro = seguroIdSeguro;
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
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cliente[ idCliente=" + idCliente + " ]";
    }

    @XmlTransient
    public Collection<Siniestro> getSiniestroCollection() {
        return siniestroCollection;
    }

    public void setSiniestroCollection(Collection<Siniestro> siniestroCollection) {
        this.siniestroCollection = siniestroCollection;
    }
    
}

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
@Table(name = "SINIESTRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Siniestro.findAll", query = "SELECT s FROM Siniestro s"),
    @NamedQuery(name = "Siniestro.findByIdSiniestro", query = "SELECT s FROM Siniestro s WHERE s.idSiniestro = :idSiniestro"),
    @NamedQuery(name = "Siniestro.findByFecha", query = "SELECT s FROM Siniestro s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "Siniestro.findByFechaTermino", query = "SELECT s FROM Siniestro s WHERE s.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "Siniestro.findByDireccion", query = "SELECT s FROM Siniestro s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Siniestro.findByEstado", query = "SELECT s FROM Siniestro s WHERE s.estado = :estado"),
    @NamedQuery(name = "Siniestro.findByCosteReparacion", query = "SELECT s FROM Siniestro s WHERE s.costeReparacion = :costeReparacion"),
    @NamedQuery(name = "Siniestro.findByPatente", query = "SELECT s FROM Siniestro s WHERE s.patente = :patente")})
public class Siniestro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_SINIESTRO")
    private String idSiniestro;
    @Basic(optional = false)
    @Column(name = "FECHA")
    private String fecha;
    @Column(name = "FECHA_TERMINO")
    private String fechaTermino;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "COSTE_REPARACION")
    private Long costeReparacion;
    @Basic(optional = false)
    @Column(name = "PATENTE")
    private String patente;
    @JoinColumn(name = "TALLER_ID_TALLER", referencedColumnName = "ID_TALLER")
    @ManyToOne(optional = false)
    private Taller tallerIdTaller;
    @JoinColumn(name = "GRUA_ID_GRUA", referencedColumnName = "ID_GRUA")
    @ManyToOne(optional = false)
    private Grua gruaIdGrua;
    @JoinColumn(name = "EMPLEADO_ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado empleadoIdEmpleado;
    @JoinColumn(name = "CLIENTE_ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente clienteIdCliente;
    @JoinColumn(name = "CIUDAD_ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad ciudadIdCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siniestroIdSiniestro")
    private Collection<Movimiento> movimientoCollection;

    public Siniestro() {
    }

    public Siniestro(String idSiniestro) {
        this.idSiniestro = idSiniestro;
    }

    public Siniestro(String idSiniestro, String fecha, String direccion, String estado, String patente) {
        this.idSiniestro = idSiniestro;
        this.fecha = fecha;
        this.direccion = direccion;
        this.estado = estado;
        this.patente = patente;
    }

    public String getIdSiniestro() {
        return idSiniestro;
    }

    public void setIdSiniestro(String idSiniestro) {
        this.idSiniestro = idSiniestro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(String fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getCosteReparacion() {
        return costeReparacion;
    }

    public void setCosteReparacion(Long costeReparacion) {
        this.costeReparacion = costeReparacion;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Taller getTallerIdTaller() {
        return tallerIdTaller;
    }

    public void setTallerIdTaller(Taller tallerIdTaller) {
        this.tallerIdTaller = tallerIdTaller;
    }

    public Grua getGruaIdGrua() {
        return gruaIdGrua;
    }

    public void setGruaIdGrua(Grua gruaIdGrua) {
        this.gruaIdGrua = gruaIdGrua;
    }

    public Empleado getEmpleadoIdEmpleado() {
        return empleadoIdEmpleado;
    }

    public void setEmpleadoIdEmpleado(Empleado empleadoIdEmpleado) {
        this.empleadoIdEmpleado = empleadoIdEmpleado;
    }

    public Cliente getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(Cliente clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    public Ciudad getCiudadIdCiudad() {
        return ciudadIdCiudad;
    }

    public void setCiudadIdCiudad(Ciudad ciudadIdCiudad) {
        this.ciudadIdCiudad = ciudadIdCiudad;
    }

    @XmlTransient
    public Collection<Movimiento> getMovimientoCollection() {
        return movimientoCollection;
    }

    public void setMovimientoCollection(Collection<Movimiento> movimientoCollection) {
        this.movimientoCollection = movimientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSiniestro != null ? idSiniestro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Siniestro)) {
            return false;
        }
        Siniestro other = (Siniestro) object;
        if ((this.idSiniestro == null && other.idSiniestro != null) || (this.idSiniestro != null && !this.idSiniestro.equals(other.idSiniestro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Siniestro[ idSiniestro=" + idSiniestro + " ]";
    }
    
}

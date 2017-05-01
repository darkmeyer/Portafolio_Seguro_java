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
@Table(name = "SINIESTRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Siniestro.findAll", query = "SELECT s FROM Siniestro s"),
    @NamedQuery(name = "Siniestro.findByIdSiniestro", query = "SELECT s FROM Siniestro s WHERE s.idSiniestro = :idSiniestro"),
    @NamedQuery(name = "Siniestro.findByFecha", query = "SELECT s FROM Siniestro s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "Siniestro.findByFechaTermino", query = "SELECT s FROM Siniestro s WHERE s.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "Siniestro.findByEstado", query = "SELECT s FROM Siniestro s WHERE s.estado = :estado"),
    @NamedQuery(name = "Siniestro.findByDeducibleUf", query = "SELECT s FROM Siniestro s WHERE s.deducibleUf = :deducibleUf"),
    @NamedQuery(name = "Siniestro.findByCosteReparacion", query = "SELECT s FROM Siniestro s WHERE s.costeReparacion = :costeReparacion"),
    @NamedQuery(name = "Siniestro.findByEjecutivoIdEjecutivo", query = "SELECT s FROM Siniestro s WHERE s.ejecutivoIdEjecutivo = :ejecutivoIdEjecutivo")})
public class Siniestro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_SINIESTRO")
    private String idSiniestro;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "FECHA_TERMINO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTermino;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @Column(name = "DEDUCIBLE_UF")
    private short deducibleUf;
    @Column(name = "COSTE_REPARACION")
    private Long costeReparacion;
    @Basic(optional = false)
    @Column(name = "EJECUTIVO_ID_EJECUTIVO")
    private String ejecutivoIdEjecutivo;
    @JoinColumn(name = "LIQUIDADOR_ID_LIQUIDADOR", referencedColumnName = "ID_LIQUIDADOR")
    @ManyToOne(optional = false)
    private Liquidador liquidadorIdLiquidador;
    @JoinColumn(name = "CLIENTE_ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente clienteIdCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siniestroIdSiniestro")
    private Collection<Movimiento> movimientoCollection;

    public Siniestro() {
    }

    public Siniestro(String idSiniestro) {
        this.idSiniestro = idSiniestro;
    }

    public Siniestro(String idSiniestro, Date fecha, String estado, short deducibleUf, String ejecutivoIdEjecutivo) {
        this.idSiniestro = idSiniestro;
        this.fecha = fecha;
        this.estado = estado;
        this.deducibleUf = deducibleUf;
        this.ejecutivoIdEjecutivo = ejecutivoIdEjecutivo;
    }

    public String getIdSiniestro() {
        return idSiniestro;
    }

    public void setIdSiniestro(String idSiniestro) {
        this.idSiniestro = idSiniestro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public short getDeducibleUf() {
        return deducibleUf;
    }

    public void setDeducibleUf(short deducibleUf) {
        this.deducibleUf = deducibleUf;
    }

    public Long getCosteReparacion() {
        return costeReparacion;
    }

    public void setCosteReparacion(Long costeReparacion) {
        this.costeReparacion = costeReparacion;
    }

    public String getEjecutivoIdEjecutivo() {
        return ejecutivoIdEjecutivo;
    }

    public void setEjecutivoIdEjecutivo(String ejecutivoIdEjecutivo) {
        this.ejecutivoIdEjecutivo = ejecutivoIdEjecutivo;
    }

    public Liquidador getLiquidadorIdLiquidador() {
        return liquidadorIdLiquidador;
    }

    public void setLiquidadorIdLiquidador(Liquidador liquidadorIdLiquidador) {
        this.liquidadorIdLiquidador = liquidadorIdLiquidador;
    }

    public Cliente getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(Cliente clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
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

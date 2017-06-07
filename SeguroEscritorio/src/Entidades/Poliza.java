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
@Table(name = "POLIZA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poliza.findAll", query = "SELECT p FROM Poliza p"),
    @NamedQuery(name = "Poliza.findByIdPoliza", query = "SELECT p FROM Poliza p WHERE p.idPoliza = :idPoliza"),
    @NamedQuery(name = "Poliza.findByAlDia", query = "SELECT p FROM Poliza p WHERE p.alDia = :alDia"),
    @NamedQuery(name = "Poliza.findByFechaVencimiento", query = "SELECT p FROM Poliza p WHERE p.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "Poliza.findByTotalPagar", query = "SELECT p FROM Poliza p WHERE p.totalPagar = :totalPagar"),
    @NamedQuery(name = "Poliza.findByIdCliente", query = "SELECT p FROM Poliza p WHERE p.idCliente = :idCliente")})
public class Poliza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_POLIZA")
    private Long idPoliza;
    @Column(name = "AL_DIA")
    private String alDia;
    @Basic(optional = false)
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @Column(name = "TOTAL_PAGAR")
    private long totalPagar;
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private String idCliente;

    public Poliza() {
    }

    public Poliza(Long idPoliza) {
        this.idPoliza = idPoliza;
    }

    public Poliza(Long idPoliza, Date fechaVencimiento, long totalPagar, String idCliente) {
        this.idPoliza = idPoliza;
        this.fechaVencimiento = fechaVencimiento;
        this.totalPagar = totalPagar;
        this.idCliente = idCliente;
    }

    public Long getIdPoliza() {
        return idPoliza;
    }

    public void setIdPoliza(Long idPoliza) {
        this.idPoliza = idPoliza;
    }

    public String getAlDia() {
        return alDia;
    }

    public void setAlDia(String alDia) {
        this.alDia = alDia;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public long getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(long totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPoliza != null ? idPoliza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poliza)) {
            return false;
        }
        Poliza other = (Poliza) object;
        if ((this.idPoliza == null && other.idPoliza != null) || (this.idPoliza != null && !this.idPoliza.equals(other.idPoliza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Poliza[ idPoliza=" + idPoliza + " ]";
    }
    
}

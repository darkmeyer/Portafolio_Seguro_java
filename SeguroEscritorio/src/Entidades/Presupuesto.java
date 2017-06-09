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
@Table(name = "PRESUPUESTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presupuesto.findAll", query = "SELECT p FROM Presupuesto p"),
    @NamedQuery(name = "Presupuesto.findByIdPresupuesto", query = "SELECT p FROM Presupuesto p WHERE p.idPresupuesto = :idPresupuesto"),
    @NamedQuery(name = "Presupuesto.findByFecha", query = "SELECT p FROM Presupuesto p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Presupuesto.findByComentario", query = "SELECT p FROM Presupuesto p WHERE p.comentario = :comentario")})
public class Presupuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRESUPUESTO")
    private String idPresupuesto;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "COMENTARIO")
    private String comentario;
    @JoinColumn(name = "VEHICULO_ID_VEHICULO", referencedColumnName = "ID_VEHICULO")
    @ManyToOne(optional = false)
    private Vehiculo vehiculoIdVehiculo;

    public Presupuesto() {
    }

    public Presupuesto(String idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Presupuesto(String idPresupuesto, Date fecha) {
        this.idPresupuesto = idPresupuesto;
        this.fecha = fecha;
    }

    public String getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(String idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Vehiculo getVehiculoIdVehiculo() {
        return vehiculoIdVehiculo;
    }

    public void setVehiculoIdVehiculo(Vehiculo vehiculoIdVehiculo) {
        this.vehiculoIdVehiculo = vehiculoIdVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPresupuesto != null ? idPresupuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presupuesto)) {
            return false;
        }
        Presupuesto other = (Presupuesto) object;
        if ((this.idPresupuesto == null && other.idPresupuesto != null) || (this.idPresupuesto != null && !this.idPresupuesto.equals(other.idPresupuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Presupuesto[ idPresupuesto=" + idPresupuesto + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DarKMeYeR
 */
@Entity
@Table(name = "PIEZA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pieza.findAll", query = "SELECT p FROM Pieza p"),
    @NamedQuery(name = "Pieza.findByIdPieza", query = "SELECT p FROM Pieza p WHERE p.idPieza = :idPieza"),
    @NamedQuery(name = "Pieza.findByNombre", query = "SELECT p FROM Pieza p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Pieza.findByValor", query = "SELECT p FROM Pieza p WHERE p.valor = :valor")})
public class Pieza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PIEZA")
    private Long idPieza;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "VALOR")
    private long valor;
    @JoinColumn(name = "PRESUPUESTO_ID_PRESUPUESTO", referencedColumnName = "ID_PRESUPUESTO")
    @ManyToOne
    private Presupuesto presupuestoIdPresupuesto;

    public Pieza() {
    }

    public Pieza(Long idPieza) {
        this.idPieza = idPieza;
    }

    public Pieza(Long idPieza, String nombre, long valor) {
        this.idPieza = idPieza;
        this.nombre = nombre;
        this.valor = valor;
    }

    public Long getIdPieza() {
        return idPieza;
    }

    public void setIdPieza(Long idPieza) {
        this.idPieza = idPieza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Presupuesto getPresupuestoIdPresupuesto() {
        return presupuestoIdPresupuesto;
    }

    public void setPresupuestoIdPresupuesto(Presupuesto presupuestoIdPresupuesto) {
        this.presupuestoIdPresupuesto = presupuestoIdPresupuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPieza != null ? idPieza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pieza)) {
            return false;
        }
        Pieza other = (Pieza) object;
        if ((this.idPieza == null && other.idPieza != null) || (this.idPieza != null && !this.idPieza.equals(other.idPieza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Pieza[ idPieza=" + idPieza + " ]";
    }
    
}

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
@Table(name = "VEHICULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findByIdVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.idVehiculo = :idVehiculo"),
    @NamedQuery(name = "Vehiculo.findByRut", query = "SELECT v FROM Vehiculo v WHERE v.rut = :rut"),
    @NamedQuery(name = "Vehiculo.findByPatente", query = "SELECT v FROM Vehiculo v WHERE v.patente = :patente"),
    @NamedQuery(name = "Vehiculo.findByAno", query = "SELECT v FROM Vehiculo v WHERE v.ano = :ano"),
    @NamedQuery(name = "Vehiculo.findByValorFiscal", query = "SELECT v FROM Vehiculo v WHERE v.valorFiscal = :valorFiscal")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_VEHICULO")
    private String idVehiculo;
    @Basic(optional = false)
    @Column(name = "RUT")
    private String rut;
    @Basic(optional = false)
    @Column(name = "PATENTE")
    private String patente;
    @Basic(optional = false)
    @Column(name = "ANO")
    private short ano;
    @Basic(optional = false)
    @Column(name = "VALOR_FISCAL")
    private int valorFiscal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoIdVehiculo")
    private Collection<Presupuesto> presupuestoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoIdVehiculo")
    private Collection<Cobertura> coberturaCollection;
    @JoinColumn(name = "MODELO_ID_MODELO", referencedColumnName = "ID_MODELO")
    @ManyToOne(optional = false)
    private Modelo modeloIdModelo;
    @JoinColumn(name = "CLIENTE_ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente clienteIdCliente;

    public Vehiculo() {
    }

    public Vehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculo(String idVehiculo, String rut, String patente, short ano, int valorFiscal) {
        this.idVehiculo = idVehiculo;
        this.rut = rut;
        this.patente = patente;
        this.ano = ano;
        this.valorFiscal = valorFiscal;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public short getAno() {
        return ano;
    }

    public void setAno(short ano) {
        this.ano = ano;
    }

    public int getValorFiscal() {
        return valorFiscal;
    }

    public void setValorFiscal(int valorFiscal) {
        this.valorFiscal = valorFiscal;
    }

    @XmlTransient
    public Collection<Presupuesto> getPresupuestoCollection() {
        return presupuestoCollection;
    }

    public void setPresupuestoCollection(Collection<Presupuesto> presupuestoCollection) {
        this.presupuestoCollection = presupuestoCollection;
    }

    @XmlTransient
    public Collection<Cobertura> getCoberturaCollection() {
        return coberturaCollection;
    }

    public void setCoberturaCollection(Collection<Cobertura> coberturaCollection) {
        this.coberturaCollection = coberturaCollection;
    }

    public Modelo getModeloIdModelo() {
        return modeloIdModelo;
    }

    public void setModeloIdModelo(Modelo modeloIdModelo) {
        this.modeloIdModelo = modeloIdModelo;
    }

    public Cliente getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(Cliente clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Vehiculo[ idVehiculo=" + idVehiculo + " ]";
    }
    
}

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DarKMeYeR
 */
@Entity
@Table(name = "SEGURO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguro.findAll", query = "SELECT s FROM Seguro s"),
    @NamedQuery(name = "Seguro.findByIdSeguro", query = "SELECT s FROM Seguro s WHERE s.idSeguro = :idSeguro"),
    @NamedQuery(name = "Seguro.findByValor", query = "SELECT s FROM Seguro s WHERE s.valor = :valor"),
    @NamedQuery(name = "Seguro.findByActivo", query = "SELECT s FROM Seguro s WHERE s.activo = :activo")})
public class Seguro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_SEGURO")
    private String idSeguro;
    @Basic(optional = false)
    @Column(name = "VALOR")
    private int valor;
    @Basic(optional = false)
    @Column(name = "ACTIVO")
    private Character activo;
    @JoinColumn(name = "COBERTURA_ID_COBERTURA", referencedColumnName = "ID_COBERTURA")
    @OneToOne(optional = false)
    private Cobertura coberturaIdCobertura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seguroIdSeguro")
    private Collection<Cliente> clienteCollection;

    public Seguro() {
    }

    public Seguro(String idSeguro) {
        this.idSeguro = idSeguro;
    }

    public Seguro(String idSeguro, int valor, Character activo) {
        this.idSeguro = idSeguro;
        this.valor = valor;
        this.activo = activo;
    }

    public String getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(String idSeguro) {
        this.idSeguro = idSeguro;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }

    public Cobertura getCoberturaIdCobertura() {
        return coberturaIdCobertura;
    }

    public void setCoberturaIdCobertura(Cobertura coberturaIdCobertura) {
        this.coberturaIdCobertura = coberturaIdCobertura;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeguro != null ? idSeguro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguro)) {
            return false;
        }
        Seguro other = (Seguro) object;
        if ((this.idSeguro == null && other.idSeguro != null) || (this.idSeguro != null && !this.idSeguro.equals(other.idSeguro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Seguro[ idSeguro=" + idSeguro + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kenlu
 */
@Entity
@Table(name = "TRABAJOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajos.findAll", query = "SELECT t FROM Trabajos t")
    , @NamedQuery(name = "Trabajos.findById", query = "SELECT t FROM Trabajos t WHERE t.id = :id")
    , @NamedQuery(name = "Trabajos.findByEmpresa", query = "SELECT t FROM Trabajos t WHERE t.empresa = :empresa")
    , @NamedQuery(name = "Trabajos.findByCargo", query = "SELECT t FROM Trabajos t WHERE t.cargo = :cargo")
    , @NamedQuery(name = "Trabajos.findByHorasLaborales", query = "SELECT t FROM Trabajos t WHERE t.horasLaborales = :horasLaborales")
    , @NamedQuery(name = "Trabajos.findByEstado", query = "SELECT t FROM Trabajos t WHERE t.estado = :estado")})
public class Trabajos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 40)
    @Column(name = "EMPRESA")
    private String empresa;
    @Size(max = 40)
    @Column(name = "CARGO")
    private String cargo;
    @Column(name = "HORAS_LABORALES")
    private BigInteger horasLaborales;
    @Size(max = 40)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "idTrabajo")
    private List<HorariosOcup> horariosOcupList;

    public Trabajos() {
    }

    public Trabajos(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigInteger getHorasLaborales() {
        return horasLaborales;
    }

    public void setHorasLaborales(BigInteger horasLaborales) {
        this.horasLaborales = horasLaborales;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<HorariosOcup> getHorariosOcupList() {
        return horariosOcupList;
    }

    public void setHorariosOcupList(List<HorariosOcup> horariosOcupList) {
        this.horariosOcupList = horariosOcupList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajos)) {
            return false;
        }
        Trabajos other = (Trabajos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Trabajos[ id=" + id + " ]";
    }
    
}
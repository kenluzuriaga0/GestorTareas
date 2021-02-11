/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "VARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Varios.findAll", query = "SELECT v FROM Varios v")
    , @NamedQuery(name = "Varios.findById", query = "SELECT v FROM Varios v WHERE v.id = :id")
    , @NamedQuery(name = "Varios.findByNombre", query = "SELECT v FROM Varios v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "Varios.findByDetalle", query = "SELECT v FROM Varios v WHERE v.detalle = :detalle")})
public class Varios implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "DETALLE")
    private String detalle;
    @OneToMany(mappedBy = "idVarias")
    private List<HorariosInver> horariosInverList;

    public Varios() {
    }

    public Varios(BigDecimal id) {
        this.id = id;
    }

    public Varios(BigDecimal id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @XmlTransient
    public List<HorariosInver> getHorariosInverList() {
        return horariosInverList;
    }

    public void setHorariosInverList(List<HorariosInver> horariosInverList) {
        this.horariosInverList = horariosInverList;
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
        if (!(object instanceof Varios)) {
            return false;
        }
        Varios other = (Varios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Varios[ id=" + id + " ]";
    }
    
}

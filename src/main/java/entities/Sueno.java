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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kenlu
 */
@Entity
@Table(name = "SUENO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sueno.findAll", query = "SELECT s FROM Sueno s")
    , @NamedQuery(name = "Sueno.findById", query = "SELECT s FROM Sueno s WHERE s.id = :id")
    , @NamedQuery(name = "Sueno.findByHorasSueno", query = "SELECT s FROM Sueno s WHERE s.horasSueno = :horasSueno")})
public class Sueno implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "HORAS_SUENO")
    private BigInteger horasSueno;
    @OneToMany(mappedBy = "idSueno")
    private List<HorariosOcup> horariosOcupList;

    public Sueno() {
    }

    public Sueno(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getHorasSueno() {
        return horasSueno;
    }

    public void setHorasSueno(BigInteger horasSueno) {
        this.horasSueno = horasSueno;
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
        if (!(object instanceof Sueno)) {
            return false;
        }
        Sueno other = (Sueno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sueno[ id=" + id + " ]";
    }
    
}

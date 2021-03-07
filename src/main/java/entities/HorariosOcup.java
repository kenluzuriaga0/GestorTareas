/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kenlu
 */
@Entity
@Table(name = "HORARIOS_OCUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorariosOcup.findAll", query = "SELECT h FROM HorariosOcup h")
    , @NamedQuery(name = "HorariosOcup.findById", query = "SELECT h FROM HorariosOcup h WHERE h.id = :id")
    , @NamedQuery(name = "HorariosOcup.findByHorasOcupadas", query = "SELECT h FROM HorariosOcup h WHERE h.horasOcupadas = :horasOcupadas")
    , @NamedQuery(name = "HorariosOcup.findByEstado", query = "SELECT h FROM HorariosOcup h WHERE h.estado = :estado")})
public class HorariosOcup implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal id;
    @Column(name = "HORAS_OCUPADAS")
    private BigInteger horasOcupadas;
    @Size(max = 40)
    @Column(name = "ESTADO", length = 40)
    private String estado;
    @JoinColumn(name = "ID_TRABAJO", referencedColumnName = "ID")
    @ManyToOne
    private Trabajos idTrabajo;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    @ManyToOne
    private Usuarios idUsuario;

    public HorariosOcup() {
    }

    public HorariosOcup(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getHorasOcupadas() {
        return horasOcupadas;
    }

    public void setHorasOcupadas(BigInteger horasOcupadas) {
        this.horasOcupadas = horasOcupadas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Trabajos getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(Trabajos idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof HorariosOcup)) {
            return false;
        }
        HorariosOcup other = (HorariosOcup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HorariosOcup[ id=" + id + " ]";
    }
    
}

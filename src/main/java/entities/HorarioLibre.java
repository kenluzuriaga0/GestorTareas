/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "HORARIO_LIBRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorarioLibre.findAll", query = "SELECT h FROM HorarioLibre h")
    , @NamedQuery(name = "HorarioLibre.findById", query = "SELECT h FROM HorarioLibre h WHERE h.id = :id")
    , @NamedQuery(name = "HorarioLibre.findByHorarioOcup", query = "SELECT h FROM HorarioLibre h WHERE h.horarioOcup = :horarioOcup")
    , @NamedQuery(name = "HorarioLibre.findByLunes", query = "SELECT h FROM HorarioLibre h WHERE h.lunes = :lunes")
    , @NamedQuery(name = "HorarioLibre.findByMartes", query = "SELECT h FROM HorarioLibre h WHERE h.martes = :martes")
    , @NamedQuery(name = "HorarioLibre.findByMiercoles", query = "SELECT h FROM HorarioLibre h WHERE h.miercoles = :miercoles")
    , @NamedQuery(name = "HorarioLibre.findByJueves", query = "SELECT h FROM HorarioLibre h WHERE h.jueves = :jueves")
    , @NamedQuery(name = "HorarioLibre.findByViernes", query = "SELECT h FROM HorarioLibre h WHERE h.viernes = :viernes")
    , @NamedQuery(name = "HorarioLibre.findBySabado", query = "SELECT h FROM HorarioLibre h WHERE h.sabado = :sabado")})
public class HorarioLibre implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 38, scale = 0)
    private Integer id;
    @JoinColumn(name = "HORARIO_OCUP", referencedColumnName = "ID")
    @ManyToOne
    private HorariosOcup horarioOcup;
    @Size(max = 30)
    @Column(name = "LUNES", length = 30)
    private String lunes;
    @Size(max = 30)
    @Column(name = "MARTES", length = 30)
    private String martes;
    @Size(max = 30)
    @Column(name = "MIERCOLES", length = 30)
    private String miercoles;
    @Size(max = 30)
    @Column(name = "JUEVES", length = 30)
    private String jueves;
    @Size(max = 30)
    @Column(name = "VIERNES", length = 30)
    private String viernes;
    @Size(max = 30)
    @Column(name = "SABADO", length = 30)
    private String sabado;
    
    public HorarioLibre() {
    }

    public HorarioLibre(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HorariosOcup getHorarioOcup() {
        return horarioOcup;
    }

    public void setHorarioOcup(HorariosOcup horarioOcup) {
        this.horarioOcup = horarioOcup;
    }

    public String getLunes() {
        return lunes;
    }

    public void setLunes(String lunes) {
        this.lunes = lunes;
    }

    public String getMartes() {
        return martes;
    }

    public void setMartes(String martes) {
        this.martes = martes;
    }

    public String getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(String miercoles) {
        this.miercoles = miercoles;
    }

    public String getJueves() {
        return jueves;
    }

    public void setJueves(String jueves) {
        this.jueves = jueves;
    }

    public String getViernes() {
        return viernes;
    }

    public void setViernes(String viernes) {
        this.viernes = viernes;
    }

    public String getSabado() {
        return sabado;
    }

    public void setSabado(String sabado) {
        this.sabado = sabado;
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
        if (!(object instanceof HorarioLibre)) {
            return false;
        }
        HorarioLibre other = (HorarioLibre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HorarioLibre[ id=" + id + " ]";
    }
    
}

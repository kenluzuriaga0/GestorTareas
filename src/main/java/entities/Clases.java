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
@Table(name = "CLASES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clases.findAll", query = "SELECT c FROM Clases c")
    , @NamedQuery(name = "Clases.findById", query = "SELECT c FROM Clases c WHERE c.id = :id")
    , @NamedQuery(name = "Clases.findByGrupo", query = "SELECT c FROM Clases c WHERE c.grupo = :grupo")
    , @NamedQuery(name = "Clases.findByMateria", query = "SELECT c FROM Clases c WHERE c.materia = :materia")
    , @NamedQuery(name = "Clases.findByDocente", query = "SELECT c FROM Clases c WHERE c.docente = :docente")
    , @NamedQuery(name = "Clases.findByLunes", query = "SELECT c FROM Clases c WHERE c.lunes = :lunes")
    , @NamedQuery(name = "Clases.findByMartes", query = "SELECT c FROM Clases c WHERE c.martes = :martes")
    , @NamedQuery(name = "Clases.findByMiercoles", query = "SELECT c FROM Clases c WHERE c.miercoles = :miercoles")
    , @NamedQuery(name = "Clases.findByJueves", query = "SELECT c FROM Clases c WHERE c.jueves = :jueves")
    , @NamedQuery(name = "Clases.findByViernes", query = "SELECT c FROM Clases c WHERE c.viernes = :viernes")
    , @NamedQuery(name = "Clases.findBySabado", query = "SELECT c FROM Clases c WHERE c.sabado = :sabado")
    , @NamedQuery(name = "Clases.findByDomingo", query = "SELECT c FROM Clases c WHERE c.domingo = :domingo")
    , @NamedQuery(name = "Clases.findByEstado", query = "SELECT c FROM Clases c WHERE c.estado = :estado")})
public class Clases implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 25)
    @Column(name = "GRUPO")
    private String grupo;
    @Size(max = 25)
    @Column(name = "MATERIA")
    private String materia;
    @Size(max = 25)
    @Column(name = "DOCENTE")
    private String docente;
    @Size(max = 25)
    @Column(name = "LUNES")
    private String lunes;
    @Size(max = 25)
    @Column(name = "MARTES")
    private String martes;
    @Size(max = 25)
    @Column(name = "MIERCOLES")
    private String miercoles;
    @Size(max = 25)
    @Column(name = "JUEVES")
    private String jueves;
    @Size(max = 25)
    @Column(name = "VIERNES")
    private String viernes;
    @Size(max = 25)
    @Column(name = "SABADO")
    private String sabado;
    @Size(max = 25)
    @Column(name = "DOMINGO")
    private String domingo;
    @Size(max = 25)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "idClases")
    private List<HorariosOcup> horariosOcupList;

    public Clases() {
    }

    public Clases(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
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

    public String getDomingo() {
        return domingo;
    }

    public void setDomingo(String domingo) {
        this.domingo = domingo;
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
        if (!(object instanceof Clases)) {
            return false;
        }
        Clases other = (Clases) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Clases[ id=" + id + " ]";
    }
    
}

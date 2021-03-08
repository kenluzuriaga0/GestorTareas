/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
    @Column(name = "ID", nullable = false, precision = 38, scale = 0)
    private Integer id;
    @Size(max = 50)
    @Column(name = "GRUPO", length = 50)
    private String grupo;
    @Size(max = 50)
    @Column(name = "MATERIA", length = 50)
    private String materia;
    @Size(max = 50)
    @Column(name = "DOCENTE", length = 50)
    private String docente;
    @Size(max = 25)
    @Column(name = "LUNES", length = 25)
    private String lunes;
    @Size(max = 25)
    @Column(name = "MARTES", length = 25)
    private String martes;
    @Size(max = 25)
    @Column(name = "MIERCOLES", length = 25)
    private String miercoles;
    @Size(max = 25)
    @Column(name = "JUEVES", length = 25)
    private String jueves;
    @Size(max = 25)
    @Column(name = "VIERNES", length = 25)
    private String viernes;
    @Size(max = 25)
    @Column(name = "SABADO", length = 25)
    private String sabado;
    @Size(max = 25)
    @Column(name = "DOMINGO", length = 25)
    private String domingo;
    @Size(max = 25)
    @Column(name = "ESTADO", length = 25)
    private String estado;
    @JoinColumn(name = "HORARIO_OCUP", referencedColumnName = "ID")
    @ManyToOne
    private HorariosOcup horarioOcup;

    public Clases() {
    }

    public Clases(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public HorariosOcup getHorarioOcup() {
        return horarioOcup;
    }

    public void setHorarioOcup(HorariosOcup horarioOcup) {
        this.horarioOcup = horarioOcup;
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

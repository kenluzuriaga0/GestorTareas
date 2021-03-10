/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kenlu
 */
@Entity
@Table(name = "HORARIOS_INVER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorariosInver.findAll", query = "SELECT h FROM HorariosInver h")
    , @NamedQuery(name = "HorariosInver.findById", query = "SELECT h FROM HorariosInver h WHERE h.id = :id")
    , @NamedQuery(name = "HorariosInver.findByHorasInvertidas", query = "SELECT h FROM HorariosInver h WHERE h.horasInvertidas = :horasInvertidas")
    , @NamedQuery(name = "HorariosInver.findByGechaGenerada", query = "SELECT h FROM HorariosInver h WHERE h.gechaGenerada = :gechaGenerada")
    , @NamedQuery(name = "HorariosInver.findByEstado", query = "SELECT h FROM HorariosInver h WHERE h.estado = :estado")})
public class HorariosInver implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 38, scale = 0)
    private Integer id;
    @Column(name = "HORAS_INVERTIDAS")
    private Float horasInvertidas;
    @Column(name = "GECHA_GENERADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gechaGenerada;
    @Size(max = 20)
    @Column(name = "ESTADO", length = 20)
    private String estado;
    @JoinColumn(name = "ID_CURSOS", referencedColumnName = "ID")
    @ManyToOne
    private Cursos idCursos;
    @JoinColumn(name = "ID_LIBROS", referencedColumnName = "ID")
    @ManyToOne
    private Libros idLibros;
    @JoinColumn(name = "ID_USUARIOS", referencedColumnName = "ID")
    @ManyToOne
    private Usuarios idUsuarios;
    @JoinColumn(name = "ID_VARIAS", referencedColumnName = "ID")
    @ManyToOne
    private Varios idVarias;

    public HorariosInver() {
    }

    public HorariosInver(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getHorasInvertidas() {
        return horasInvertidas;
    }

    public void setHorasInvertidas(Float horasInvertidas) {
        this.horasInvertidas = horasInvertidas;
    }

    public Date getGechaGenerada() {
        return gechaGenerada;
    }

    public void setGechaGenerada(Date gechaGenerada) {
        this.gechaGenerada = gechaGenerada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cursos getIdCursos() {
        return idCursos;
    }

    public void setIdCursos(Cursos idCursos) {
        this.idCursos = idCursos;
    }

    public Libros getIdLibros() {
        return idLibros;
    }

    public void setIdLibros(Libros idLibros) {
        this.idLibros = idLibros;
    }

    public Usuarios getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Usuarios idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Varios getIdVarias() {
        return idVarias;
    }

    public void setIdVarias(Varios idVarias) {
        this.idVarias = idVarias;
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
        if (!(object instanceof HorariosInver)) {
            return false;
        }
        HorariosInver other = (HorariosInver) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HorariosInver[ id=" + id + " ]";
    }
    
}

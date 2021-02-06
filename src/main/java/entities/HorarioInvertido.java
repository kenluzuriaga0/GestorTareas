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
@Table(name = "HORARIO_INVERTIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorarioInvertido.findAll", query = "SELECT h FROM HorarioInvertido h")
    , @NamedQuery(name = "HorarioInvertido.findById", query = "SELECT h FROM HorarioInvertido h WHERE h.id = :id")
    , @NamedQuery(name = "HorarioInvertido.findByDia", query = "SELECT h FROM HorarioInvertido h WHERE h.dia = :dia")
    , @NamedQuery(name = "HorarioInvertido.findByHoraInicio", query = "SELECT h FROM HorarioInvertido h WHERE h.horaInicio = :horaInicio")
    , @NamedQuery(name = "HorarioInvertido.findByHorasInvertidas", query = "SELECT h FROM HorarioInvertido h WHERE h.horasInvertidas = :horasInvertidas")})
public class HorarioInvertido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Size(max = 30)
    @Column(name = "DIA")
    private String dia;
    @Column(name = "HORA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicio;
    @Column(name = "HORAS_INVERTIDAS")
    private Short horasInvertidas;
    @JoinColumn(name = "ID_ACTIVIDAD", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Actividad idActividad;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public HorarioInvertido() {
    }

    public HorarioInvertido(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Short getHorasInvertidas() {
        return horasInvertidas;
    }

    public void setHorasInvertidas(Short horasInvertidas) {
        this.horasInvertidas = horasInvertidas;
    }

    public Actividad getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Actividad idActividad) {
        this.idActividad = idActividad;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
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
        if (!(object instanceof HorarioInvertido)) {
            return false;
        }
        HorarioInvertido other = (HorarioInvertido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HorarioInvertido[ id=" + id + " ]";
    }
    
}

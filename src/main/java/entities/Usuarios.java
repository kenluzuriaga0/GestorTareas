/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kenlu
 */
@Entity
@Table(name = "USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id")
    , @NamedQuery(name = "Usuarios.findByPrimerNombre", query = "SELECT u FROM Usuarios u WHERE u.primerNombre = :primerNombre")
    , @NamedQuery(name = "Usuarios.findBySegundoNombre", query = "SELECT u FROM Usuarios u WHERE u.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Usuarios.findByPrimerApellido", query = "SELECT u FROM Usuarios u WHERE u.primerApellido = :primerApellido")
    , @NamedQuery(name = "Usuarios.findBySegundoApellido", query = "SELECT u FROM Usuarios u WHERE u.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Usuarios.findByActivPrincipal", query = "SELECT u FROM Usuarios u WHERE u.activPrincipal = :activPrincipal")
    , @NamedQuery(name = "Usuarios.findByFechaNac", query = "SELECT u FROM Usuarios u WHERE u.fechaNac = :fechaNac")
    , @NamedQuery(name = "Usuarios.findByCorreo", query = "SELECT u FROM Usuarios u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuarios.findByUsername", query = "SELECT u FROM Usuarios u WHERE u.username = :username")
    , @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password")
    , @NamedQuery(name = "Usuarios.findByTiempoTrans", query = "SELECT u FROM Usuarios u WHERE u.tiempoTrans = :tiempoTrans")
    , @NamedQuery(name = "Usuarios.findByActivProductiva", query = "SELECT u FROM Usuarios u WHERE u.activProductiva = :activProductiva")
    , @NamedQuery(name = "Usuarios.findByHorasSueno", query = "SELECT u FROM Usuarios u WHERE u.horasSueno = :horasSueno")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 38, scale = 0)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PRIMER_NOMBRE", nullable = false, length = 40)
    private String primerNombre;
    @Size(max = 40)
    @Column(name = "SEGUNDO_NOMBRE", length = 40)
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PRIMER__APELLIDO", nullable = false, length = 40)
    private String primerApellido;
    @Size(max = 40)
    @Column(name = "SEGUNDO_APELLIDO", length = 40)
    private String segundoApellido;
    @Size(max = 40)
    @Column(name = "ACTIV_PRINCIPAL", length = 40)
    private String activPrincipal;
    @Column(name = "FECHA_NAC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNac;
    @Size(max = 40)
    @Column(name = "CORREO", length = 40)
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "USERNAME", nullable = false, length = 40)
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PASSWORD", nullable = false, length = 40)
    private String password;
    @Column(name = "TIEMPO_TRANS")
    private Integer tiempoTrans;
    @Size(max = 40)
    @Column(name = "ACTIV_PRODUCTIVA", length = 40)
    private String activProductiva;
    @Column(name = "HORAS_SUENO")
    private Integer horasSueno;
    @OneToMany(mappedBy = "idUsuarios")
    private List<HorariosInver> horariosInverList;
    @OneToMany(mappedBy = "idUsuario")
    private List<HorariosOcup> horariosOcupList;

    public Usuarios() {
    }

    public Usuarios(Integer id) {
        this.id = id;
    }

    public Usuarios(Integer id, String primerNombre, String primerApellido, String username, String password) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getActivPrincipal() {
        return activPrincipal;
    }

    public void setActivPrincipal(String activPrincipal) {
        this.activPrincipal = activPrincipal;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTiempoTrans() {
        return tiempoTrans;
    }

    public void setTiempoTrans(Integer tiempoTrans) {
        this.tiempoTrans = tiempoTrans;
    }

    public String getActivProductiva() {
        return activProductiva;
    }

    public void setActivProductiva(String activProductiva) {
        this.activProductiva = activProductiva;
    }

    public Integer getHorasSueno() {
        return horasSueno;
    }

    public void setHorasSueno(Integer horasSueno) {
        this.horasSueno = horasSueno;
    }

    @XmlTransient
    public List<HorariosInver> getHorariosInverList() {
        return horariosInverList;
    }

    public void setHorariosInverList(List<HorariosInver> horariosInverList) {
        this.horariosInverList = horariosInverList;
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
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usuarios[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entities.Clases;
import entities.HorariosOcup;
import entities.Sueno;
import entities.Trabajos;
import entities.Usuarios;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sessions.SuenoFacadeLocal;
import sessions.TrabajosFacadeLocal;
import sessions.UsuariosFacadeLocal;

/**
 *
 * @author kenlu
 */
@Named(value = "beanHorarios")
@ViewScoped
public class BeanHorarios implements Serializable {

    @EJB
    private UsuariosFacadeLocal usuariosFacade;
    @EJB
    private TrabajosFacadeLocal trabajosFacade;
    @EJB
    private SuenoFacadeLocal suenoFacade;

    private boolean checkboxito;
    private String[] actividadPrincipal; //para setear

    private Sueno suenito;
    private Usuarios usuario;
    private Trabajos trabajos;
    private Clases clases;
    private HorariosOcup horarioOcupado;

    public BeanHorarios() {
        usuario = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggeado");
        trabajos = new Trabajos();
        suenito = new Sueno();
        
        
    }

    @PostConstruct
    public void init() {

        
        
    }

    public void definirHorarios() {

        setearActividad(); //array a String de tabla usuario
        updateActivTrans(); //merge a usuario
        
        agregarSuenoYtrabajo();
        System.out.println(BigDecimal.valueOf(10) + "ostiah");
    }

    private void updateActivTrans() {
        usuariosFacade.edit(usuario);

    }

    private void setearActividad() {
        String actividad = null;
        if (actividadPrincipal.length == 2) {
            actividad = actividadPrincipal[0] + "-" + actividadPrincipal[1];
        } else if (actividadPrincipal.length == 1) {
            actividad = actividadPrincipal[0];
        }
        usuario.setActivPrincipal(actividad);

    }
    
    private void agregarSuenoYtrabajo(){
        suenito.setId(BigDecimal.valueOf(1));
        suenoFacade.create(suenito);
        
        trabajos.setId(BigDecimal.valueOf(1));
        trabajos.setEstado("activo");
        trabajosFacade.create(trabajos);
    }

    
    
    
    
    
    
    
    
    
    public String[] getActividadPrincipal() {
        setCheckboxito(true);
        return actividadPrincipal;
    }

    public void setActividadPrincipal(String[] actividadPrincipal) {
        this.actividadPrincipal = actividadPrincipal;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public boolean isNotCheckboxito() {
        return !checkboxito;
    }

    public void setCheckboxito(boolean checkboxito) {
        this.checkboxito = checkboxito;
    }

    public UsuariosFacadeLocal getUsuariosFacade() {
        return usuariosFacade;
    }

    public void setUsuariosFacade(UsuariosFacadeLocal usuariosFacade) {
        this.usuariosFacade = usuariosFacade;
    }

    public Sueno getSuenito() {
        return suenito;
    }

    public void setSuenito(Sueno suenito) {
        this.suenito = suenito;
    }

    public Trabajos getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(Trabajos trabajos) {
        this.trabajos = trabajos;
    }

    public Clases getClases() {
        return clases;
    }

    public void setClases(Clases clases) {
        this.clases = clases;
    }

    public HorariosOcup getHorarioOcupado() {
        return horarioOcupado;
    }

    public void setHorarioOcupado(HorariosOcup horarioOcupado) {
        this.horarioOcupado = horarioOcupado;
    }

}

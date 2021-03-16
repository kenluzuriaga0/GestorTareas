/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entities.HorarioLibre;
import entities.HorariosInver;
import entities.HorariosOcup;
import entities.Usuarios;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.chart.PieChartModel;
import sessions.Local.ClasesFacadeLocal;
import sessions.Local.HorarioLibreFacadeLocal;
import sessions.Local.HorariosOcupFacadeLocal;
import sessions.Local.TrabajosFacadeLocal;
import sessions.Local.UsuariosFacadeLocal;

/**
 *
 * @author kenlu
 */
@Named(value = "beanResultados")
@ViewScoped
public class BeanResultados implements Serializable {

    Usuarios usuario;
    HorariosOcup horaOcup;
    HorariosInver horaInver;
    HorarioLibre horaLibre;

    @EJB
    private UsuariosFacadeLocal usuariosFacade;
    @EJB
    private TrabajosFacadeLocal trabajosFacade;
    @EJB
    private ClasesFacadeLocal clasesFacade;
    @EJB
    private HorariosOcupFacadeLocal horaOcupFacade;
    @EJB
    private HorarioLibreFacadeLocal horaLibreFacade;

    public BeanResultados() {
        usuario = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggeado");
        horaOcup = new HorariosOcup();

        horaInver = new HorariosInver();
    }
    private PieChartModel model;

    @PostConstruct
    public void init() {
        model = new PieChartModel();
        horaOcup = horaOcupFacade.getTodoActivo(usuario);
        horaLibre = horaLibreFacade.getTodoActivo(horaOcup);
        setearTabla1();
    }

    private void configPie() {
        //followings are some optional customizations:
        //set title
        model.setTitle("Resultados");
        //set legend position to 'e' (east), other values are 'w', 's' and 'n'
        model.setLegendPosition("e");
        //enable tooltips
        model.setShowDatatip(true);
        //show labels inside pie chart
        model.setShowDataLabels(true);
        //show label text  as 'value' (numeric) , others are 'label', 'percent' (default). Only one can be used.
        model.setDataFormat("value");
        //format: %d for 'value', %s for 'label', %d%% for 'percent'
        model.setDataLabelFormatString("%sH");
        //pie sector colors
        model.setSeriesColors("aaf,afa,faa, faf,abc");
        model.setDiameter(360);
    }

    private void setearTabla1() {
        model.set("Horas sueño", usuario.getHorasSueno());//jobs in thousands
        model.set("Horas clases", getHoyDia() - horaOcup.getHorasOcupadas());
        model.set("Horas trabajo", horaOcup.getHorasOcupadas());
        model.set("Horas transporte", usuario.getTiempoTrans() / 60);
        model.set("Horas Libres", getHoyDia());
        
        configPie();

    }

    private float getHoyDia() {
        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DAY_OF_WEEK);

        switch (dia) {
            case Calendar.MONDAY:
                return horaLibre.getLunes();

            case Calendar.TUESDAY:
                return horaLibre.getMartes();
            case Calendar.WEDNESDAY:
                return horaLibre.getMiercoles();

            case Calendar.THURSDAY:
                return horaLibre.getJueves();
            case Calendar.FRIDAY:
                return horaLibre.getViernes();

            case Calendar.SATURDAY:
                return horaLibre.getSabado();
            default:
                return 0;
        }

    }

    public PieChartModel getModel() {
        return model;
    }
}

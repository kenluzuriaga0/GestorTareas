/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entities.HorariosInver;
import entities.HorariosOcup;
import entities.Trabajos;
import entities.Usuarios;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.chart.PieChartModel;

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
    
    public BeanResultados() {
        usuario = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggeado");
        horaOcup = new HorariosOcup();
        horaInver = new HorariosInver();
    }
    private PieChartModel model;

    @PostConstruct
    public void init() {
        model = new PieChartModel();
        model.set("Horas sueño", 62);//jobs in thousands
        model.set("Horas clases", 46);
        model.set("Horas trabajo", 38);

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
        model.setDataLabelFormatString("%dH");
        //pie sector colors
        model.setSeriesColors("aaf,afa,faa");
        model.setDiameter(350);
    }

    public PieChartModel getModel() {
        return model;
    }
}

package controlador;

import entities.Clases;
import entities.HorarioLibre;
import entities.HorariosOcup;
import entities.Trabajos;
import entities.Usuarios;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;
import sessions.Local.ClasesFacadeLocal;
import sessions.Local.HorarioLibreFacadeLocal;
import sessions.Local.HorariosOcupFacadeLocal;
import sessions.Local.TrabajosFacadeLocal;
import sessions.Local.UsuariosFacadeLocal;
import util.ManejoExcel;

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
    private ClasesFacadeLocal clasesFacade;
    @EJB
    private HorariosOcupFacadeLocal horaOcupFacade;
    @EJB
    private HorarioLibreFacadeLocal horaLibreFacade;

    private String[] actividadPrincipal; //para setear
    private UploadedFile clasesFile;
    private ManejoExcel excelControl;

    //entidades
    private Usuarios usuario;
    private Trabajos trabajos;
    private Clases clases;
    private HorariosOcup horaOcup;
    private HorarioLibre horaLib;

    public BeanHorarios() {
        usuario = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggeado");
        trabajos = new Trabajos();
        horaOcup = new HorariosOcup();
        horaLib = new HorarioLibre();
    }

    @PostConstruct
    public void init() {
        actividadPrincipal = new String[0];
    }

    public void definirHorarios() {
        try {
            updateUsuario(); //merge a usuario
            agregarTrabajo();
            agregarHorarioOcup();
            updateClases(); // añadir la foranea
            obtenerHoras();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado y Actualizado", "Guardado y Actualizado con exito"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar", e.getMessage()));
        }
    }

    private void updateUsuario() {//array a String de tabla usuario y 
        setearActividad();
        usuariosFacade.edit(usuario);

    }

    private void updateClases() {
        if (obtenerBoxSeleccionados("Estudiar")) {

            for (Clases clases : clasesHorario) {
                clases.setHorarioOcup(horaOcup);
                clasesFacade.edit(clases);
            }
        } else {
            System.out.println("no estudia");
        }
    }

    private void agregarTrabajo() {

        if (obtenerBoxSeleccionados("Trabajar")) {
            trabajos.setId(1 + trabajosFacade.getMaxId());
            trabajos.setEstado("activo");
            trabajosFacade.create(trabajos);
        } else {
            System.out.println("no trabaja");
        }

    }

    private void agregarHorarioOcup() {

        horaOcup.setId(1 + horaOcupFacade.getMaxId());
        horaOcup.setIdUsuario(usuario);
        if (horaOcupFacade.getCountByUser(horaOcup) != 0) {
            horaOcupFacade.disableStatusbyUser(horaOcup);

        }

        if (obtenerBoxSeleccionados("Trabajar")) {

            horaOcup.setIdTrabajo(trabajos);
        }
        horaOcup.setHorasOcupadas(calcularHorasOcup());
        horaOcup.setEstado("activo");

        horaOcupFacade.create(horaOcup);

    }

    private Float calcularHorasOcup() {
        Float total = 0F;
        try {
            int sueno = usuario.getHorasSueno();
            if (obtenerBoxSeleccionados("Trabajar")) {
                int laboral = trabajos.getHorasLaborales();
                total = Float.valueOf((usuario.getTiempoTrans() / 60F) + sueno + laboral);
            } else {
                total = Float.valueOf((usuario.getTiempoTrans() / 60F) + sueno);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + " ojo");
        }
        return total;
    }

    private void obtenerHoras() {
        if (obtenerBoxSeleccionados("Estudiar")) {

            List<String> dias = new ArrayList<>();
            try {
                dias = clasesFacade.getHorasLunes(horaOcup);
                horaLib.setLunes(picarHoras(dias)+horaOcupFacade.getHorasOcupadasActivo(horaOcup));
                
                dias = clasesFacade.getHorasMartes(horaOcup);
                horaLib.setMartes(picarHoras(dias)+horaOcupFacade.getHorasOcupadasActivo(horaOcup));
                
                dias = clasesFacade.getHorasMiercoles(horaOcup);
                horaLib.setMiercoles(picarHoras(dias)+horaOcupFacade.getHorasOcupadasActivo(horaOcup));
                
                dias = clasesFacade.getHorasJueves(horaOcup);
                horaLib.setJueves(picarHoras(dias)+horaOcupFacade.getHorasOcupadasActivo(horaOcup));
                
                dias = clasesFacade.getHorasViernes(horaOcup);
                horaLib.setViernes(picarHoras(dias)+horaOcupFacade.getHorasOcupadasActivo(horaOcup));
                
                dias = clasesFacade.getHorasSabado(horaOcup);
                horaLib.setSabado(picarHoras(dias));
                
                horaLib.setId(1 + horaLibreFacade.getMaxId());
                horaLib.setHorarioOcup(horaOcup);
                horaLibreFacade.create(horaLib);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private float picarHoras(List<String> dias) throws Exception {
        SimpleDateFormat formatito = new SimpleDateFormat("HH:mm");
        Date hora1 = null;
        Date hora2 = null;
        String[] horaSeparados = new String[2];
        float diferencia = 0;

        for (String day : dias) {
            horaSeparados = day.split("-");
            hora1 = formatito.parse(horaSeparados[0].trim()); //7
            hora2 = formatito.parse(horaSeparados[1].trim());//9

            long inicio = hora1.getTime();
            long fin = hora2.getTime();

            diferencia = diferencia + ((fin - inicio) / 3600000);
            System.out.println("fin - inicio: " + fin + " - " + inicio);
            // horaLib.setLunes(diferencia);

        }

        System.out.println("diferencia: " + diferencia);
        return diferencia;
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

// CARGAR EL EXCEL CLASES 
    public StreamedContent descargarArchivo() throws Exception {
        return new DefaultStreamedContent().builder()
                .name("Plantilla_Horario_Universidad.xlsx")
                .contentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/docs/Plantilla_Horario_Universidad.xlsx"))
                .build();

    }

    private Workbook wb;
    private Sheet sh;
    private InputStream fis;
    List<Clases> clasesHorario;

    public void handleFileUpload(FileUploadEvent event) throws Exception {
        try {
            if (event != null) {
                excelControl = new ManejoExcel();
                if (excelControl.esExcel(event.getFile().getFileName())) {

                    try {
                        fis = (InputStream) event.getFile().getInputStream();  //obtener el Stream del archivo escogido
                        wb = WorkbookFactory.create(fis);
                        sh = wb.getSheetAt(0);

                        clasesHorario = excelControl.importDataClases(sh);

                        if (!clasesHorario.isEmpty()) {
                            for (Clases clase : clasesHorario) {
                                clase.setId(1 + clasesFacade.getMaxId());
                                clase.setEstado("activo");
                                clasesFacade.create(clase);
                            }
                        }
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado Horario de Clases", "Guardado con exito"));

                    } catch (IOException | InvalidFormatException | EncryptedDocumentException ex) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de formato excel", ex.getMessage()));

                    }
                }
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Archivo invalido", ex.getMessage()));
        }
    }

    //AGREGADO POR EL CHAMO
    public void cambioEstadoCheck(ValueChangeEvent e) {
        String[] check = (String[]) e.getNewValue();
        this.setActividadPrincipal(check);
    }

    //AGREGADO POR EL CHAMO
    public boolean obtenerBoxSeleccionados(String texto) {
        boolean seleccionado = false;
        for (String e : this.actividadPrincipal) {
            if (e.trim().equalsIgnoreCase(texto.trim())) {
                seleccionado = true;
            }
        }
        return seleccionado;
    }

    public StreamedContent getPlatillaClase() throws Exception {
        return descargarArchivo();
    }

    public UploadedFile getClasesFile() {
        return clasesFile;
    }

    public void setclasesFile(UploadedFile clasesFile) {
        this.clasesFile = clasesFile;
    }

    public String[] getActividadPrincipal() {
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

    public UsuariosFacadeLocal getUsuariosFacade() {
        return usuariosFacade;
    }

    public void setUsuariosFacade(UsuariosFacadeLocal usuariosFacade) {
        this.usuariosFacade = usuariosFacade;
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

    public HorariosOcup getHoraOcup() {
        return horaOcup;
    }

    public void setHoraOcup(HorariosOcup horaOcup) {
        this.horaOcup = horaOcup;
    }

}

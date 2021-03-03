package controlador;

import entities.Clases;
import entities.HorariosOcup;
import entities.Sueno;
import entities.Trabajos;
import entities.Usuarios;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
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
import sessions.Local.SuenoFacadeLocal;
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
    private SuenoFacadeLocal suenoFacade;
    @EJB
    private ClasesFacadeLocal clasesFacade;

    private String[] actividadPrincipal; //para setear
    private UploadedFile clasesFile;
    private ManejoExcel excelControl;

    //entidades
    private Sueno suenito;
    private Usuarios usuario;
    private Trabajos trabajos;
    private Clases clases;
    private HorariosOcup horarioOcupado;

    public BeanHorarios() {
        usuario = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggeado");
        trabajos = new Trabajos();
        suenito = new Sueno();
        actividadPrincipal = new String[0];

    }

    @PostConstruct
    public void init() {

    }

    public void definirHorarios() {
        try {
            setearActividad(); //array a String de tabla usuario
            updateActivTrans(); //merge a usuario

            agregarSuenoYtrabajo();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado y Actualizado", "Guardado y Actualizado con exito"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar", e.getMessage()));
        }
    }

    private void updateActivTrans() {
        usuariosFacade.edit(usuario);

    }

    private void agregarSuenoYtrabajo() {
        suenito.setId(BigDecimal.valueOf(1 + suenoFacade.getMaxId()));
        suenoFacade.create(suenito);

        trabajos.setId(BigDecimal.valueOf(1 + trabajosFacade.getMaxId()));

        trabajos.setEstado("activo");
        trabajosFacade.create(trabajos);
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
    int i = 6;

    public void handleFileUpload(FileUploadEvent event) throws Exception {
        try {
            if (event != null) {
                excelControl = new ManejoExcel();
                if (excelControl.esExcel(event.getFile().getFileName())) {

                    try {
                        fis = (InputStream) event.getFile().getInputStream();  //obtener el Stream del archivo escogido
                        wb = WorkbookFactory.create(fis);
                        sh = wb.getSheetAt(0);

                        List<Clases> clasesHorario = excelControl.importDataClases(sh);

                        if (!clasesHorario.isEmpty()) {
                            for (Clases clase : clasesHorario) {
                                //  this.addRowSearching(clase);
                                clase.setId(BigDecimal.valueOf(i));
                                i++;
                                clasesFacade.create(clase);
                            }
                        }

                    } catch (IOException | InvalidFormatException | EncryptedDocumentException ex) {
                        Logger.getLogger(BeanHorarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", ex.getMessage()));
        }
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

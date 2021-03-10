package controlador;

import entities.Cursos;
import entities.HorariosInver;
import entities.HorariosOcup;
import entities.Libros;
import entities.Usuarios;
import entities.Varios;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sessions.Local.CursosFacadeLocal;
import sessions.Local.HorariosInverFacadeLocal;
import sessions.Local.HorariosOcupFacadeLocal;
import sessions.Local.LibrosFacadeLocal;
import sessions.Local.UsuariosFacadeLocal;
import sessions.Local.VariosFacadeLocal;
import util.GoogleBooks;

/**
 *
 * @author kenlu
 */
@Named(value = "beanInversion")
@ViewScoped
public class BeanInversion implements Serializable {

    @EJB
    private UsuariosFacadeLocal usuariosFacade;
    @EJB
    private CursosFacadeLocal cursosFacade;
    @EJB
    private LibrosFacadeLocal librosFacade;
    @EJB
    private VariosFacadeLocal variosFacade;
    @EJB
    private HorariosInverFacadeLocal horaInverFacade;
    @EJB
    private HorariosOcupFacadeLocal horaOcupFacade;

    private String[] actividadProductiva;

    //models
    Cursos curso;
    Libros libro;
    Varios varios;
    Usuarios usuario;
    HorariosInver horaInver;
    HorariosOcup horaOcup;

    int num = 0;
    GoogleBooks google;

    public BeanInversion() {

        usuario = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggeado");
        curso = new Cursos();
        libro = new Libros();
        varios = new Varios();
        horaInver = new HorariosInver();
        horaOcup = new HorariosOcup();
    }

    @PostConstruct
    public void init() {
        horaOcup.setIdUsuario(usuario);
        num = 0;
        google = new GoogleBooks();
        actividadProductiva = new String[0];
    }

    public void definirInversion() {
        updateActivProductiva(); //merge a usuario
        agregarCursoYLibroYVarios();
        agregarHorariosInver();
    }

    private void agregarHorariosInver() {
        horaInver.setId(1 + horaInverFacade.getMaxId());
        horaInver.setIdUsuarios(usuario);
        if (horaInverFacade.getCountByUser(horaInver) != 0) {
            horaInverFacade.disableStatusbyUser(horaInver);
        }
        if (obtenerBoxSeleccionados("Cursos")) {

            horaInver.setIdCursos(curso);
        }
        
        horaInver.setHorasInvertidas(calcularHorasInver());
        horaInver.setEstado("activo");
        
        try {
            horaInverFacade.create(horaInver);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardado Exitosamente", "Guardado Exitosamente"));

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error COUNT(ID HORARIOS_INVER", ex.getMessage()));

        }

    }

    private void updateActivProductiva() {
        setearActividad(); //array a String de tabla usuario
        usuariosFacade.edit(usuario);

    }

    private Float calcularHorasInver() {
        Float total = 0F;
        try {
            total = 24 - horaOcupFacade.find(usuario.getId()).getHorasOcupadas();
        } catch (Exception e) {
            System.out.println(e.getMessage() + " ojo");
        }
        return total;
    }

    private void setearActividad() {
        String actividad = null;
        if (actividadProductiva.length == 2) {
            actividad = actividadProductiva[0] + "-" + actividadProductiva[1];
        } else if (actividadProductiva.length == 1) {
            actividad = actividadProductiva[0];
        }
        usuario.setActivProductiva(actividad);
    }

    private void agregarCursoYLibroYVarios() {
        if (obtenerBoxSeleccionados("Lectura")) {

        }
        if (this.varios.getNombre() != null) {

            varios.setId(1 + variosFacade.getMaxId());
            variosFacade.create(varios);
        }
        if (obtenerBoxSeleccionados("Cursos")) {
            curso.setId(1 + cursosFacade.getMaxId());
            cursosFacade.create(curso);
        }

    }

    public void cambiarEstadoCheck(ValueChangeEvent e) {
        String[] ex = (String[]) e.getNewValue();
        this.setActividadProductiva(ex);
    }

    public boolean obtenerBoxSeleccionados(String texto) {
        boolean seleccionado = false;
        for (String box : this.actividadProductiva) {
            if (box.trim().equalsIgnoreCase(texto.trim())) {
                seleccionado = true;
            }
        }
        return seleccionado;
    }

    public void guardarLibro() {
//        libro.setId(Integer.valueOf(1 + librosFacade.getMaxId()));
//
//        libro.setNombre(arrayDeJson.get(index).getVolumeInfoObject().getTitle());
//        libro.setAutor(arrayDeJson.get(index).getVolumeInfoObject().getAuthors().get(0));
        System.out.println("keeeeeeeeeeeeeeeeeeen");

    }

    public GoogleBooks getGoogle() {
        return google;
    }

    public void setGoogle(GoogleBooks google) {
        this.google = google;
    }

    public int getNum() {

        return num++;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String[] getActividadProductiva() {
        return actividadProductiva;
    }

    public void setActividadProductiva(String[] actividadProductiva) {
        this.actividadProductiva = actividadProductiva;
    }

    public Cursos getCurso() {
        return curso;
    }

    public Libros getLibro() {
        return libro;
    }

    public Varios getVarios() {
        return varios;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

}

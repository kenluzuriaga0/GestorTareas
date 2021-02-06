package entities;

import entities.Materia;
import entities.TipoHorario;
import entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-06T02:14:07")
@StaticMetamodel(Horario.class)
public class Horario_ { 

    public static volatile SingularAttribute<Horario, Materia> idMateria;
    public static volatile SingularAttribute<Horario, Date> horaFinal;
    public static volatile SingularAttribute<Horario, Usuario> idUsuario;
    public static volatile SingularAttribute<Horario, Short> id;
    public static volatile SingularAttribute<Horario, String> dia;
    public static volatile SingularAttribute<Horario, TipoHorario> idTipoHorario;
    public static volatile SingularAttribute<Horario, Date> horaInicio;
    public static volatile SingularAttribute<Horario, Short> horasOcupadas;

}
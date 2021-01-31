package entities;

import entities.Actividad;
import entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-31T00:07:25")
@StaticMetamodel(HorarioInvertido.class)
public class HorarioInvertido_ { 

    public static volatile SingularAttribute<HorarioInvertido, Actividad> idActividad;
    public static volatile SingularAttribute<HorarioInvertido, Short> horasInvertidas;
    public static volatile SingularAttribute<HorarioInvertido, Usuario> idUsuario;
    public static volatile SingularAttribute<HorarioInvertido, Short> id;
    public static volatile SingularAttribute<HorarioInvertido, String> dia;
    public static volatile SingularAttribute<HorarioInvertido, Date> horaInicio;

}
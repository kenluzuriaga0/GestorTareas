package entities;

import entities.Horario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-06T02:14:07")
@StaticMetamodel(TipoHorario.class)
public class TipoHorario_ { 

    public static volatile SingularAttribute<TipoHorario, Short> id;
    public static volatile SingularAttribute<TipoHorario, String> nombre;
    public static volatile ListAttribute<TipoHorario, Horario> horarioList;

}
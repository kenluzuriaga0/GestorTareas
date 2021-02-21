package entities;

import entities.HorariosOcup;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-21T16:20:16")
@StaticMetamodel(Clases.class)
public class Clases_ { 

    public static volatile SingularAttribute<Clases, String> estado;
    public static volatile SingularAttribute<Clases, String> domingo;
    public static volatile SingularAttribute<Clases, String> miercoles;
    public static volatile SingularAttribute<Clases, String> grupo;
    public static volatile SingularAttribute<Clases, String> martes;
    public static volatile SingularAttribute<Clases, String> jueves;
    public static volatile SingularAttribute<Clases, String> docente;
    public static volatile SingularAttribute<Clases, String> viernes;
    public static volatile ListAttribute<Clases, HorariosOcup> horariosOcupList;
    public static volatile SingularAttribute<Clases, String> materia;
    public static volatile SingularAttribute<Clases, String> sabado;
    public static volatile SingularAttribute<Clases, BigDecimal> id;
    public static volatile SingularAttribute<Clases, String> lunes;

}
package entities;

import entities.HorariosInver;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-24T23:54:44")
@StaticMetamodel(Cursos.class)
public class Cursos_ { 

    public static volatile SingularAttribute<Cursos, String> plataforma;
    public static volatile SingularAttribute<Cursos, BigDecimal> id;
    public static volatile SingularAttribute<Cursos, String> nombre;
    public static volatile SingularAttribute<Cursos, String> url;
    public static volatile ListAttribute<Cursos, HorariosInver> horariosInverList;

}
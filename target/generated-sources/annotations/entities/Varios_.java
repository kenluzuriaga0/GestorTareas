package entities;

import entities.HorariosInver;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-11T01:03:51")
@StaticMetamodel(Varios.class)
public class Varios_ { 

    public static volatile SingularAttribute<Varios, BigDecimal> id;
    public static volatile SingularAttribute<Varios, String> nombre;
    public static volatile ListAttribute<Varios, HorariosInver> horariosInverList;
    public static volatile SingularAttribute<Varios, String> detalle;

}
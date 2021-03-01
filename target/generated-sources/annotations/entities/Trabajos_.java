package entities;

import entities.HorariosOcup;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-01T02:38:23")
@StaticMetamodel(Trabajos.class)
public class Trabajos_ { 

    public static volatile SingularAttribute<Trabajos, BigInteger> horasLaborales;
    public static volatile SingularAttribute<Trabajos, String> estado;
    public static volatile ListAttribute<Trabajos, HorariosOcup> horariosOcupList;
    public static volatile SingularAttribute<Trabajos, BigDecimal> id;
    public static volatile SingularAttribute<Trabajos, String> empresa;

}
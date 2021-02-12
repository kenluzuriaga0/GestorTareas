package entities;

import entities.HorariosOcup;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-12T02:21:31")
@StaticMetamodel(Sueno.class)
public class Sueno_ { 

    public static volatile ListAttribute<Sueno, HorariosOcup> horariosOcupList;
    public static volatile SingularAttribute<Sueno, BigDecimal> id;
    public static volatile SingularAttribute<Sueno, BigInteger> horasSueno;

}
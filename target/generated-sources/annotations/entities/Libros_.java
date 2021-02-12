package entities;

import entities.HorariosInver;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-12T02:02:07")
@StaticMetamodel(Libros.class)
public class Libros_ { 

    public static volatile SingularAttribute<Libros, BigInteger> paginas;
    public static volatile SingularAttribute<Libros, String> genero;
    public static volatile SingularAttribute<Libros, BigDecimal> id;
    public static volatile SingularAttribute<Libros, String> nombre;
    public static volatile SingularAttribute<Libros, String> autor;
    public static volatile ListAttribute<Libros, HorariosInver> horariosInverList;

}
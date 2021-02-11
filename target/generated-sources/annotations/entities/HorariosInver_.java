package entities;

import entities.Cursos;
import entities.Libros;
import entities.Usuarios;
import entities.Varios;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-11T01:03:51")
@StaticMetamodel(HorariosInver.class)
public class HorariosInver_ { 

    public static volatile SingularAttribute<HorariosInver, String> estado;
    public static volatile SingularAttribute<HorariosInver, BigInteger> horasInvertidas;
    public static volatile SingularAttribute<HorariosInver, Cursos> idCursos;
    public static volatile SingularAttribute<HorariosInver, Varios> idVarias;
    public static volatile SingularAttribute<HorariosInver, Date> gechaGenerada;
    public static volatile SingularAttribute<HorariosInver, BigDecimal> id;
    public static volatile SingularAttribute<HorariosInver, Libros> idLibros;
    public static volatile SingularAttribute<HorariosInver, Usuarios> idUsuarios;

}
package entities;

import entities.Clases;
import entities.Sueno;
import entities.Trabajos;
import entities.Usuarios;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-11T01:03:51")
@StaticMetamodel(HorariosOcup.class)
public class HorariosOcup_ { 

    public static volatile SingularAttribute<HorariosOcup, String> estado;
    public static volatile SingularAttribute<HorariosOcup, Sueno> idSueno;
    public static volatile SingularAttribute<HorariosOcup, Trabajos> idTrabajo;
    public static volatile SingularAttribute<HorariosOcup, Usuarios> idUsuario;
    public static volatile SingularAttribute<HorariosOcup, Clases> idClases;
    public static volatile SingularAttribute<HorariosOcup, BigDecimal> id;
    public static volatile SingularAttribute<HorariosOcup, BigInteger> horasOcupadas;

}
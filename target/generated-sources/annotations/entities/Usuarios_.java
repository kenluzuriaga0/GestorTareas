package entities;

import entities.HorariosOcup;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-11T01:03:51")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, Date> fechaNac;
    public static volatile SingularAttribute<Usuarios, String> segundoNombre;
    public static volatile SingularAttribute<Usuarios, String> password;
    public static volatile SingularAttribute<Usuarios, String> primerNombre;
    public static volatile SingularAttribute<Usuarios, String> primerApellido;
    public static volatile SingularAttribute<Usuarios, String> activPrincipal;
    public static volatile ListAttribute<Usuarios, HorariosOcup> horariosOcupList;
    public static volatile SingularAttribute<Usuarios, String> correo;
    public static volatile SingularAttribute<Usuarios, String> segundoApellido;
    public static volatile SingularAttribute<Usuarios, BigDecimal> id;
    public static volatile SingularAttribute<Usuarios, String> username;

}
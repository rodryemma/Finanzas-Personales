package modelo;

import java.util.Date;
import javax.*;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Accion;
import modelo.VentaPK;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-01-14T19:27:36")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Accion> accion;
    public static volatile SingularAttribute<Venta, Date> fecha;
    public static volatile SingularAttribute<Venta, Double> precio;
    public static volatile SingularAttribute<Venta, VentaPK> ventaPK;
    public static volatile SingularAttribute<Venta, Integer> cantidad;
    public static volatile SingularAttribute<Venta, Integer> numeroventa;

}
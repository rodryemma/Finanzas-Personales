package modelo;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Accion;
import modelo.CompraPK;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-04-10T00:03:55", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, Accion> accion;
    public static volatile SingularAttribute<Compra, Date> fecha;
    public static volatile SingularAttribute<Compra, Double> precio;
    public static volatile SingularAttribute<Compra, String> numeroCompra;
    public static volatile SingularAttribute<Compra, Integer> cantidad;
    public static volatile SingularAttribute<Compra, CompraPK> compraPK;
    public static volatile SingularAttribute<Compra, String> activo;

}
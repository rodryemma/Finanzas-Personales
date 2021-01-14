package modelo;

import javax.*;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.AccionPK;
import modelo.Compra;
import modelo.Inversor;
import modelo.Venta;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-01-14T19:27:36")
@StaticMetamodel(Accion.class)
public class Accion_ { 

    public static volatile SingularAttribute<Accion, String> simbolo;
    public static volatile SingularAttribute<Accion, Inversor> inversor;
    public static volatile SingularAttribute<Accion, Double> ppcompra;
    public static volatile SingularAttribute<Accion, String> tipo;
    public static volatile SingularAttribute<Accion, AccionPK> accionPK;
    public static volatile SingularAttribute<Accion, Double> ultimoPrecio;
    public static volatile ListAttribute<Accion, Venta> ventaList;
    public static volatile SingularAttribute<Accion, Integer> unidades;
    public static volatile ListAttribute<Accion, Compra> compraList;
    public static volatile SingularAttribute<Accion, String> nombre;

}
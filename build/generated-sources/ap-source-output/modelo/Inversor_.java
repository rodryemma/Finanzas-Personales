package modelo;

import javax.*;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Accion;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-01-14T19:27:36")
@StaticMetamodel(Inversor.class)
public class Inversor_ { 

    public static volatile SingularAttribute<Inversor, Double> montoInvertido;
    public static volatile SingularAttribute<Inversor, Integer> idinversor;
    public static volatile ListAttribute<Inversor, Accion> accionList;
    public static volatile SingularAttribute<Inversor, String> nombre;
    public static volatile SingularAttribute<Inversor, Double> montoTotal;

}
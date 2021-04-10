package modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Accion;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-04-10T00:03:55", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Inversor.class)
public class Inversor_ { 

    public static volatile SingularAttribute<Inversor, Double> montoInvertido;
    public static volatile SingularAttribute<Inversor, Integer> idinversor;
    public static volatile ListAttribute<Inversor, Accion> accionList;
    public static volatile SingularAttribute<Inversor, String> nombre;
    public static volatile SingularAttribute<Inversor, Double> montoTotal;

}
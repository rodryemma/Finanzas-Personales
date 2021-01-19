package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.Accion;
import modelo.AccionPK;

public class selecTabla {

    final DefaultTableModel listaAcciones = new DefaultTableModel(300, 9);
    final DefaultTableModel listaIDAcciones = new DefaultTableModel(300, 9);
    final DefaultTableModel listaCompraAcciones = new DefaultTableModel(300, 9);
    final DefaultTableModel listaIDCompraAcciones = new DefaultTableModel(300, 9);
    
    private static final String SQL_SEL_ACCION = "SELECT nombre,simbolo,tipo,unidades,ppcompra,ultimoPrecio FROM finanzapersonal.accion;";
    private static final String SQL_SEL_IDACCION = "SELECT idAccion,idinversor FROM finanzapersonal.accion;";
    private static final String SQL_SEL_COMPACCION = "SELECT precio,cantidad,fecha,numeroCompra,activo FROM finanzapersonal.compra where idAccion=?;";
    private static final String SQL_SEL_IDCOMPACCION = "SELECT idCompra,idAccion FROM finanzapersonal.compra;";
    
    public DefaultTableModel seleccionarAccion() {

        BaseDatos bD = new BaseDatos();
        java.sql.Connection conx = bD.estableceConexion();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //se ejecuta el comando de select
            stmt = conx.prepareStatement(SQL_SEL_ACCION);

            rs = stmt.executeQuery();
            //Se crea la tabla con los datos peidos en la base de datos
            GestorTabla.configuraColumnas(rs, this.listaAcciones);
            GestorTabla.rellena(rs, this.listaAcciones);

            //se vuelve con la tabla cargada
            return listaAcciones;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return null;

        } finally {
            try {
                rs.close();
                stmt.close();
                bD.cierraConexion();
            } catch (SQLException ex) {
                Logger.getLogger(crearTabla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public DefaultTableModel seleccionarIDAccion() {

        BaseDatos bD = new BaseDatos();
        java.sql.Connection conx = bD.estableceConexion();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //se ejecuta el comando de select
            stmt = conx.prepareStatement(SQL_SEL_IDACCION);

            rs = stmt.executeQuery();
            
            //Se crea la tabla con los datos peidos en la base de datos
            GestorTabla.configuraColumnas(rs, this.listaIDAcciones);
            GestorTabla.rellena(rs, this.listaIDAcciones);

            //se vuelve con la tabla cargada
            return listaIDAcciones;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return null;

        } finally {
            try {
                rs.close();
                stmt.close();
                bD.cierraConexion();
            } catch (SQLException ex) {
                Logger.getLogger(crearTabla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    
    public DefaultTableModel seleccionarCompraAccion(AccionPK accPK){
        
       BaseDatos bD = new BaseDatos();
        java.sql.Connection conx = bD.estableceConexion();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //se ejecuta el comando de select
            stmt = conx.prepareStatement(SQL_SEL_COMPACCION);
            stmt.setInt(1, accPK.getIdAccion());
            
            rs = stmt.executeQuery();
            
            //Se crea la tabla con los datos peidos en la base de datos
            GestorTabla.configuraColumnas(rs, this.listaCompraAcciones);
            GestorTabla.rellena(rs, this.listaCompraAcciones);

            //se vuelve con la tabla cargada
            return listaCompraAcciones;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return null;

        } finally {
            try {
                rs.close();
                stmt.close();
                bD.cierraConexion();
            } catch (SQLException ex) {
                Logger.getLogger(crearTabla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public DefaultTableModel seleccionarIDCompraAccion(){
        
       BaseDatos bD = new BaseDatos();
        java.sql.Connection conx = bD.estableceConexion();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //se ejecuta el comando de select
            stmt = conx.prepareStatement(SQL_SEL_IDCOMPACCION);
            
            
            rs = stmt.executeQuery();
            
            //Se crea la tabla con los datos peidos en la base de datos
            GestorTabla.configuraColumnas(rs, this.listaIDCompraAcciones);
            GestorTabla.rellena(rs, this.listaIDCompraAcciones);

            //se vuelve con la tabla cargada
            return listaIDCompraAcciones;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return null;

        } finally {
            try {
                rs.close();
                stmt.close();
                bD.cierraConexion();
            } catch (SQLException ex) {
                Logger.getLogger(crearTabla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

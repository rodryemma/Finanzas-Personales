
package controlador;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Accion;
import modelo.AccionPK;
import modelo.Compra;
import modelo.CompraPK;

public class editarTabla {
    
    private static final String SQL_UPD_ACCION = "UPDATE `finanzapersonal`.`accion` SET `nombre` = ?, `simbolo` = ?, `ultimoPrecio` = ?, `tipo` = ? WHERE (`idAccion` = ?) and (`idinversor` = ?);";
    private static final String SQL_UPD_COMPRA = "UPDATE `finanzapersonal`.`compra` SET `precio` = ?, `cantidad` = ?, `fecha` = ?, `numeroCompra` = ?, `activo` = ? WHERE (`idCompra` = ?) and (`idAccion` = ?);";
    
    public void editarAccion(Accion accion, AccionPK accionpk) {
        //Establecer coenxion a base de datos
        BaseDatos bD = new BaseDatos();
        java.sql.Connection conx = bD.estableceConexion();
        PreparedStatement stmt = null;
        int registros = 0;
        try {

            stmt = conx.prepareStatement(SQL_UPD_ACCION);
            stmt.setString(1, accion.getNombre());
            stmt.setString(2, accion.getSimbolo());
            stmt.setDouble(3, accion.getUltimoPrecio());
            stmt.setString(4, accion.getTipo());
            stmt.setInt(5, accionpk.getIdAccion());
            stmt.setInt(6, accionpk.getIdinversor());
            registros = stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
            
        }finally{
            try {
                stmt.close();
                bD.cierraConexion();
            } catch (SQLException ex) {
                Logger.getLogger(crearTabla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    
    
       public void editarCompra(Compra compra,CompraPK comprapk) {
        //Establecer coenxion a base de datos
        BaseDatos bD = new BaseDatos();
        java.sql.Connection conx = bD.estableceConexion();
        PreparedStatement stmt = null;
        int registros = 0;
        try {

            stmt = conx.prepareStatement(SQL_UPD_COMPRA);
            stmt.setDouble(1, compra.getPrecio());
            stmt.setInt(2, compra.getCantidad());
            stmt.setDate(3, (Date) compra.getFecha());
            stmt.setString(4, compra.getNumeroCompra());
            stmt.setString(5, compra.getActivo());
            stmt.setInt(6, comprapk.getIdCompra());
            stmt.setInt(7, comprapk.getIdAccion());
            registros = stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
            
        }finally{
            try {
                stmt.close();
                bD.cierraConexion();
            } catch (SQLException ex) {
                Logger.getLogger(crearTabla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
}

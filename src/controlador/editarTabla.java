
package controlador;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Accion;
import modelo.AccionPK;

public class editarTabla {
    
    private static final String SQL_UPD_ACCION = "UPDATE `finanzapersonal`.`accion` SET `nombre` = ?, `simbolo` = ?, `ultimoPrecio` = ?, `tipo` = ? WHERE (`idAccion` = ?) and (`idinversor` = ?);";

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
    
    
    //
}

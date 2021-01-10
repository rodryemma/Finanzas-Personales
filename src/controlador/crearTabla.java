package controlador;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Accion;

public class crearTabla {

    private static final String SQL_INS_ACCION = "INSERT INTO `finanzapersonal`.`accion` (`nombre`, `simbolo`, `ultimoPrecio`, `tipo`, `idinversor`) VALUES (?, ?, ?, ?, ?);";

    public void crearACcion(Accion accion) {
        //Establecer coenxion a base de datos
        BaseDatos bD = new BaseDatos();
        java.sql.Connection conx = bD.estableceConexion();
        PreparedStatement stmt = null;
        int registros = 0;
        try {

            stmt = conx.prepareStatement(SQL_INS_ACCION);
            stmt.setString(1, accion.getNombre());
            stmt.setString(2, accion.getSimbolo());
            stmt.setDouble(3, accion.getUltimoPrecio());
            stmt.setString(4, accion.getTipo());
            stmt.setInt(5, 1);
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

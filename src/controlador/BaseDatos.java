package controlador;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Cuarto Piso Clase encargada de conectarse a la DB y realizar
 * consultas
 */
public class BaseDatos {

    private Connection conexion = null;
    private static String user = "root";
    private static String password = "root";
    private String puerto = "3306";
    private static String db = "finanzapersonal";
    private String host = "localhost";
    private static String zonakey = "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

   
    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static String getDb() {
        return db;
    }

    
    public Connection estableceConexion() {
        if (conexion != null) {
            return conexion;
        }
        try {
            
            String urlConexion = "jdbc:mysql://" + host + ":" + puerto + "/" + db+ zonakey; 

            conexion = DriverManager.getConnection(urlConexion, user, password);


        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al Conectarse a la Base de Datos");
        }
//        return null;
        return conexion;
    }

    //hacemos ping para ver si hay internet
    /*
     * Cierra ConexiÃ³n a la DB
     */
    public void cierraConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al Cerrar la Base de Datos");
        }
    }

    private boolean PingExample(String host) throws UnknownHostException, IOException {
        try {
            String cmd = "";
            if (System.getProperty("os.name").startsWith("Windows")) {
                // For Windows
                cmd = "ping -n 1 " + host;
            } else {
                // For Linux and OSX
                cmd = "ping -c 1 " + host;
            }

            Process myProcess = Runtime.getRuntime().exec(cmd);
            myProcess.waitFor();

            if (myProcess.exitValue() == 0) {

                return true;
            } else {

                return false;
            }

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

}

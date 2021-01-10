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

    /*
     * ConexiÃ³n a la DB
     */
    public Connection estableceConexion() {
        if (conexion != null) {
            return conexion;
        }
        try {
            // Se registra el Driver de MySQL
//            Class.forName("com.mysql.jdbc.Driver");
            //pruebo con un ping si puedo acceder al HOST o tengo problemas de conexion
//            boolean estadoConexion = PingExample(host);

//            System.out.println(estadoConexion);
            //si la conexion falla trabajo con la base de datos local
            //primera opcion que el estadoConexion sea true por ende hay internet, se conecta a la base de datos de internet
//            if (estadoConexion) {
            String urlConexion = "jdbc:mysql://" + host + ":" + puerto + "/" + db+ zonakey; 
                                //jdbc:mysql://localhost:3306/cajeroprofe?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true  
//                System.out.println(urlConexion);
//            String urlConexion = "jdbc:mysql://" + host + "," + user + "," + password + "," + db;
            conexion = DriverManager.getConnection(urlConexion, user, password);
//                return conexion;
            //si no hay conexion se va a coentar a la base de datos local
//            } else {
//                //establesco parametros de conexion local
//                Connection conexion = null;
//                String user = "root";
//                String password = "CuartoPiso4";
//                String puerto = "3306";
//                String db = "cooperativa";
//                String host = "localhost";
//                String urlConexion = "jdbc:mysql://" + host + ":" + puerto + "/" + db;
////                
////                String urlConexion = "jdbc:mysql://" + host + "," + user + "," + password + "," + db;
//                conexion = DriverManager.getConnection(urlConexion, user, password);
//                System.out.println(conexion);
//                return conexion;
//            }

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

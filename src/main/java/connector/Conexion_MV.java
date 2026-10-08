package connector;

import java.sql.*;


public class Conexion_MV {
    public static Connection getConnection() {
        String url = "jdbc:postgresql://10.0.9.226:5432/probas";
        String usuario = "postgres";
        String contrasena = "admin";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contrasena);

            if (conexion != null) {
                System.out.println(" Conexión establecida con éxito a PostgreSQL.");
            }

            return conexion;

        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return null;
    }

}

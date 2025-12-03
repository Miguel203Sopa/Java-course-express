import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Consultas1 {

    private static final String URL =
        "jdbc:sqlserver://localhost:1433;databaseName=zona_fit_db;encrypt=false;instanceName=USER;";
    private static final String USER = "JAVA_USER";
    private static final String PASS = "12345";

    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa a SQL Server.");
            return conexion;
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        conectar();
    }
}

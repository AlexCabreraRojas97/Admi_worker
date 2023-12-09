package Config;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
                  //jdbc:sqlserver://calidad-asistencia.database.windows.net:1433;database=Asistencia;user=josue270795@calidad-asistencia;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;
public class Conexion {

private String driver="com.mysql.jdbc.Driver";
private String url="jdbc:mysql://localhost:3306/asistencia?useUnicode=true&useJDBCCompliantTiShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
private String user="root";
private String pass="root"; 
/*
 private String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
private String url="jdbc:sqlserver://calidad-asistencia.database.windows.net:1433;database=Asistencia;user=josue270795@calidad-asistencia;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
private String user="josue270795";
private String pass="Asistencia123456@";  
 */
    
    public Conexion() {}
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            return (DriverManager.getConnection(url, user, pass));
        } catch (Exception e) {
        }
        return null;
    }
        
    public void desconectar(Connection con){
        try {
            con.close();
        } catch (Exception e) {
        }
    }
}

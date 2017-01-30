
package bd;

import static java.lang.Class.forName;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BD {
    
    private String servidor;
    private String usuario;
    private String contrasena;
    private String driver;

    public BD(String servidor, String usuario, String contrasena, String driver) {
        this.servidor = servidor;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.driver = driver;
    }

    public BD() {
        this.servidor = "jdbc:mysql://localhost/asiatech1";
        this.usuario = "root";
        this.contrasena = "";
        this.driver = "com.mysql.jdbc.Driver";
    }
    
    public Connection conectar() {
        Connection con = null;
        try {
            Class.forName(this.driver);
            con = DriverManager.getConnection(this.servidor, this.usuario, this.contrasena);
        } catch (Exception e) {
            con = null;
            e.printStackTrace();
        }
        
        return con;
    }
    
    public void desconectar(Connection con){
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
}

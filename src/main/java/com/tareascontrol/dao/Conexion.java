package com.tareascontrol.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Sebastian Noreña Marquez
 */
public class Conexion {
    private Connection con;
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String usuario = "root";
    private final String pass = "SpecOp832.";
    private final String urlBaseDatos="jdbc:mysql://localhost:3306/controltareas?serverTimezone=UTC";
    
    private static Conexion conexion;

    public Conexion() {
    }
        
    public static Conexion getInstance() throws SQLException{
        if (conexion == null){
            conexion = new Conexion();
        }
        conexion.conectar();
        return conexion;
    }

    private void conectar() throws SQLException{
        if (con == null || con.isClosed()) {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection(urlBaseDatos, usuario, pass);
        }
    
    }
    public Boolean existeConexion() throws SQLException{
        return con!= null && !con.isClosed();
    }

    public Connection getCon() {
        return con;
    }
    
}

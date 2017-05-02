/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DarKMeYeR
 */

public class FafricaConexion {
    
    private Connection conexion;
        
    public Connection getConexion() {
        return conexion;
    }
    
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    public Connection Conectar()
    {
        try{
        Class.forName("oracle.jdbc.OracleDriver");
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        conexion= DriverManager.getConnection(BaseDeDatos,"SEGURO","1234");
        if(conexion!=null)
        {
            System.out.println("Conexion exitosa a esquema seguro");
        }
            else{System.out.println("Conexion fallida");}
        }
        catch(Exception e)
        {e.printStackTrace();}
       
        return conexion;
    }
}

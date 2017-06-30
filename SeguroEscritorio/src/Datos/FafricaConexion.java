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
    
    public static Connection Conectar() throws Exception
    {
        try
        {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "SEGURO";
        String password = "1234";

        Class.forName(driver); // load Oracle driver

        java.util.Properties info = new java.util.Properties();  
        info.put ("user", username);  
        info.put ("password", password);  
        Connection conn = DriverManager.getConnection(url, info);

        return conn;
        }
        catch(Exception e)
        {
            return null;
        }
    }
}

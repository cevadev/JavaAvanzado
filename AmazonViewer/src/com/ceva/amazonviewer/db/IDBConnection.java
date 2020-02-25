/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceva.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.ceva.amazonviewer.db.DataBase.*;
/**
 *
 * @author PC
 */
public interface IDBConnection {
    default Connection connectToDB()
    {
        Connection connection = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL + DB, USER, PASSWORD);
            if(connection != null)
            {
                System.out.println("Se logro establecer conexion con la Base de datos :)");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            return connection;
        }
    }
}

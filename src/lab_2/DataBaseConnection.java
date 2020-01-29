/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class DataBaseConnection {
    private Connection connection;
    private static DataBaseConnection dBConnection;
    private DataBaseConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/University_database", "root", "");
    }
    static DataBaseConnection getInstance() throws ClassNotFoundException, SQLException{
        if(dBConnection==null){
            dBConnection=new DataBaseConnection();
        }
        return dBConnection;
    }
    Connection getConnection(){
        return connection;
    }
}

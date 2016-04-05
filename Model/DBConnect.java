/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DINHQUY
 */
public class DBConnect {

    protected Connection con;
    
    String use = "root";
    String pass = "";
    String driver = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://localhost/quanlycanbobk";
    
    public void getConnect(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, use, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void getClose(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
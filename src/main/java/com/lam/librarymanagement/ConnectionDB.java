package com.lam.librarymanagement;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {
    private static Connection conn;
    
    public static Connection connect(){

        try {
            String url = "jdbc:sqlite:test.db";
            
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            return conn;
            
            
        } catch (SQLException ex) {
            System.out.println("Error connecting to the Database");
        }
        return null;
        
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lam.librarymanagement.DAOs;

import com.lam.librarymanagement.ConnectionDB;
import com.lam.librarymanagement.Models.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AccountDAO implements DAO<Account> {

    public void createAccountTable() {
        String sql = "CREATE TABLE IF NOT EXISTS account (userName TEXT PRIMARY KEY,password TEXT);";
        try (Connection conn = ConnectionDB.connect(); Statement st = conn.createStatement();) {
            st.execute(sql);
            System.out.println("Table 'account' created successfully.");

        } catch (SQLException ex) {
            System.out.println("Error creating table: " + ex.getMessage());
        }
    }

    @Override
    public void create(Account t) {
        String sql = "Insert into account (userName, password) values (?, ?)";
        try (Connection conn = ConnectionDB.connect(); PreparedStatement ps = conn.prepareStatement(sql);) {
            createAccountTable();
            ps.setString(1, t.getUserName());
            ps.setString(2, t.getPassword());
            ps.executeUpdate();
            System.out.println("Data inserted into 'account' table successfully.");

        } catch (SQLException ex) {
            System.out.println("Error inserting into table: " + ex.getMessage());
        }
    }
    
    public void read(){
        String sql = "SELECT * FROM account";

        try (Connection conn = ConnectionDB.connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            System.out.println("Username\tPassword");
            System.out.println("------------------------");
            
            while (rs.next()) {
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                System.out.println(userName + "\t\t" + password);
            }

        } catch (SQLException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
    
    public boolean isPassCorrect(Account t){
        String sql = "Select password from account where userName = ?";
        try (Connection conn = ConnectionDB.connect(); PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setString(1, t.getUserName());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String password = rs.getString("password");
                return password.equals(t.getPassword());
            }return false;
        }catch(SQLException ex){
            System.out.println("Error verifying password: " + ex.getMessage());
            return false;
        }
    }
    

    @Override
    public void update(Account t, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
    
    
}

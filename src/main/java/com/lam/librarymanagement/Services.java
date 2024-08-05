package com.lam.librarymanagement;

import com.lam.librarymanagement.DAOs.AccountDAO;
import com.lam.librarymanagement.Models.Account;
import javafx.scene.control.Alert;


public class Services {
    AccountDAO accountDAO = new AccountDAO();

    public Services() {
    }

    public Services(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    void login(String userName, String pass) {
        Alert al = new Alert(Alert.AlertType.INFORMATION);
        if (accountDAO.isPassCorrect(new Account(userName, pass))){
            al.setContentText("Password's correct");
            al.show();
        }else{
            al.setContentText("Password's incorrect");
            al.show();
        }
    }
    
    
}

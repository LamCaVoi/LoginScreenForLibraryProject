package com.lam.librarymanagement;

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class LogginController {
    
    Services sv = new Services();

    @FXML
    private AnchorPane Slider;

    @FXML
    private Label loginLabel;

    @FXML
    private AnchorPane loginPane;

    @FXML
    private Label signUpLabel;

    @FXML
    private Pane signUpPane;
    
    @FXML
    private TextField userNameField;
    
    @FXML
    private TextField passField;

    @FXML
    void switchToSignUp(MouseEvent event) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), loginPane);
        fadeTransition.setFromValue(1);        
        fadeTransition.setToValue(0);
        loginPane.setDisable(true);
        fadeTransition.play();
        fadeTransition.setOnFinished(e -> {
            loginPane.setVisible(false);
            loginPane.setDisable(true);
        });

        TranslateTransition slideTransition = new TranslateTransition(Duration.millis(800), Slider);
        slideTransition.setToX(375);
        slideTransition.setInterpolator(Interpolator.LINEAR);
        slideTransition.play();
        
        FadeTransition fadeTransition1 = new FadeTransition(Duration.millis(1000), signUpPane);
        fadeTransition1.setFromValue(0);
        fadeTransition1.setToValue(1);
        fadeTransition.setInterpolator(Interpolator.LINEAR);
        signUpPane.setVisible(true);
        fadeTransition1.play();
        fadeTransition1.setOnFinished(e->signUpPane.setDisable(false));

    }
    
        @FXML
    void switchToLogin(MouseEvent event) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), signUpPane);
        fadeTransition.setFromValue(1);        
        fadeTransition.setToValue(0);
        signUpPane.setDisable(true);
        fadeTransition.play();
        fadeTransition.setOnFinished(e -> {
            signUpPane.setVisible(false);
            signUpPane.setDisable(true);
        });

        TranslateTransition slideTransition = new TranslateTransition(Duration.millis(800), Slider);
        slideTransition.setToX(0);
        slideTransition.setInterpolator(Interpolator.LINEAR);
        slideTransition.play();
        
        FadeTransition fadeTransition1 = new FadeTransition(Duration.millis(1000), loginPane);
        fadeTransition1.setFromValue(0);
        fadeTransition1.setToValue(1);
        fadeTransition.setInterpolator(Interpolator.LINEAR);
        loginPane.setVisible(true);
        fadeTransition1.play();
        signUpPane.setDisable(true);
        fadeTransition1.setOnFinished(e->loginPane.setDisable(false));
    }
    

    @FXML
    void login(ActionEvent event) {
        if (userNameField.getText().isBlank() || passField.getText().isBlank()){
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setContentText("Login and password can't be empty");
            al.show();
            return;            
        }sv.login(userNameField.getText(), passField.getText());
    }
}

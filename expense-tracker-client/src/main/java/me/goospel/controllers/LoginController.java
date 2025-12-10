package me.goospel.controllers;

import javafx.event.EventHandler;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import me.goospel.views.LoginView;

public class LoginController {
    private LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        initialize();
    }

    public void initialize() {
        loginView.getLoginButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(!validateUser() ) return ;

                String eamil = loginView.getUsernameField().getText();
                String password = loginView.getPasswordField().getText();
            }
        });
    }

    private boolean validateUser() {
        TextField usernameField = loginView.getUsernameField();
        PasswordField passwordField = loginView.getPasswordField();

        if (usernameField.getText().isEmpty() || passwordField.getText().isEmpty() ) {
            return false;
        }
        return true;
    }

//    private boolean validateUser(){
//        // empty username
//        if(loginView.getUsernameField().getText().isEmpty()){
//            return false;
//        }
//
//        // empty password
//        if(loginView.getPasswordField().getText().isEmpty()){
//            return false;
//        }
//
//        return true;
//    }
}

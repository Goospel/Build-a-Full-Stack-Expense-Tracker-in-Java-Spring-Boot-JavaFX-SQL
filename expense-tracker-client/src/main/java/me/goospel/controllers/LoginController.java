package me.goospel.controllers;

import com.google.gson.JsonObject;
import javafx.event.EventHandler;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import me.goospel.utils.ApiUtil;
import me.goospel.views.LoginView;

import java.io.IOException;
import java.net.HttpURLConnection;

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

                // authenticate email and password
                HttpURLConnection connection = null;
                try {
                    connection = ApiUtil.fetchApi(
                            // /api/v1/user/login?email=email@email.com&password=password
                            "/api/v1/user/login?email=" + eamil + "&password=" + password,
                            ApiUtil.RequestMethod.POST,
                            null
                    );

                    if (connection.getResponseCode() != 200) {
                        System.out.println(connection.getResponseCode());
                        System.out.println("Failed to Authenticate");
                    } else {
                        System.out.println(connection.getResponseCode());
                        System.out.println("Login Successful");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

//    private boolean validateUser() {
//        TextField usernameField = loginView.getUsernameField();
//        PasswordField passwordField = loginView.getPasswordField();
//
//        if (usernameField.getText().isEmpty() || passwordField.getText().isEmpty() ) {
//            return false;
//        }
//        return true;
//    }

    private boolean validateUser(){
        // empty username
        if(loginView.getUsernameField().getText().isEmpty()){
            return false;
        }

        // empty password
        if(loginView.getPasswordField().getText().isEmpty()){
            return false;
        }

        return true;
    }
}

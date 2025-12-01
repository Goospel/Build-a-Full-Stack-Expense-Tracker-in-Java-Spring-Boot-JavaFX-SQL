package me.goospel.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import me.goospel.utils.Utilitie;
import me.goospel.utils.ViewNavigator;

public class LoginView {
    private Label expenseTrackerLabel = new Label("Expense Tracker");
    private TextField usernameField = new TextField();
    private PasswordField passwordField = new PasswordField();
    private Button loginButton = new Button("Login");
    private Label signupLabel = new Label("Don't hava an account? Click here");

    public void show() {
        Scene scene = createScene();
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        ViewNavigator.switchViews(scene);
    }

    private Scene createScene() {
        VBox mainContainerBox = new VBox(74);
        mainContainerBox.getStyleClass().addAll("main-background");
        mainContainerBox.setAlignment(Pos.TOP_CENTER);

        expenseTrackerLabel.getStyleClass().addAll("header", "text-white");

        mainContainerBox.getChildren().addAll(expenseTrackerLabel, createLoginFormBox());
        return new Scene(mainContainerBox, Utilitie.APP_WIDTH, Utilitie.APP_HEIGHT);
    }

    private VBox createLoginFormBox() {
        VBox loginFormBox = new VBox(74);
        loginFormBox.setAlignment(Pos.CENTER);

        usernameField.getStyleClass().addAll("field-background", "text-light-grey", "text-size-lg", "rounded-border");
        usernameField.setPromptText("Enter Username");
        usernameField.setMaxWidth(473);

        passwordField.getStyleClass().addAll("field-background", "text-light-grey", "text-size-lg", "rounded-border");
        passwordField.setPromptText("Enter password");
        passwordField.setMaxWidth(473);

        loginButton.getStyleClass().addAll("text-size-lg", "bg-light-blue", "text-white", "text-weight-700", "rounded-border");
        loginButton.setMaxWidth(473);

        signupLabel.getStyleClass().addAll("text-size-md", "text-light-grey", "text-underline", "link-text");

        loginFormBox.getChildren().addAll(usernameField, passwordField, loginButton, signupLabel);
        return loginFormBox;
    }
}

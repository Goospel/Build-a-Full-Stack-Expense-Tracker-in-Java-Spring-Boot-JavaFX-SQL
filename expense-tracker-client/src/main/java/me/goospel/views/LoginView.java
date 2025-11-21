package me.goospel.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import me.goospel.utils.ViewNavigator;

public class LoginView {
    private Label expenseTrackerLabel = new Label("Expense Tracker");
    private TextField usernameField = new TextField();
    private PasswordField passwordField = new PasswordField();
    private Button loginButton = new Button("Login");
    private Label signupLabel = new Label("Don't hava an account? Click here");

    public void show() {
        Scene scene = createScene();
        ViewNavigator.switchViews(scene);
    }

    private Scene createScene() {
        VBox mainContainerBox = new VBox();

        mainContainerBox.getChildren().addAll(expenseTrackerLabel, usernameField, passwordField, loginButton, signupLabel);

        return new Scene(mainContainerBox, 100, 100);
    }
}

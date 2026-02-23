package ui;

import dao.CustomerDAO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Customer;

public class CreateAccountUI {

    public void show() {

        Stage stage = new Stage();

        Label title = new Label("Create Account");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #e94560;");

        TextField nameField    = styledField("Name");
        TextField emailField   = styledField("Email");
        TextField phoneField   = styledField("Phone");
        TextField balanceField = styledField("Opening Balance");

        Button createBtn = actionButton("Create Account");
        Label msgLabel = new Label();
        msgLabel.setStyle("-fx-text-fill: #4ecca3; -fx-font-size: 13px;");

        createBtn.setOnAction(e -> {
            try {
                Customer c = new Customer(
                    nameField.getText(),
                    emailField.getText(),
                    phoneField.getText(),
                    Double.parseDouble(balanceField.getText())
                );
                boolean ok = CustomerDAO.create(c);
                msgLabel.setText(ok ? "✔ Account created!" : "✘ Failed.");
                msgLabel.setStyle("-fx-text-fill: " + (ok ? "#4ecca3" : "#e94560") + "; -fx-font-size: 13px;");
            } catch (Exception ex) {
                msgLabel.setText("✘ Invalid input.");
                msgLabel.setStyle("-fx-text-fill: #e94560; -fx-font-size: 13px;");
            }
        });

        VBox vbox = new VBox(12, title, nameField, emailField, phoneField, balanceField, createBtn, msgLabel);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30));
        vbox.setStyle("-fx-background-color: #1a1a2e;");

        stage.setScene(new Scene(vbox, 320, 380));
        stage.setTitle("Create Account");
        stage.show();
    }

    private TextField styledField(String prompt) {
        TextField tf = new TextField();
        tf.setPromptText(prompt);
        tf.setPrefWidth(250);
        tf.setStyle(
            "-fx-background-color: #16213e;" +
            "-fx-text-fill: white;" +
            "-fx-prompt-text-fill: #888;" +
            "-fx-border-color: #0f3460;" +
            "-fx-border-radius: 5px;" +
            "-fx-background-radius: 5px;" +
            "-fx-padding: 8px;" +
            "-fx-font-size: 13px;"
        );
        return tf;
    }

    private Button actionButton(String text) {
        Button btn = new Button(text);
        btn.setPrefWidth(250);
        btn.setPrefHeight(40);
        btn.setStyle(
            "-fx-background-color: #e94560;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 14px;" +
            "-fx-font-weight: bold;" +
            "-fx-border-radius: 6px;" +
            "-fx-background-radius: 6px;" +
            "-fx-cursor: hand;"
        );
        return btn;
    }
}
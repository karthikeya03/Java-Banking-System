package ui;

import dao.CustomerDAO;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class DepositUI {

    public void show() {

        Stage stage = new Stage();

        TextField customerIdField = new TextField();
        customerIdField.setPromptText("Enter Customer ID");
        customerIdField.setStyle("-fx-background-color: #16213e; -fx-text-fill: white; -fx-prompt-text-fill: #888; -fx-border-color: #0f3460; -fx-border-radius: 5; -fx-background-radius: 5; -fx-padding: 8;");

        TextField amountField = new TextField();
        amountField.setPromptText("Enter Deposit Amount");
        amountField.setStyle("-fx-background-color: #16213e; -fx-text-fill: white; -fx-prompt-text-fill: #888; -fx-border-color: #0f3460; -fx-border-radius: 5; -fx-background-radius: 5; -fx-padding: 8;");

        Button depositButton = new Button("Deposit");
        depositButton.setStyle("-fx-background-color: #e94560; -fx-text-fill: white; -fx-font-weight: bold; -fx-border-radius: 5; -fx-background-radius: 5; -fx-pref-width: 200; -fx-pref-height: 38;");

        Label messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: #4ecca3;");

        depositButton.setOnAction(e -> {

            try {

                int customerId = Integer.parseInt(customerIdField.getText());
                double amount = Double.parseDouble(amountField.getText());

                boolean success = CustomerDAO.deposit(customerId, amount);

                if (success)
                    messageLabel.setText("Deposit Successful");
                else
                    messageLabel.setText("Deposit Failed");

            }
            catch (Exception ex) {

                messageLabel.setText("Invalid Input");
            }
        });

        VBox layout = new VBox(15);
        layout.getChildren().addAll(customerIdField, amountField, depositButton, messageLabel);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #1a1a2e;");

        Scene scene = new Scene(layout, 350, 250);

        stage.setTitle("Deposit Money");
        stage.setScene(scene);
        stage.show();
    }
}
package ui;

import service.BankingService;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class TransferUI {

    public void show() {

        Stage stage = new Stage();

        TextField fromIdField = new TextField();
        fromIdField.setPromptText("From Customer ID");
        fromIdField.setStyle("-fx-background-color: #16213e; -fx-text-fill: white; -fx-prompt-text-fill: #888; -fx-border-color: #0f3460; -fx-border-radius: 5; -fx-background-radius: 5; -fx-padding: 8;");

        TextField toIdField = new TextField();
        toIdField.setPromptText("To Customer ID");
        toIdField.setStyle("-fx-background-color: #16213e; -fx-text-fill: white; -fx-prompt-text-fill: #888; -fx-border-color: #0f3460; -fx-border-radius: 5; -fx-background-radius: 5; -fx-padding: 8;");

        TextField amountField = new TextField();
        amountField.setPromptText("Enter Transfer Amount");
        amountField.setStyle("-fx-background-color: #16213e; -fx-text-fill: white; -fx-prompt-text-fill: #888; -fx-border-color: #0f3460; -fx-border-radius: 5; -fx-background-radius: 5; -fx-padding: 8;");

        Button transferButton = new Button("Transfer");
        transferButton.setStyle("-fx-background-color: #e94560; -fx-text-fill: white; -fx-font-weight: bold; -fx-border-radius: 5; -fx-background-radius: 5; -fx-pref-width: 200; -fx-pref-height: 38;");

        Label messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: #4ecca3;");

        transferButton.setOnAction(e -> {

            try {

                int fromId = Integer.parseInt(fromIdField.getText());
                int toId = Integer.parseInt(toIdField.getText());
                double amount = Double.parseDouble(amountField.getText());

                boolean success = BankingService.transfer(fromId, toId, amount);

                if (success)
                    messageLabel.setText("Transfer Successful");
                else
                    messageLabel.setText("Transfer Failed");

            }
            catch (Exception ex) {

                messageLabel.setText("Invalid Input");
            }
        });

        VBox layout = new VBox(15);
        layout.getChildren().addAll(fromIdField, toIdField, amountField, transferButton, messageLabel);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #1a1a2e;");

        Scene scene = new Scene(layout, 350, 300);

        stage.setTitle("Transfer Money");
        stage.setScene(scene);
        stage.show();
    }
}
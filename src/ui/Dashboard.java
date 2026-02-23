package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class Dashboard {

    public void show(Stage stage){

        Button create=new Button("Create Account");
        Button deposit=new Button("Deposit");
        Button withdraw=new Button("Withdraw");
        Button transfer=new Button("Transfer");
        Button view=new Button("View Customers");

        create.setOnAction(e->new CreateAccountUI().show());
        deposit.setOnAction(e->new DepositUI().show());
        withdraw.setOnAction(e->new WithdrawUI().show());
        transfer.setOnAction(e->new TransferUI().show());
        view.setOnAction(e->new ViewCustomersUI().show());

        String btnStyle = "-fx-background-color: #16213e; -fx-text-fill: white; -fx-border-color: #e94560; -fx-border-width: 1; -fx-border-radius: 5; -fx-background-radius: 5; -fx-pref-width: 200; -fx-pref-height: 40;";
        create.setStyle(btnStyle);
        deposit.setStyle(btnStyle);
        withdraw.setStyle(btnStyle);
        transfer.setStyle(btnStyle);
        view.setStyle(btnStyle);

        VBox v=new VBox(15,create,deposit,withdraw,transfer,view);

        v.setAlignment(Pos.CENTER);
        v.setStyle("-fx-background-color: #1a1a2e;");

        stage.setScene(new Scene(v,400,400));
        stage.setTitle("Banking System");
        stage.show();
    }
}
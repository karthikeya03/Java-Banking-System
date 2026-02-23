package ui;

import dao.CustomerDAO;
import model.Customer;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewCustomersUI {

    public void show(){

        Stage s=new Stage();

        TableView<Customer> table=new TableView<>();
        table.setStyle("-fx-background-color: #16213e; -fx-border-color: #0f3460;");

        TableColumn<Customer,Integer> id=new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Customer,String> name=new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Customer,Double> balance=new TableColumn<>("Balance");
        balance.setCellValueFactory(new PropertyValueFactory<>("balance"));

        table.getColumns().addAll(id,name,balance);

        table.getItems().addAll(CustomerDAO.getAll());

        VBox v=new VBox(table);
        v.setStyle("-fx-background-color: #1a1a2e;");

        s.setScene(new Scene(v,500,400));

        s.show();
    }
}
import javafx.application.Application;
import javafx.stage.Stage;
import ui.Dashboard;
import util.DBConnection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        DBConnection.getConnection();

        Dashboard dashboard = new Dashboard();
        dashboard.show(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }
}
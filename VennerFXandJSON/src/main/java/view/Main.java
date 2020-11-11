package view;

import javafx.application.Application;
import javafx.stage.Stage;
import data.JSON;

public class Main extends Application {

    public static  Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage = primaryStage;
        primaryStage.setMinWidth(816);
        primaryStage.setMinHeight(639);
        primaryStage.setTitle("Venner & Bekendte");
        primaryStage.setScene(new TableViewScene().listScene);


        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> new JSON().saveList());
    }


    public static void main(String[] args) {

        new JSON().loadList();
        launch(args);

    }
}

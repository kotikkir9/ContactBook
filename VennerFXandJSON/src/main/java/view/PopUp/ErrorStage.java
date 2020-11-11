package view.PopUp;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.Main;

public class ErrorStage {

    public static void errorStage(String string) {

        Stage errorStage = new Stage();
        errorStage.initModality(Modality.APPLICATION_MODAL);
        errorStage.initStyle(StageStyle.UTILITY);
        errorStage.initOwner(Main.primaryStage);
        errorStage.setResizable(false);

        final double width = 350;
        final double height = 150;

        errorStage.setX(Main.primaryStage.getX() + ((Main.primaryStage.getWidth() / 2) - (width / 2)) - 8);
        errorStage.setY(Main.primaryStage.getY() + ((Main.primaryStage.getHeight() / 2) - (height / 2) - 20));

        errorStage.setTitle("Error");

        Label label = new Label(string);

        Button buttonOK = new Button("Ok");
        buttonOK.setFocusTraversable(false);
        buttonOK.setPrefWidth(100);

        buttonOK.setOnAction(e -> errorStage.close());

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(25);
        gridPane.add(label,0,0);
        gridPane.add(buttonOK,0,1);
        GridPane.setHalignment(label, HPos.CENTER);
        GridPane.setHalignment(buttonOK, HPos.CENTER);

        final Scene scene = new Scene(gridPane, width, height);

        errorStage.setScene(scene);

        errorStage.showAndWait();
    }

}

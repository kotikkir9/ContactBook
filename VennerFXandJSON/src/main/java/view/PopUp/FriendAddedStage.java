package view.PopUp;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.Person;
import view.Main;

public class FriendAddedStage {

    public void newStage(Person person) {

        Stage contactAddedStage = new Stage();
        contactAddedStage.initModality(Modality.APPLICATION_MODAL);
        contactAddedStage.initStyle(StageStyle.UTILITY);
        contactAddedStage.setResizable(false);

        final double width = 350;
        final double height = 150;

        contactAddedStage.setX(Main.primaryStage.getX() + ((Main.primaryStage.getWidth() / 2) - (width / 2)) - 8);
        contactAddedStage.setY(Main.primaryStage.getY() + ((Main.primaryStage.getHeight() / 2) - (height / 2) - 20));

        contactAddedStage.setTitle("Venner & Bekendte");

        Label label = new Label(person.getFirstName() + " " + person.getLastName() + " was added to you contactlist.");

        Button buttonOK = new Button("Continue");
        buttonOK.setFocusTraversable(false);
        buttonOK.setPrefWidth(100);

        buttonOK.setOnAction(e -> contactAddedStage.close());

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(25);
        gridPane.add(label,0,0);
        gridPane.add(buttonOK,0,1);
        GridPane.setHalignment(label, HPos.CENTER);
        GridPane.setHalignment(buttonOK, HPos.CENTER);
        gridPane.setMargin(label, new Insets(0,20,0,20));
        gridPane.setMinSize(width, height);

        contactAddedStage.setScene(new Scene(gridPane));

        contactAddedStage.showAndWait();
    }
}

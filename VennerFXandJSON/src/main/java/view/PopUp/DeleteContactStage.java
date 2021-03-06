package view.PopUp;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.ContactList;
import logic.Person;
import view.Main;

public class DeleteContactStage {

    public void deleteStage(Person person, TableView table) {

        Stage deleteStage = new Stage();
        deleteStage.initModality(Modality.APPLICATION_MODAL);
        deleteStage.initStyle(StageStyle.UTILITY);
        deleteStage.initOwner(Main.primaryStage);
        deleteStage.setResizable(false);

        final double width = 350;
        final double height = 150;

        deleteStage.setX(Main.primaryStage.getX() + ((Main.primaryStage.getWidth() / 2) - (width / 2)) - 8);
        deleteStage.setY(Main.primaryStage.getY() + ((Main.primaryStage.getHeight() / 2) - (height / 2) - 20));

        deleteStage.setTitle("Delete");

        Label label = new Label("Are you sure that you want to delete " + person.getFirstName() + " " + person.getLastName() + "?");

        Button buttonCancel = new Button("Cancel");
        buttonCancel.setFocusTraversable(false);
        buttonCancel.setPrefWidth(100);

        Button buttonConfirm = new Button("Ok");
        buttonConfirm.setFocusTraversable(false);
        buttonConfirm.setPrefWidth(100);

        buttonCancel.setOnAction(e -> deleteStage.close());

        buttonConfirm.setOnAction(e -> {
            new ContactList().deletePerson(person);
            table.getItems().remove(person);
            deleteStage.close();
        });

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(40);
        gridPane.add(buttonCancel,0,1);
        gridPane.add(buttonConfirm,1,1);
        GridPane.setHalignment(label, HPos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(label);
        BorderPane.setAlignment(label, Pos.CENTER);

        borderPane.setBottom(gridPane);
        BorderPane.setMargin(gridPane, new Insets(0,0,30,0));
        BorderPane.setMargin(label, new Insets(0,20,0,20));
        borderPane.setMinSize(width,height);

        final Scene newScene = new Scene(borderPane);
        deleteStage.setScene(newScene);

        deleteStage.showAndWait();
    }

}

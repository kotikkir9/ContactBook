package view.PopUp;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.Person;
import view.Main;

public class ViewProfileStage {

    public void viewProfileStage(Person person) {

        Stage viewProfileStage = new Stage();
        viewProfileStage.initModality(Modality.APPLICATION_MODAL);
        viewProfileStage.initStyle(StageStyle.UTILITY);
        viewProfileStage.initOwner(Main.primaryStage);
        viewProfileStage.setResizable(false);

        final double width = 400;
        final double height = 500;

        viewProfileStage.setX(Main.primaryStage.getX() + ((Main.primaryStage.getWidth() / 2) - (width / 2)) - 8);
        viewProfileStage.setY(Main.primaryStage.getY() + ((Main.primaryStage.getHeight() / 2) - (height / 2) - 20));

        viewProfileStage.setTitle(person.getFirstName() + " " + person.getLastName());

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label labelFirstName = new Label(person.getFirstName());
        labelFirstName.setMinWidth(200);

        Label labelLastName = new Label(person.getLastName());
        Label labelFieldEmail = new Label(person.getEmail());
        Label labelPhoneNumber = new Label(person.getPhoneNumber());
        Label labelBirthday = new Label(person.getBirthday());

        Label labelInterests = new Label(person.getInterestArray().toString());
        labelInterests.setWrapText(true);
        labelInterests.setMaxWidth(300);

        Button buttonClose = new Button("Close");
        buttonClose.setFocusTraversable(false);
        buttonClose.setPrefWidth(100);


        gridPane.add(new Text("First name: "),0,0);
        gridPane.add(new Text("Last name: "), 0,1);
        gridPane.add(new Text("Email: "),0,2);
        gridPane.add(new Text("Phone number: "),0,3);
        gridPane.add(new Text("Birthday: "),0,4);
        gridPane.add(new Separator(Orientation.HORIZONTAL), 0,5,2,1);
        gridPane.add(new Text("Interests:"),0,6);
        gridPane.add(labelInterests,0,7,2,2);

        gridPane.add(labelFirstName,1,0);
        gridPane.add(labelLastName,1,1);
        gridPane.add(labelFieldEmail,1,2);
        gridPane.add(labelPhoneNumber,1,3);
        gridPane.add(labelBirthday,1,4);

        AnchorPane anchorPane = new AnchorPane();
        AnchorPane.setRightAnchor(buttonClose,45.0);
        anchorPane.getChildren().addAll(buttonClose);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setAlignment(gridPane, Pos.CENTER);
        borderPane.setBottom(anchorPane);
        borderPane.setMargin(anchorPane, new Insets(0,0,30,0));

        buttonClose.setOnAction(e -> viewProfileStage.close());

        final Scene newScene = new Scene(borderPane, width, height);
        viewProfileStage.setScene(newScene);
        viewProfileStage.showAndWait();
    }

}

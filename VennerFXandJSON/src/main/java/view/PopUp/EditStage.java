package view.PopUp;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.DateStringToLocalDate;
import logic.InterestContainer;
import logic.Person;
import view.Main;

import java.util.ArrayList;

public class EditStage {

    public void editStage(Person person) {


        Stage editStage = new Stage();
        editStage.initModality(Modality.APPLICATION_MODAL);
        editStage.initStyle(StageStyle.UTILITY);
        editStage.initOwner(Main.primaryStage);
        editStage.setResizable(false);

        final double width = 400;
        final double height = 500;

        editStage.setX(Main.primaryStage.getX() + ((Main.primaryStage.getWidth() / 2) - (width / 2)) - 8);
        editStage.setY(Main.primaryStage.getY() + ((Main.primaryStage.getHeight() / 2) - (height / 2) - 20));

        editStage.setTitle("Edit");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        TextField textFieldFirstName = new TextField();
        textFieldFirstName.setText(person.getFirstName());
        textFieldFirstName.setFocusTraversable(false);
        textFieldFirstName.setMinWidth(200);

        TextField textFieldLastName = new TextField();
        textFieldLastName.setText(person.getLastName());
        textFieldLastName.setFocusTraversable(false);

        TextField textFieldEmail = new TextField();
        textFieldEmail.setText(person.getEmail());
        textFieldEmail.setFocusTraversable(false);

        TextField textFieldPhoneNumber = new TextField();
        textFieldPhoneNumber.setText(person.getPhoneNumber());
        textFieldPhoneNumber.setFocusTraversable(false);

        DatePicker birthdayPicker = new DatePicker();
        birthdayPicker.setFocusTraversable(false);
        birthdayPicker.setMinWidth(200);
        birthdayPicker.setShowWeekNumbers(false);
        birthdayPicker.setValue(DateStringToLocalDate.getBirthdayLocalDate(person.getBirthday()));

        Button buttonCancel = new Button("Cancel");
        buttonCancel.setFocusTraversable(false);
        buttonCancel.setPrefWidth(100);

        Button buttonEdit = new Button("Ok");
        buttonEdit.setFocusTraversable(false);
        buttonEdit.setPrefWidth(100);


        CheckBox checkBoxFootball = new CheckBox();
        checkBoxFootball.setFocusTraversable(false);
        HBox hBoxFootball = new HBox(5, checkBoxFootball, new Text("Football"));
        hBoxFootball.setMinWidth(150);
        checkBoxFootball.setSelected(person.getInterestArray().contains("football"));

        CheckBox checkBoxMusic = new CheckBox();
        checkBoxMusic.setFocusTraversable(false);
        HBox hBoxMusic = new HBox(5, checkBoxMusic, new Text("Music"));
        checkBoxMusic.setSelected(person.getInterestArray().contains("music"));

        CheckBox checkBoxFitness = new CheckBox();
        checkBoxFitness.setFocusTraversable(false);
        HBox hBoxFitness = new HBox(5, checkBoxFitness, new Text("Fitness"));
        checkBoxFitness.setSelected(person.getInterestArray().contains("fitness"));

        CheckBox checkBoxReading = new CheckBox();
        checkBoxReading.setFocusTraversable(false);
        HBox hBoxReading = new HBox(5, checkBoxReading, new Text("Reading"));
        checkBoxReading.setSelected(person.getInterestArray().contains("reading"));

        CheckBox checkBoxCooking = new CheckBox();
        checkBoxCooking.setFocusTraversable(false);
        HBox hBoxCooking = new HBox(5, checkBoxCooking, new Text("Cooking"));
        checkBoxCooking.setSelected(person.getInterestArray().contains("cooking"));

        CheckBox checkBoxRunning = new CheckBox();
        checkBoxRunning.setFocusTraversable(false);
        HBox hBoxRunning = new HBox(5, checkBoxRunning, new Text("Running"));
        checkBoxRunning.setSelected(person.getInterestArray().contains("running"));

        CheckBox checkBoxProgramming = new CheckBox();
        checkBoxProgramming.setFocusTraversable(false);
        HBox hBoxProgramming = new HBox(5, checkBoxProgramming, new Text("Programming"));
        checkBoxProgramming.setSelected(person.getInterestArray().contains("programming"));

        CheckBox checkBoxSinging = new CheckBox();
        checkBoxSinging.setFocusTraversable(false);
        HBox hBoxSinging = new HBox(5, checkBoxSinging, new Text("Singing"));
        checkBoxSinging.setSelected(person.getInterestArray().contains("singing"));

        CheckBox checkBoxGuitar = new CheckBox();
        checkBoxGuitar.setFocusTraversable(false);
        HBox hBoxGuitar = new HBox(5, checkBoxGuitar, new Text("Guitar"));
        checkBoxGuitar.setSelected(person.getInterestArray().contains("guitar"));

        CheckBox checkBoxMovies = new CheckBox();
        checkBoxMovies.setFocusTraversable(false);
        HBox hBoxMovies = new HBox(5, checkBoxMovies, new Text("Movies"));
        checkBoxMovies.setSelected(person.getInterestArray().contains("movies"));

        gridPane.add(new Separator(Orientation.HORIZONTAL), 0,5,2,1);
        gridPane.add(new Text("Interests:"), 0, 6);

        gridPane.add(hBoxFootball, 0,7);
        gridPane.add(hBoxMusic,1,7);
        gridPane.add(hBoxFitness,0,8);
        gridPane.add(hBoxReading,1,8);
        gridPane.add(hBoxCooking, 0,9);
        gridPane.add(hBoxRunning, 1,9);
        gridPane.add(hBoxProgramming, 0,10);
        gridPane.add(hBoxSinging, 1,10);
        gridPane.add(hBoxGuitar, 0,11);
        gridPane.add(hBoxMovies, 1,11);


        gridPane.add(new Text("First name:"),0,0);
        gridPane.add(new Text("Last name:"), 0,1);
        gridPane.add(new Text("Email:"),0,2);
        gridPane.add(new Text("Phone number:"),0,3);
        gridPane.add(new Text("Birthday:"),0,4);

        gridPane.add(textFieldFirstName,1,0);
        gridPane.add(textFieldLastName,1,1);
        gridPane.add(textFieldEmail,1,2);
        gridPane.add(textFieldPhoneNumber,1,3);
        gridPane.add(birthdayPicker,1,4);

        AnchorPane anchorPane = new AnchorPane();
        AnchorPane.setLeftAnchor(buttonCancel,45.0);
        AnchorPane.setRightAnchor(buttonEdit,45.0);
        anchorPane.getChildren().addAll(buttonCancel, buttonEdit);


        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setAlignment(gridPane, Pos.CENTER);
        borderPane.setBottom(anchorPane);
        borderPane.setMargin(anchorPane, new Insets(0,0,30,0));


        buttonCancel.setOnAction(e -> editStage.close());

        buttonEdit.setOnAction(e -> {
            person.setFirstName(textFieldFirstName.getText());
            person.setLastName(textFieldLastName.getText());
            person.setEmail(textFieldEmail.getText());
            person.setPhoneNumber((textFieldPhoneNumber.getText()));
            person.setBirthDay(birthdayPicker.getValue());

            ArrayList<String> tempInterestArray = new ArrayList<>();

            if(checkBoxFootball.isSelected()) {
                tempInterestArray.add(InterestContainer.getInterestContainer()[0]);
            }
            if(checkBoxMusic.isSelected()) {
                tempInterestArray.add(InterestContainer.getInterestContainer()[1]);
            }
            if(checkBoxFitness.isSelected()) {
                tempInterestArray.add(InterestContainer.getInterestContainer()[2]);
            }
            if(checkBoxReading.isSelected()) {
                tempInterestArray.add(InterestContainer.getInterestContainer()[3]);
            }
            if(checkBoxCooking.isSelected()) {
                tempInterestArray.add(InterestContainer.getInterestContainer()[4]);
            }
            if(checkBoxRunning.isSelected()) {
                tempInterestArray.add(InterestContainer.getInterestContainer()[5]);
            }
            if(checkBoxProgramming.isSelected()) {
                tempInterestArray.add(InterestContainer.getInterestContainer()[6]);
            }
            if(checkBoxSinging.isSelected()) {
                tempInterestArray.add(InterestContainer.getInterestContainer()[7]);
            }
            if(checkBoxGuitar.isSelected()) {
                tempInterestArray.add(InterestContainer.getInterestContainer()[8]);
            }
            if(checkBoxMovies.isSelected()) {
                tempInterestArray.add(InterestContainer.getInterestContainer()[9]);
            }
            person.setInterestArray(tempInterestArray);


            editStage.close();
        });


        final Scene newScene = new Scene(borderPane, width, height);
        editStage.setScene(newScene);
        editStage.showAndWait();

    }

}

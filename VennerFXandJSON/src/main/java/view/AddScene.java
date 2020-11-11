package view;

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
import logic.ContactList;
import logic.InterestContainer;
import logic.Person;
import view.PopUp.ErrorStage;
import view.PopUp.FriendAddedStage;

import java.time.LocalDate;
import java.util.ArrayList;

public class AddScene {

    public Scene addScene = new Scene(addPane(), ScreenSize.getWidth(), ScreenSize.getHeight());

    private String firstName = null;
    private String lastName = null;

    private BorderPane addPane() {

        String cssLayout = "-fx-border-color: red;" + "-fx-border-width: 2;" + "-fx-border-style: dashed;";

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        TextField textFieldFirstName = new TextField();
        textFieldFirstName.setPromptText("Your first name");
        textFieldFirstName.setMinWidth(200);
        textFieldFirstName.setFocusTraversable(false);

        TextField textFieldLastName = new TextField();
        textFieldLastName.setPromptText("Your last name");
        textFieldLastName.setFocusTraversable(false);

        TextField textFieldEmail = new TextField();
        textFieldEmail.setPromptText("Your email");
        textFieldEmail.setFocusTraversable(false);

        TextField textFieldPhoneNumber = new TextField();
        textFieldPhoneNumber.setPromptText("+45xxxxxxxx");
        textFieldPhoneNumber.setFocusTraversable(false);

        DatePicker birthdayPicker = new DatePicker();
        birthdayPicker.setFocusTraversable(false);
        birthdayPicker.setMinWidth(200);
        birthdayPicker.setValue(LocalDate.of(2000,1,1));


        Button buttonBack = new Button("Back");
        buttonBack.setFocusTraversable(false);
        buttonBack.setPrefWidth(100);

        Button buttonAdd = new Button("Add contact");
        buttonAdd.setFocusTraversable(false);
        buttonAdd.setPrefWidth(100);


        CheckBox checkBoxFootball = new CheckBox();
        checkBoxFootball.setFocusTraversable(false);
        HBox hBoxFootball = new HBox(5, checkBoxFootball, new Text("Football"));

        CheckBox checkBoxMusic = new CheckBox();
        checkBoxMusic.setFocusTraversable(false);
        HBox hBoxMusic = new HBox(5, checkBoxMusic, new Text("Music"));

        CheckBox checkBoxFitness = new CheckBox();
        checkBoxFitness.setFocusTraversable(false);
        HBox hBoxFitness = new HBox(5, checkBoxFitness, new Text("Fitness"));

        CheckBox checkBoxReading = new CheckBox();
        checkBoxReading.setFocusTraversable(false);
        HBox hBoxReading = new HBox(5, checkBoxReading, new Text("Reading"));

        CheckBox checkBoxCooking = new CheckBox();
        checkBoxCooking.setFocusTraversable(false);
        HBox hBoxCooking = new HBox(5, checkBoxCooking, new Text("Cooking"));

        CheckBox checkBoxRunning = new CheckBox();
        checkBoxRunning.setFocusTraversable(false);
        HBox hBoxRunning = new HBox(5, checkBoxRunning, new Text("Running"));

        CheckBox checkBoxProgramming = new CheckBox();
        checkBoxProgramming.setFocusTraversable(false);
        HBox hBoxProgramming = new HBox(5, checkBoxProgramming, new Text("Programming"));

        CheckBox checkBoxSinging = new CheckBox();
        checkBoxSinging.setFocusTraversable(false);
        HBox hBoxSinging = new HBox(5, checkBoxSinging, new Text("Singing"));

        CheckBox checkBoxGuitar = new CheckBox();
        checkBoxGuitar.setFocusTraversable(false);
        HBox hBoxGuitar = new HBox(5, checkBoxGuitar, new Text("Guitar"));

        CheckBox checkBoxMovies = new CheckBox();
        checkBoxMovies.setFocusTraversable(false);
        HBox hBoxMovies = new HBox(5, checkBoxMovies, new Text("Movies"));

        gridPane.add(new Separator(Orientation.HORIZONTAL), 0,5,2,1);
        gridPane.add(new Text("Choose your interests [optional]:"), 0, 6);

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
        AnchorPane.setLeftAnchor(buttonBack,45.0);
        AnchorPane.setRightAnchor(buttonAdd,45.0);
        anchorPane.getChildren().addAll(buttonBack, buttonAdd);


        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setAlignment(gridPane, Pos.CENTER);
        borderPane.setBottom(anchorPane);
        borderPane.setMargin(gridPane, new Insets(30,0,0,0));
        borderPane.setMargin(anchorPane, new Insets(0,0,30,0));


        buttonBack.setOnAction(e -> {
            ScreenSize.setSize(addScene);
            Main.primaryStage.setScene(new TableViewScene().listScene);
        });

        buttonAdd.setOnAction(e -> {
            ScreenSize.setSize(addScene);

            if(textFieldFirstName.getText().isEmpty() || textFieldLastName.getText().isEmpty()) {
                new ErrorStage().errorStage("Can't add a contact, because namefield is empty.");
                return;
            }

            this.firstName = textFieldFirstName.getText();
            this.lastName = textFieldLastName.getText();

            Person person = new Person();
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

            new ContactList().addPerson(person);

            new FriendAddedStage().newStage(person);


            Main.primaryStage.setScene(new TableViewScene().listScene);
        });

        return borderPane;
    }

}

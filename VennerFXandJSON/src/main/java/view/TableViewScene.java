package view;

import data.JSON;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import logic.ContactList;
import logic.Person;
import logic.SearchInterest;
import logic.SearchPerson;
import view.PopUp.DeleteContactStage;
import view.PopUp.EditStage;
import view.PopUp.ErrorStage;
import view.PopUp.ViewProfileStage;


public class TableViewScene {

    public Scene listScene = new Scene(listPane(), ScreenSize.getWidth(), ScreenSize.getHeight());

    private Person selectedPerson = null;
    private TableView<Person> tableView;

    public BorderPane listPane() {

        tableView = new TableView<>();

        String cssLayout = "-fx-border-color: red;" + "-fx-border-width: 2;" + "-fx-border-style: dashed;";

        tableView.setFocusTraversable(false);
        tableView.setMinSize(700,400);
        tableView.setPlaceholder(new Label("No contacts found."));

        TableColumn<Person, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setPrefWidth(120);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Person, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setPrefWidth(120);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Person, String> birthdayColumn = new TableColumn<>("Birthday");
        birthdayColumn.setPrefWidth(120);
        birthdayColumn.setSortable(false);
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));

        TableColumn<Person, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setPrefWidth(200);
        emailColumn.setSortable(false);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Person, String> phoneNumberColumn = new TableColumn<>("Phone number");
        phoneNumberColumn.setPrefWidth(120);
        phoneNumberColumn.setSortable(false);
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        tableView.getColumns().addAll(firstNameColumn,lastNameColumn, birthdayColumn, emailColumn, phoneNumberColumn);

        for(Person person : new ContactList().getContactList()) {
            tableView.getItems().add(person);
        }

        tableView.getSortOrder().addAll(firstNameColumn, lastNameColumn);

        TableView.TableViewSelectionModel<Person> selectionModel = tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);




        TextField textFieldSearch = new TextField();
        textFieldSearch.setFocusTraversable(false);
        textFieldSearch.setPrefWidth(350);
        textFieldSearch.setPromptText("Search...");

        Button buttonSearch = new Button("Search");
        buttonSearch.setMinWidth(100);
        buttonSearch.setFocusTraversable(false);

        Button buttonShowAll = new Button("Show All");
        buttonShowAll.setMinWidth(100);
        buttonShowAll.setFocusTraversable(false);

        ComboBox comboBoxInterests = new ComboBox();
        comboBoxInterests.setMinWidth(100);
        comboBoxInterests.setFocusTraversable(false);
        comboBoxInterests.setTooltip(new Tooltip("Choose interest"));

        ObservableList<String> interests = FXCollections.observableArrayList("None", "Football", "Music", "Fitness", "Reading", "Cooking", "Running", "Programming", "Singing", "Guitar", "Movies");
        comboBoxInterests.getItems().addAll(interests);
        comboBoxInterests.setValue(interests.get(0));


        HBox hBoxSearch = new HBox();
        hBoxSearch.setSpacing(10);
        hBoxSearch.getChildren().setAll(comboBoxInterests, buttonSearch, buttonShowAll);

        AnchorPane anchorPaneSearch = new AnchorPane();
        AnchorPane.setLeftAnchor(textFieldSearch,0.0);
        AnchorPane.setRightAnchor(hBoxSearch,0.0);
        anchorPaneSearch.getChildren().setAll(textFieldSearch, hBoxSearch);

        GridPane gridPaneTableView = new GridPane();
        gridPaneTableView.setAlignment(Pos.CENTER);
        gridPaneTableView.add(anchorPaneSearch,0,0);
        gridPaneTableView.add(tableView,0,1);
        GridPane.setHalignment(tableView, HPos.CENTER);
        GridPane.setMargin(anchorPaneSearch,new Insets(0,0,10,0));



        Button buttonEdit = new Button("Edit");
        buttonEdit.setPrefWidth(100);
        buttonEdit.setFocusTraversable(false);

        Button buttonDelete = new Button("Delete");
        buttonDelete.setPrefWidth(100);
        buttonDelete.setFocusTraversable(false);

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().setAll(buttonEdit,buttonDelete);

        AnchorPane anchorPane = new AnchorPane();
        AnchorPane.setRightAnchor(hBox,50.0);
        anchorPane.getChildren().addAll(hBox);
        anchorPane.setMinWidth(800);

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        menuBar.setMinWidth(100);
        menuBar.setOnMouseDragEntered(e -> menu.show());

        MenuItem menuAddFriend = new MenuItem("Add friend");
        menuAddFriend.setStyle("-fx-pref-width: 100;");
        MenuItem menuSaveFile = new MenuItem("Save file");
        MenuItem menuExitProgram = new MenuItem("Exit");

        menu.getItems().addAll(menuAddFriend, new SeparatorMenuItem(), menuSaveFile, new SeparatorMenuItem(), menuExitProgram);


        menuBar.getMenus().add(menu);

        menuAddFriend.setOnAction(e -> {
            ScreenSize.setSize(listScene);
            Main.primaryStage.setScene(new AddScene().addScene);
        });
        menuSaveFile.setOnAction(e -> new JSON().saveList());
        menuExitProgram.setOnAction(e -> {
            new JSON().saveList();
            Main.primaryStage.close();
        });


        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);

        borderPane.setCenter(gridPaneTableView);
        BorderPane.setAlignment(gridPaneTableView, Pos.CENTER);

        borderPane.setBottom(anchorPane);
        BorderPane.setAlignment(anchorPane, Pos.CENTER);
        BorderPane.setMargin(anchorPane, new Insets(30,0,30,0));



        buttonEdit.setOnAction(e -> {

            try {
                new EditStage().editStage(tableView.getSelectionModel().getSelectedItem());
            } catch (Exception ex) {
                new ErrorStage().errorStage("You need to select a person, to use this function");
            }

            tableView.refresh();
            tableView.getSortOrder().addAll(firstNameColumn, lastNameColumn);
            borderPane.requestFocus();
        });

        buttonDelete.setOnAction(e -> {
            try {
                this.selectedPerson = tableView.getSelectionModel().getSelectedItem();
                new DeleteContactStage().deleteStage(tableView.getSelectionModel().getSelectedItem(), tableView);
            } catch (NullPointerException ex) {
                new ErrorStage().errorStage("You need to select a person, to use this function");
            }
            borderPane.requestFocus();
        });

        buttonShowAll.setOnAction(e -> {
            tableView.getItems().clear();
            for(Person person : new ContactList().getContactList()) {
                tableView.getItems().add(person);
            }
            tableView.getSortOrder().addAll(firstNameColumn, lastNameColumn);
            textFieldSearch.clear();
            borderPane.requestFocus();
            comboBoxInterests.setValue(interests.get(0));

        });

        buttonSearch.setOnAction(e -> {

            if (textFieldSearch.getText().isEmpty() && comboBoxInterests.getValue().toString().equals("None")) {
                tableView.getItems().clear();
                for (Person person : new ContactList().getContactList()) {
                    tableView.getItems().add(person);
                }
                tableView.getSortOrder().addAll(firstNameColumn, lastNameColumn);
                borderPane.requestFocus();
            }

            if (!textFieldSearch.getText().isEmpty() && comboBoxInterests.getValue().toString().equals("None")) {
                tableView.getItems().clear();
                for(Person person : new SearchPerson().search(textFieldSearch.getText(), new ContactList().getContactList())) {
                    tableView.getItems().add(person);
                    tableView.getSortOrder().addAll(firstNameColumn, lastNameColumn);
                    borderPane.requestFocus();
                }
            }

            if (textFieldSearch.getText().isEmpty() && !comboBoxInterests.getValue().toString().equals("None")) {
                tableView.getItems().clear();
                for(Person person : new SearchInterest().searchInterest(comboBoxInterests.getValue().toString())) {
                    tableView.getItems().add(person);
                    tableView.getSortOrder().addAll(firstNameColumn, lastNameColumn);
                    borderPane.requestFocus();
                }
            }

            if (!textFieldSearch.getText().isEmpty() && !comboBoxInterests.getValue().toString().equals("None")) {
                tableView.getItems().clear();
                for(Person person : new SearchPerson().search(textFieldSearch.getText(), new SearchInterest().searchInterest(comboBoxInterests.getValue().toString()))) {
                    tableView.getItems().add(person);
                    tableView.getSortOrder().addAll(firstNameColumn, lastNameColumn);
                    borderPane.requestFocus();
                }
            }

        });


        ContextMenu contextMenu = new ContextMenu();
        contextMenu.setStyle("-fx-background-color: #ECEDEE;");

        MenuItem menuItemEditPerson = new MenuItem("Edit");
        menuItemEditPerson.setStyle("-fx-pref-width: 90;");
        MenuItem menuItemDeletePerson = new MenuItem("Delete");

        contextMenu.getItems().addAll(menuItemEditPerson, new SeparatorMenuItem(), menuItemDeletePerson);

        menuItemEditPerson.setOnAction(e -> {
            new EditStage().editStage(tableView.getSelectionModel().getSelectedItem());
            tableView.refresh();
            tableView.getSortOrder().addAll(firstNameColumn, lastNameColumn);
            borderPane.requestFocus();
        });
        menuItemDeletePerson.setOnAction(e -> {
            new DeleteContactStage().deleteStage(tableView.getSelectionModel().getSelectedItem(), tableView);
            borderPane.requestFocus();
        });


        tableView.setRowFactory(e -> {
            TableRow<Person> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) && event.getButton() == MouseButton.PRIMARY) {
                    Person person = row.getItem();
                    new ViewProfileStage().viewProfileStage(person);
                }
                if (event.getButton() == MouseButton.SECONDARY) {
                    row.setContextMenu(contextMenu);
                }
            });
            return row;
        });


        return borderPane;
    }
}

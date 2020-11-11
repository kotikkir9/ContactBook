module VennerFXandJSON {

    requires javafx.fxml;
    requires javafx.controls;
    requires com.fasterxml.jackson.databind;

    opens view;
    opens logic;
    opens data;
}
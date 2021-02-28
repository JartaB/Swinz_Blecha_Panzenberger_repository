package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML private ChoiceBox cas_choice;
    @FXML private ChoiceBox zavada_choice;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeCas();
        initializeZavada();
    }
    public void initializeCas(){
        cas_choice.getItems().add("9:00");
        cas_choice.getItems().add("9:30");
        cas_choice.getItems().add("10:00");
        cas_choice.getItems().add("10:30");
        cas_choice.getItems().add("11:00");
        cas_choice.getItems().add("11:30");
        cas_choice.getItems().add("12:00");
        cas_choice.getItems().add("12:30");
        cas_choice.getItems().add("13:00");
        cas_choice.getItems().add("13:30");
        cas_choice.getItems().add("14:00");
        cas_choice.getItems().add("14:30");
        cas_choice.getItems().add("15:00");
        cas_choice.getItems().add("15:30");
        cas_choice.getItems().add("16:00");
        cas_choice.getItems().add("16:30");
        cas_choice.getItems().add("17:00");
        cas_choice.getItems().add("17:30");

    }
    public void initializeZavada(){
        zavada_choice.getItems().add("Výfuk");
        zavada_choice.getItems().add("Řízení");
        zavada_choice.getItems().add("Brzdy");
        zavada_choice.getItems().add("Karoserie");
    }


}

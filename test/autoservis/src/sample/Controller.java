package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML private ChoiceBox cas_choice;
    @FXML private ChoiceBox zavada_choice;
    @FXML private Button obj_button;
    @FXML private TextField name_field;
    @FXML private TextField spz_field;
    @FXML private TextField phone_field;
    @FXML private DatePicker date_picker;
    Database database=new Database();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeCas();
        initializeZavada();
        database.connect();
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
    public void insertNewCustomer(){
        int id=3;
        String name =name_field.getCharacters().toString();
        String datetime=date_picker.getValue().toString() + " " +cas_choice.getValue().toString();
        String typeOfProblem=zavada_choice.getValue().toString();
        String spz=spz_field.getCharacters().toString();
        String phone=phone_field.getCharacters().toString();
        database.insert(id,name,datetime,phone,spz,typeOfProblem);
    }

}

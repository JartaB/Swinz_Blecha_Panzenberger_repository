package guiAddPack;

import guiListPack.DatAlertBox;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Database;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AddController implements Initializable {
    @FXML private ChoiceBox cas_choice;
    @FXML private ChoiceBox zavada_choice;
    @FXML private Button obj_button;
    @FXML private TextField name_field;
    @FXML private TextField spz_field;
    @FXML private TextField phone_field;
    @FXML private DatePicker date_picker;
    @FXML private Label name_label;
    @FXML private Label phone_label;
    @FXML private Label spz_label;
    Database database=new Database();
    private Scene scene;
    private Stage stage;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeCas();
        initializeZavada();
        database.connect("select * from objednani");
        name_field.textProperty().addListener( (observable, oldValue, newValue) -> {
            if(newValue.length()>60){
                name_label.setText("Moc znaků!");
                name_label.setVisible(true);
            }
            else if(newValue.matches("[0-9]*")){
                name_label.setText("Nepiš mi tu čísla!");
                name_label.setVisible(true);
            }
            else name_label.setVisible(false);
            if (newValue.isEmpty()) name_label.setVisible(false);
                });
        phone_field.textProperty().addListener( (observable, oldValue, newValue) -> {
            if(newValue.matches("[a-z]*")){
                phone_label.setText("Pouze čísla!");
                phone_label.setVisible(true);
            }
            else if(newValue.length()>9){
                phone_label.setText("Maximum 9 čísel");
                phone_label.setVisible(true);
            }
            if(newValue.isEmpty()) {
                phone_label.setVisible(false);
            }
        });
        spz_field.textProperty().addListener( (observable, oldValue, newValue) -> {
            if(newValue.length()>8){
                spz_label.setText("Maximum 8 znaků!");
                spz_label.setVisible(true);
            }
            else spz_label.setVisible(false);
            if(newValue.isEmpty()) spz_label.setVisible(false);
        });
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
    public boolean checkDate(){
        String datetime=date_picker.getValue().toString() + " " +cas_choice.getValue().toString()+":00";
        if(database.checkDate(datetime)>=1) return true;
        else return false;

    }
    public void insertNewCustomer(){
        String name =name_field.getCharacters().toString();
        String datetime=date_picker.getValue().toString() + " " +cas_choice.getValue().toString();
        String typeOfProblem=zavada_choice.getValue().toString();
        String spz=spz_field.getCharacters().toString();
        String phone=phone_field.getCharacters().toString();
        if(checkDate()){
            DatAlertBox.display("Chyba", "Na tento čas už je někdo objednaný");
        }
        else if(!checkDate()) {
            database.insert(name, datetime, phone, spz, typeOfProblem);
        }
    }


    public void switchToList(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../guiListPack/Gui_List.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAdd(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../guiAddPack/Gui_Add.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToHome(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../guiHomePack/Gui_Home.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}


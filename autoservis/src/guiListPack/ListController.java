package guiListPack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Database;
import sample.Record;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ListController implements Initializable {
    private Scene scene;
    private Stage stage;
    @FXML
    private TableView<Record> table;
    @FXML
    private TableColumn<Record, String> col_id;
    @FXML
    private TableColumn<Record, String> col_name;
    @FXML
    private TableColumn<Record, String> col_date;
    @FXML
    private TableColumn<Record, String> col_phone;
    @FXML
    private TableColumn<Record, String> col_spz;
    @FXML
    private TableColumn<Record, String> col_problem;

    ObservableList<Record> oblist = FXCollections.observableArrayList();


    @Override
    public void initialize (URL location, ResourceBundle resources){
        try {
            Connection con = Database.getConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from objednani");
            while (rs.next()){
                oblist.add(new Record(rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getString("phone"),
                        rs.getString("spz"),
                        rs.getString("typeofproblem")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            DatAlertBox.display("Chyba","Nepodařilo se připojit k databázi");
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        col_spz.setCellValueFactory(new PropertyValueFactory<>("spz"));
        col_problem.setCellValueFactory(new PropertyValueFactory<>("problem"));

        table.setItems(oblist);
    }

    public void switchToList(ActionEvent event) throws IOException{
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

package sample;

import guiListPack.DatAlertBox;
import guiListPack.ListController;

import java.sql.*;

public class Database {

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static String url = "jdbc:mysql://localhost:3306/autoservis";
    private static String user = "root";
    private static String pass = "";

    public void connect(String s) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(s);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            DatAlertBox.display("Chyba", "Nepodařilo se připojit k databázi");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insert(String name, String datetime, String phone, String spz, String typeOfProblem) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();
            PreparedStatement post = connection.prepareStatement("INSERT INTO objednani (name, date, phone, spz, typeofproblem) " +
                    " VALUES ('" + name + "','" + datetime + "','" + phone + "','" + spz + "','" + typeOfProblem + "')");
            post.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            DatAlertBox.display("Chyba", "Nepodařilo se připojit k databázi");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url,user,pass);
        return connection;
    }
    public int checkDate(String datetime){
        int count=0;
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, user, pass);
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT date FROM objednani");
            while (resultSet.next()) {
                if (resultSet.getString(1).equals(datetime)){
                   count++;
                }
            }

        } catch (SQLException throwables) {
        throwables.printStackTrace();
        DatAlertBox.display("Chyba", "Nepodařilo se připojit k databázi");
        } catch (ClassNotFoundException e) {
        e.printStackTrace();
        }
        return count;
    }


}


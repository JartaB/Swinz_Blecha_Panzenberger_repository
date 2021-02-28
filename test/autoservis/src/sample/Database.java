package sample;

import java.sql.*;

public class Database {

    private static Connection connect = null;
    private static Statement statement = null;
    private static ResultSet resultSet =null;
    private static String url = "jdbc:mysql://localhost:3306/autoservis";
    private static String user = "root";
    private static String pass = "";

    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url,user,pass);
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from objednani");
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String datetime = resultSet.getString(3);
                String phone = resultSet.getString(4);
                String spz = resultSet.getString(5);
                String typeOfProblem = resultSet.getString(6);

                System.out.println(id + " | " + name + " | " + datetime + " | " + phone + " | " + spz + " | " + typeOfProblem);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void insert(int id,String name,String datetime,String phone,String spz,String typeOfProblem){
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connect = DriverManager.getConnection(url,user,pass);
        statement = connect.createStatement();
        PreparedStatement post = connect.prepareStatement("INSERT INTO objednani (id, name, date, phone, spz, typeofproblem) " +
                " VALUES ('"+id+"', '"+name+"','"+datetime+"','"+phone+"','"+spz+"','"+typeOfProblem+"')");
        post.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    }


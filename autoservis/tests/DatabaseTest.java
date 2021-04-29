import org.junit.jupiter.api.Test;
import sample.Database;


import java.sql.*;


import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String url = "jdbc:mysql://localhost:3306/autoservis";
    String user = "root";
    String pass = "";

    @Test
    void getConnectionTest() throws SQLException {
        Connection connection = Database.getConnection();
        assertEquals(connection != null, true);
    }

    @Test
    void dataNotEmpty() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from objednani");
            while (resultSet.next()) {
                assertEquals(resultSet.getString("name") != null, true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
package sample;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaPostgreSql {

    public static void writeToDatabase(String userName, String userEmail, String userPassword) {

        String url = "jdbc:postgresql://localhost:5432/javafx";
        String user = "YOUR USERNAME";
        String password = "YOUR PASSWORD";

        String name = userName;
        String email= userEmail;
        String pass = userPassword;

        // query
        String query = "INSERT INTO worker(name, email, password) VALUES(?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, pass);
            pst.executeUpdate();
            System.out.println("Sucessfully created.");

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JavaPostgreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }
}

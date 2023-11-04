package edu.upvictoria.poo.Lib;

import edu.upvictoria.poo.Lib.Factories.Patient;
import edu.upvictoria.poo.Lib.Factories.PatientFactory;

import java.sql.*;
import java.util.HashMap;
import java.util.UUID;

public class PatientRepository implements UserUtils {
    private final String DB_PATH;

    public PatientRepository(String DB_PATH) {
        this.DB_PATH = DB_PATH;
    }

    private Connection connect() {
        String url = "jdbc:sqlite:" + DB_PATH;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    @Override
    public void addUser(User user) {
        var id = user.getUUID();
        var firstName = user.getFirstName();
        var lastName = user.getLastName();
        var username = user.getUsername();
        var password = user.getPassword();
        var phoneNumber = user.getPhoneNumber();
        var sql = "INSERT INTO USERS (first_name, last_name, username, password, phone_number, user_type)" +
                "VALUES (" + firstName + "," + lastName + "," + phoneNumber + "," + username + ")";
        try (var conn = this.connect();
             var statement = conn.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public User searchUser(String UUID) {
        try (var statement = this.connect().createStatement()) {
            ResultSet usersResult = statement.executeQuery("SELECT * FROM USERS WHERE user_id = " + UUID);
            ResultSet medCondResult = statement.executeQuery("SELECT * FROM PATIENTS WHERE user_id = " + UUID);
            var userId = usersResult.getString("user_id");
            var firstName = usersResult.getString("first_name");
            var lastName = usersResult.getString("last_name");
            var username = usersResult.getString("username");
            var password = usersResult.getString("password");
            var phoneNumber = usersResult.getString("phone_number");
            var factory = new PatientFactory();
            return factory.createUser(userId, firstName, lastName, username, password, phoneNumber);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteUser(String UUID) {
        try (PreparedStatement statement = connect().prepareStatement(
                "DELETE FROM USERS WHERE user_id = ?;" +
                        "DELETE FROM APPOINTMENTS WHERE user_id = ?;" +
                        "DELETE FROM PATIENTS WHERE user_id = ?;"
        )) {
            for (var i = 1; i < 4; i++) {
                statement.setString(i,UUID);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateUser(User user, String UUID) {
        try (var statement = connect().prepareStatement(
                "UPDATE USERS SET first_name = ?, last_name = ?, username = ?, password = ?, phone_number = ? WHERE user_id = " + UUID
        )) {
            statement.setString(1,user.getFirstName());
            statement.setString(2,user.getLastName());
            statement.setString(3,user.getUsername());
            statement.setString(4,user.getPassword());
            statement.setString(5,user.getPhoneNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        var test = new PatientRepository("src/main/resources/main.db");
        var user = new Patient("1","Juan","Martinez","123123","juanito","123");
        test.updateUser(user,"1");
    }
}
package edu.upvictoria.poo.Lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class UserRepository {
    private final String DB_PATH;

    public UserRepository(String path) {
        this.DB_PATH = path;
    }

    private Connection connect() throws SQLException {
        var url = "jdbc:sqlite:" + this.DB_PATH;
        return DriverManager.getConnection(url);
    }

    public void addUser(User user) throws SQLException {
        var id = user.getUUID();
        var firstName = user.getFirstName();
        var lastName = user.getLastName();
        var username = user.getUsername();
        var password = user.getPassword();
        var phoneNumber = user.getPhoneNumber();
        var statement = this.connect().prepareStatement( "INSERT INTO USERS (first_name, last_name, username, password, phone_number,user_type) " + "VALUES (?,?,?,?,?,?)");
        statement.setString(1,firstName);
        statement.setString(2,lastName);
        statement.setString(3,username);
        statement.setString(4,password);
        statement.setString(5,phoneNumber);
        statement.setString(6,"patient");
        statement.executeUpdate();
    }
}

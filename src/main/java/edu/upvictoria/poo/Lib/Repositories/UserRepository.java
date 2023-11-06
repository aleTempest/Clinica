package edu.upvictoria.poo.Lib.Repositories;

import edu.upvictoria.poo.Lib.User;

import java.sql.*;
import java.util.ArrayList;

public abstract class UserRepository <T extends User>{
    private final String DB_PATH;

    public UserRepository(String path) {
        this.DB_PATH = path;
    }

    private Connection connect() throws SQLException {
        var url = "jdbc:sqlite:" + this.DB_PATH;
        return DriverManager.getConnection(url);
    }

    private void setStatement(T user, PreparedStatement statement) throws SQLException {
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getUsername());
        statement.setString(4, user.getPassword());
        statement.setString(5, user.getPhoneNumber());
        statement.setString(6, user.getType());
        statement.setString(7, user.getZipcode());
        statement.setString(8, user.getAddress1());
        statement.setString(9, user.getAddress2());
    }

    public void addUser(T user) throws SQLException {
        var statement = this.connect().prepareStatement( "INSERT INTO USERS" +
                " (first_name,last_name,username,password,phone_number,user_type,zipcode,address1,address2) " +
                " VALUES (?,?,?,?,?,?,?,?,?)");
        setStatement(user,statement);
        statement.executeUpdate();
    }

    public String searchUsername(String str) throws SQLException {
        var statement = this.connect().createStatement();
        var result = statement.executeQuery("SELECT * FROM USERS WHERE username = " + str);
        return result.getString("user_id");
    }

    public void update(T user) throws SQLException {
        var statement = this.connect().prepareStatement("UPDATE USERS SET " +
                "first_name = ?,last_name = ?,username = ?,password = ?,phone_number = ?,user_type = ?,zipcode = ?," +
                "address1 = ?,address2 = ?" +
                "WHERE user_id = ?"
        );
        setStatement(user,statement);
        statement.setString(10,user.getUUID());
        statement.executeUpdate();
    }

    public abstract void deleteUser(T user);
    public abstract ArrayList<T> getUsers();

}
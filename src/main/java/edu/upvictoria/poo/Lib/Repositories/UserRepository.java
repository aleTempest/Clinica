package edu.upvictoria.poo.Lib.Repositories;

import edu.upvictoria.poo.Lib.User;
import edu.upvictoria.poo.Lib.UserFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class UserRepository <T extends User>{
    private final String DB_PATH;

    public UserRepository(String path) {
        this.DB_PATH = path;
    }

    protected Connection connect() throws SQLException {
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

    public void deleteUser(T user) throws SQLException {
        var id = user.getUUID();
        var pragmaStatement = this.connect().createStatement();
        var statement = this.connect().prepareStatement("DELETE FROM USERS WHERE user_id = ?");
        pragmaStatement.executeUpdate("PRAGMA foreign_keys=ON;");
        statement.setString(1,user.getUUID());
        statement.executeUpdate();
    }

    public <T> List<T> getUsers(String type) throws SQLException {
        List<T> arr = new ArrayList<>();
        var sql = "SELECT * FROM USERS_STAFF_VIEW WHERE user_type = ?";

        var connection = this.connect();
        var statement = connection.prepareStatement(sql);
        statement.setString(1, type);
        var result = statement.executeQuery();

        while (result.next()) {
            var id = result.getString("user_id");
            var first_name = result.getString("first_name");
            var last_name = result.getString("last_name");
            var username = result.getString("username");
            var password = result.getString("password");
            var zipcode = result.getString("zipcode");
            var address1 = result.getString("address1");
            var address2 = result.getString("address2");
            var phone_number = result.getString("phone_number");
            var CURP = result.getString("CURP");
            var RFC = result.getString("RFC");
            var salary = result.getFloat("salary");

            if (type.equals("DOCTOR")) {
                arr.add((T) UserFactory.createDoctor(id, first_name, last_name, phone_number, username, password, address1, address2, zipcode, salary, CURP, RFC));
            } else if (type.equals("PATIENT")) {
                arr.add((T) UserFactory.createPatient(id, first_name, last_name, phone_number, username, password, type));
            }
        }


        return arr;
    }
}
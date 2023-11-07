package edu.upvictoria.poo.Lib;

import edu.upvictoria.poo.Lib.Repositories.UserRepository;

import java.sql.SQLException;

public class Session extends UserRepository {
    private String type;
    public Session(String path) {
        super(path);
        this.type = "";
    }

    public boolean auth(String username, String password) throws SQLException {
        var statement = this.connect().prepareStatement("SELECT username, password, user_type FROM USERS WHERE username = ? AND password = ?");
        statement.setString(1,username);
        statement.setString(2,password);
        var result = statement.executeQuery();
        this.type = result.getString("user_type"); // set type for gui usage
        return result.getString("username").equals(username) && result.getString("password").equals(password);
    }

    public static void main(String[] args) {
        var test = new Session("src/main/resources/main.db");
        try {
            System.out.println(test.auth("amartinez","password123"));
            System.out.println(test.type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

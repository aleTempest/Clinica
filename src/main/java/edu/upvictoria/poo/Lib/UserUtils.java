package edu.upvictoria.poo.Lib;

import java.util.HashMap;

public interface UserUtils {
    void addUser(User user);
    User searchUser(String UUID);
    void deleteUser(String UUID);
    void updateUser(User user, String UUID);
}

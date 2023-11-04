package edu.upvictoria.poo.Lib.Factories;

import edu.upvictoria.poo.Lib.User;

public interface UserFactory {
    User createUser(String UUID, String firstName, String lastName, String phoneNumber, String username, String password);
}

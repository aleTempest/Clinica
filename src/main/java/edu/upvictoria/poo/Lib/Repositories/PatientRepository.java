package edu.upvictoria.poo.Lib.Repositories;

import edu.upvictoria.poo.Lib.User;

import java.util.ArrayList;

public class PatientRepository extends UserRepository {
    public PatientRepository(String path) {
        super(path);
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public ArrayList getUsers() {
        return null;
    }
}

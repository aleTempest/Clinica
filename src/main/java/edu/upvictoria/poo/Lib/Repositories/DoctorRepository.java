package edu.upvictoria.poo.Lib.Repositories;

import edu.upvictoria.poo.Lib.User;

import java.util.ArrayList;

public class DoctorRepository extends UserRepository {
    public DoctorRepository(String path) {
        super(path);
    }

    @Override
    public ArrayList getUsers() {
        return null;
    }
}

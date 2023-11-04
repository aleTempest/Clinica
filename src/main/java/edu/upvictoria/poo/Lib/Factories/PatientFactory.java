package edu.upvictoria.poo.Lib.Factories;

public class PatientFactory implements UserFactory {
    @Override
    public Patient createUser(String UUID, String firstName, String lastName, String phoneNumber, String username, String password) {
        return new Patient(UUID,firstName,lastName,phoneNumber,username,password);
    }
}

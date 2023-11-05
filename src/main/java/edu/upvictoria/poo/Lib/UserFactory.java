package edu.upvictoria.poo.Lib;

public class UserFactory {
    public static User createDoctor(String UUID, String firstName, String lastName, String phoneNumber, String username, String password,
                                   String address1, String address2, String zipcode, String degree, Float salary, String field,
                                   String CURP, String RFC, String area) {
        return new Doctor(UUID, firstName, lastName, phoneNumber, username, password, address1, address2, zipcode, degree, salary, field, CURP, RFC, area);
    }

    public static User createPatient(String UUID, String firstName, String lastName, String phoneNumber, String username, String password) {
        return new Patient(UUID, firstName, lastName, phoneNumber, username, password);
    }
}

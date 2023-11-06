package edu.upvictoria.poo.Lib;

public class UserFactory {
    public static Doctor createDoctor(String UUID, String firstName, String lastName, String phoneNumber, String username, String password,
                                   String address1, String address2, String zipcode, Float salary,String CURP, String RFC) {
        return new Doctor(UUID, firstName, lastName, phoneNumber, username, password, address1, address2, zipcode,"DOCTOR",salary,CURP, RFC);
    }

    public static Patient createPatient(String UUID, String firstName, String lastName, String phoneNumber, String username, String password, String type) {
        return new Patient(UUID, firstName, lastName, phoneNumber, username, password,type);
    }
}

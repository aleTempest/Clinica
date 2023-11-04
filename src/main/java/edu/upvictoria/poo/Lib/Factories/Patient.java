package edu.upvictoria.poo.Lib.Factories;

import edu.upvictoria.poo.Lib.PatientObjects.Appointment;
import edu.upvictoria.poo.Lib.PatientObjects.Prescription;
import edu.upvictoria.poo.Lib.User;

import java.util.ArrayList;

public class Patient extends User {
    private ArrayList<Appointment> appointments;
    private ArrayList<Prescription> prescriptions;
    public Patient(String UUID, String firstName, String lastName, String phoneNumber, String username, String password) {
        super(UUID, firstName, lastName, phoneNumber, username, password);
        this.appointments = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(ArrayList<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

}

package edu.upvictoria.poo.Lib.PatientObjects;

import java.time.LocalDate;

public class Appointment {
    private LocalDate dueDate;
    private Integer doctorId;

    public Appointment(String dueDate, Integer doctorId, String description) {
        this.dueDate = LocalDate.parse(dueDate);
        this.doctorId = doctorId;
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;
}

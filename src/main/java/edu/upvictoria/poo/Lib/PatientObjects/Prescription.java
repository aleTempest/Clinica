package edu.upvictoria.poo.Lib.PatientObjects;

import java.util.ArrayList;

public class Prescription {
    private String description;
    private ArrayList<Medicine> medicineList;

    public Prescription(String description) {
        this.description = description;
        this.medicineList = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(ArrayList<Medicine> medicineList) {
        this.medicineList = medicineList;
    }

}

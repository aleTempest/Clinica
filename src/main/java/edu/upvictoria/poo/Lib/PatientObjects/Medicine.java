package edu.upvictoria.poo.Lib.PatientObjects;

import java.time.LocalDate;

class Medicine {
    private Float grams;
    private String name;
    private LocalDate expDate;

    public Float getGrams() {
        return grams;
    }

    public void setGrams(Float grams) {
        this.grams = grams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public Medicine(Float grams, String name, LocalDate expDate) {
        this.grams = grams;
        this.name = name;
        this.expDate = expDate;
    }
}

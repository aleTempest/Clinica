package edu.upvictoria.poo.Lib;

public abstract class Staff extends User {

    protected String degree;
    protected Float salary;
    protected final String CURP;
    protected String RFC;

    public Staff(String UUID, String firstName, String lastName, String phoneNumber, String username, String password, String address1, String address2, String zipcode, String type, Float salary, String CURP, String RFC) {
        super(UUID, firstName, lastName, phoneNumber, username, password, address1, address2, zipcode, type);
        this.salary = salary;
        this.CURP = CURP;
        this.RFC = RFC;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getCURP() {
        return CURP;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    @Override
    public String toString() {
        return super.toString() + "," + salary + "," + CURP + "," + RFC;
    }
}

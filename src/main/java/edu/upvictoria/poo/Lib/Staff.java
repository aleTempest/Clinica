package edu.upvictoria.poo.Lib;

public abstract class Staff extends User {


    protected String degree;
    protected Float salary;
    protected String field;
    protected final String CURP;
    protected String RFC;
    protected String area;

    public Staff(String UUID, String firstName, String lastName, String phoneNumber, String username, String password, String address1, String address2, String zipcode, String type, String degree, Float salary, String field, String CURP, String RFC, String area) {
        super(UUID, firstName, lastName, phoneNumber, username, password, address1, address2, zipcode, type);
        this.degree = degree;
        this.salary = salary;
        this.field = field;
        this.CURP = CURP;
        this.RFC = RFC;
        this.area = area;
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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}

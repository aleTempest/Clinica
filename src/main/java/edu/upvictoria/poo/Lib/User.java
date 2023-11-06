package edu.upvictoria.poo.Lib;

public abstract class User {
    protected String UUID;
    protected String firstName;
    protected String lastName;
    protected String zipcode;
    protected String address1;
    protected String address2;
    protected String phoneNumber;
    protected String username;
    protected String password;
    protected String type;

    public User(String UUID, String firstName, String lastName, String phoneNumber, String username, String password, String type) {
        this.UUID = UUID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.type = type;
        this.address1 = "";
        this.address2 = "";
        this.zipcode = "";
    }

    @Override
    public String toString() {
        return UUID + "," + firstName + "," + lastName + "," + phoneNumber + "," + username + "," + password + "," +
                "," + type + "," + address1 + "," + address2 + "," + zipcode;
    }

    public User(String UUID, String firstName, String lastName, String phoneNumber, String username, String password,
                String address1, String address2, String zipcode, String type) {
        this(UUID, firstName, lastName, phoneNumber, username, password,type);
        this.address1 = address1;
        this.address2 = address2;
        this.zipcode = zipcode;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

}

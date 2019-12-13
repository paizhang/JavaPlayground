package javabasics.oop.constructor;

public class Account {

    private String ID;
    private String name;
    private String address;
    private double balance;

    public Account() {
        // Setting default values for name and address in case no values specified in the beginning.
        this("Default name", "Default address");
    }

    public Account(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

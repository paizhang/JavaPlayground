package javabasics.oop.constructor;

public class Account {

    private String ID;
    private String name;
    private String address;
    private double balance;

    public Account() {
        // Setting default values for name and address in case no values specified in the beginning.
        // this() can only be used in a constructor for calling other constructors in the same class. And it has to be
        // the first line in the constructor.
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

    /*
        There are two reasons for using Getter and Setter instead of using the variables directly
        1. For encapsulation purpose.
        2. We can add some logics to help verify the input values. Also we can organize the output values.
     */
    public void setName(String name) {
        if (name.length() < 50) {
            this.name = name;
        }
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

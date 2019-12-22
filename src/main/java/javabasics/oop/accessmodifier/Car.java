package javabasics.oop.accessmodifier;

public class Car {

    // Member that defined as private can only be accessed by members within the same class.
    private String name;

    /*
    Members without any access modifiers are by default defined as "default". default members can only be accessed by
    classes within same package.
    */
    int price;


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /*
        Protected members can only accessed by members within the same package and its subclasses.
     */
    protected void drive() {
        System.out.println("Car is driving...");
    }
}

package javabasics.oop.polymorphism;

public class Benz extends Car {

    public Benz(String name, String model, String color) {
        super(name, model, color);
    }

    @Override
    public void drive() {
        System.out.println("Drive Benz.");
    }
}

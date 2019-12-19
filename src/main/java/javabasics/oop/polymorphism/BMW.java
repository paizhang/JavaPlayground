package javabasics.oop.polymorphism;

public class BMW extends Car {

    public BMW(String name, String model, String color) {
        super(name, model, color);
    }

    @Override
    public void drive() {
        System.out.println("Drive BMW.");
    }
}

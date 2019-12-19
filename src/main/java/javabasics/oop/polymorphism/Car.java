package javabasics.oop.polymorphism;

public class Car {

    private String name;
    private String model;
    private String color;

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Car(String name, String model, String color) {
        this.name = name;
        this.model = model;
        this.color = color;
    }

    public void drive() {
        System.out.println("Drive Car.");
    }
}

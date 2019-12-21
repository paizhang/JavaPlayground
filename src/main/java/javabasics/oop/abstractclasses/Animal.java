package javabasics.oop.abstractclasses;

/*
    When to use abstract classes:
    1. When we want to have a base class that implements partial methods that are shared by subclasses.
    2. abstract class is a IS-A type relationship.
 */
public abstract class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat();

    public abstract void sleep();
}

package javabasics.functionalinterfaces;

public interface FunctionalInterface2 {

    public void method();

    // Interfaces can contain implemented static methods.
    public static void staticMethod() {
        System.out.println("This is a static method within a functional interface. It can has implementation. ");
    }

    // https://www.geeksforgeeks.org/default-methods-java
    // Before Java 8, interfaces can only contain abstract methods. After Java 8, interfaces can have implemented methods
    // which are declared as default methods using a default keyword.
    public default void defaultMethod() {
        System.out.println("This is the default method within a functional interface. It can has implementation. ");
    }
}

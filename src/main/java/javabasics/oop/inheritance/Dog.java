package javabasics.oop.inheritance;

public class Dog extends Animal {

    private int eyes;
    private int legs;
    private int tail;

    public Dog(String name, int height, int size, int eyes, int legs, int tail) {
        // For inheritance, we have to initialize the father class by calling the father constructor using super keyword.
        super(name, 1, 1, height, size);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
    }

    @Override
    public void eat() {
        // super can be used to call the method in the parent class. Otherwise, it can end up as a recursive call.
        super.eat();
        System.out.println("Override eat method called. ");
    }

    public int getEyes() {
        return eyes;
    }

    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

}

package javabasics.oop.inheritance;

public class Animal {

    private String name;
    private int brain;
    private int body;
    private int height;
    private int size;

    public Animal(String name, int brain, int body, int height, int size) {
        this.name = name;
        this.brain = brain;
        this.body = body;
        this.height = height;
        this.size = size;
    }

    public void eat() {
        System.out.println("Animal eat() called.");
    }

    public void move() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBrain() {
        return brain;
    }

    public void setBrain(int brain) {
        this.brain = brain;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

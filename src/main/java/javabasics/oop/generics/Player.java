package javabasics.oop.generics;

public abstract class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract void play();

    public String getName() {
        return name;
    }
}

package javabasics.oop.generics;

public class BaseballPlayer extends Player {

    public BaseballPlayer(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("Playing baseball.");
    }
}

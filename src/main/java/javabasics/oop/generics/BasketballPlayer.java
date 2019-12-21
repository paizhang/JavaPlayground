package javabasics.oop.generics;

public class BasketballPlayer extends Player {

    public BasketballPlayer(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("Playing basketball.");
    }
}

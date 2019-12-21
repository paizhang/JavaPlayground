package javabasics.oop.generics;

public class FootballPlayer extends Player {

    public FootballPlayer(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("Playing football.");
    }
}

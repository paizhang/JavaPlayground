package javabasics.oop.generics;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Player> {

    private String name;

    /*
        By specifying Player as the type of item, any subclasses that inherit Player can be add to the list regardless
        of their types. For instance, a team can have basketball players, baseball players and football players together.
        This does not make sense. We want a team that contains same type of player. Every time a player with unmatched
        type is added, we want an error to be thrown at compile time.

        One way to implement that is to create teams with different subtypes. But this will produce lot of duplicated code.

        A better way to do that is to specify a generic type for the Team class.
     */
    private List<T> players;

    public Team(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    public void addPlayer(T player) {
        players.add(player);
    }

    public String getName() {
        return name;
    }

    public List<T> getPlayers() {
        return players;
    }
}

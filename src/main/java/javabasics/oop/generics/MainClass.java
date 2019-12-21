package javabasics.oop.generics;

public class MainClass {

    public static void main(String[] args) {
        Team<BaseballPlayer> baseballPlayerTeam = new Team<>("Baseball Team");
        BaseballPlayer baseballPlayer = new BaseballPlayer("Tom");
        baseballPlayerTeam.addPlayer(baseballPlayer);

        Team<BasketballPlayer> basketballPlayerTeam = new Team<>("Basketball Team");
        BasketballPlayer basketballPlayer = new BasketballPlayer("James");
        basketballPlayerTeam.addPlayer(basketballPlayer);

        Team<FootballPlayer> footballPlayerTeam = new Team<>("Football Team");
        FootballPlayer footballPlayer = new FootballPlayer("Jack");
        footballPlayerTeam.addPlayer(footballPlayer);

    }

}

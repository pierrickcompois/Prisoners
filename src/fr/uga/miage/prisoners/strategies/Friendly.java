package fr.uga.miage.prisoners.strategies;

public class Friendly implements Strategies{
    private String name;

    public Friendly(){
        this.name = "Friendly";
    }

    @Override
    public Move execute(int currentTurn, Move[] moves, int... score) {
        return Move.COOPERATE;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void initStrategy() {

    }
}

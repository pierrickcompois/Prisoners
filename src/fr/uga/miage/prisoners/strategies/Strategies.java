package fr.uga.miage.prisoners.strategies;

public abstract class Strategies {
    protected String name;
    private String description;


    public abstract Move play(int currentTurn, Move[] moves, int... score);

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void initStrategy() {}
}

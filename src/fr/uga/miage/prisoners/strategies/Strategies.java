package fr.uga.miage.prisoners.strategies;

public interface Strategies {

    Move execute(int currentTurn, Move[] moves, int... score);
    String getName();
    void setName(String name);
    void initStrategy();
}

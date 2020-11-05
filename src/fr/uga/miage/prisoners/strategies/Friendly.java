package fr.uga.miage.prisoners.strategies;

public class Friendly extends Strategies{

    public Friendly(){
        super();
        super.name = "Friendly";
    }

    @Override
    public Move play(int currentTurn, Move[] moves, int... score) {
        return Move.COOPERATE;
    }
}

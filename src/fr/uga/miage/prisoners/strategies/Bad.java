package fr.uga.miage.prisoners.strategies;

public class Bad extends Strategies {

    public Bad(){
        super();
        super.name = "Bad";
    }

    @Override
    public Move play(int currentTurn, Move[] moves, int... score) {
        return Move.BETRAY;
    }
}

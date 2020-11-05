package fr.uga.miage.prisoners.strategies;

public class GiveAndTake extends Strategies {
    public GiveAndTake(){
        super();
        super.name = "GiveAndTake";
    }

    @Override
    public Move play(int currentTurn, Move[] moves, int... score) {
        if(currentTurn == 0){
            return Move.COOPERATE;
        }
        return moves[currentTurn-1];
    }
}

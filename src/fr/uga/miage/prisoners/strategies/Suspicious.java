package fr.uga.miage.prisoners.strategies;

public class Suspicious extends Strategies {
    public Suspicious(){
        super();
        super.name = "Suspicious";
    }

    @Override
    public Move play(int currentTurn, Move[] moves, int... score) {
        if(currentTurn == 0){
            return Move.BETRAY;
        }
        return moves[currentTurn-1];
    }
}

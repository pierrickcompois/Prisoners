package fr.uga.miage.prisoners.strategies;

public class Resentful extends Strategies {
    public Resentful(){
        super();
        super.name = "Resentful";
    }

    @Override
    public Move play(int currentTurn, Move[] moves, int... score) {
        boolean needToBetray = false;

        if(currentTurn == 0){
            return Move.COOPERATE;
        }
        for (Move m: moves) {
            needToBetray = needToBetray || m == Move.BETRAY;
        }
        return needToBetray ? Move.BETRAY : Move.COOPERATE;
    }
}

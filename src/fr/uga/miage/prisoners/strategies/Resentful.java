package fr.uga.miage.prisoners.strategies;

public class Resentful extends Strategies {
    public Resentful(){
        super();
        super.name = "Resentful";
    }

    private boolean needToBetray = false;

    @Override
    public Move play(int currentTurn, Move[] moves, int... score) {
        if(currentTurn == 0){
            return Move.COOPERATE;
        }

        if (!needToBetray) {
            needToBetray = moves[currentTurn-1] == Move.BETRAY;
        }

        return needToBetray ? Move.BETRAY : Move.COOPERATE;
    }
}

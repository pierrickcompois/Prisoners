package fr.uga.miage.prisoners.strategies;

public class GiveAndTakeHard extends Strategies {
    public GiveAndTakeHard(){
        super();
        super.name = "GiveAndTakeHard";
    }

    @Override
    public Move play(int currentTurn, Move[] moves, int... score) {
        boolean betrayedInTwoPreviousRounds = false;

        if(currentTurn == 0){
            return Move.COOPERATE;
        }
        if (currentTurn == 1) {
            betrayedInTwoPreviousRounds = moves[currentTurn-1] == Move.BETRAY;
        }

        if (currentTurn >= 2) {
            betrayedInTwoPreviousRounds = moves[currentTurn-1] == Move.BETRAY || moves[currentTurn-2] == Move.BETRAY;
        }

        return betrayedInTwoPreviousRounds ? Move.BETRAY : Move.COOPERATE;
    }
}

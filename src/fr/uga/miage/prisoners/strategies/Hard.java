package fr.uga.miage.prisoners.strategies;

public class Hard extends Strategies {
    public Hard(){
        super();
        super.name = "Hard";
    }

    @Override
    public Move play(int currentTurn, Move[] moves, int... score) {
        boolean wasBetrayed = false;
        for (Move m: moves) {
            wasBetrayed = wasBetrayed || m == Move.BETRAY;
        }
        return wasBetrayed ? Move.LEAVE : Move.BETRAY;
    }
}

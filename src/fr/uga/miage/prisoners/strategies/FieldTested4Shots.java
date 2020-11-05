package fr.uga.miage.prisoners.strategies;

public class FieldTested4Shots extends Strategies {
    public FieldTested4Shots(){
        super();
        super.name = "FieldTested4Shots";
    }

    @Override
    public Move play(int currentTurn, Move[] moves, int... score) {
        int countBetray = 0;
        switch (currentTurn) {
            case 1:
                return Move.COOPERATE;
            case 2:
                return Move.COOPERATE;
            case 3:
                return Move.BETRAY;
            case 4:
                return Move.BETRAY;
            default:
                for (Move m: moves) {
                     countBetray += (m == Move.COOPERATE) ? 1 : 0;
                }
                return (countBetray == 3 || countBetray == 4) ? Move.LEAVE : Move.COOPERATE;
        }
    }
}

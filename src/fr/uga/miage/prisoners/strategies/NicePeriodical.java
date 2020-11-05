package fr.uga.miage.prisoners.strategies;

public class NicePeriodical extends Strategies {
    public NicePeriodical(){
        super();
        super.name = "NicePeriodical";
    }

    @Override
    public Move play(int currentTurn, Move[] moves, int... score) {
        Move moveToPlay = Move.COOPERATE;
        switch (currentTurn%3){
            case 0:
                moveToPlay = Move.COOPERATE;
                break;
            case 1:
                moveToPlay = Move.COOPERATE;
                break;
            case 2:
                moveToPlay = Move.BETRAY;
                break;
        }
        return moveToPlay;
    }
}

package fr.uga.miage.prisoners.strategies;

public class NastyPeriodical extends Strategies {
    public NastyPeriodical(){
        super();
        super.name = "NastyPeriodical";
    }

    @Override
    public Move play(int currentTurn, Move[] moves, int... score) {
        Move moveToPlay = Move.BETRAY;
        switch (currentTurn%3){
            case 0:
                moveToPlay = Move.BETRAY;
                break;
            case 1:
                moveToPlay = Move.BETRAY;
                break;
            case 2:
                moveToPlay = Move.COOPERATE;
                break;
            default:
                break;
        }
        return moveToPlay;
    }
}

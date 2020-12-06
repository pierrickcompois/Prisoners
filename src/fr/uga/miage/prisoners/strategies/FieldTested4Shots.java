package fr.uga.miage.prisoners.strategies;

public class FieldTested4Shots implements Strategies {
    private String name;

    public FieldTested4Shots(){
        name = "FieldTested4Shots";
    }


    @Override
    public Move execute(int currentTurn, Move[] moves, int... score) {
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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void initStrategy() {

    }
}

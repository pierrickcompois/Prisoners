package fr.uga.miage.prisoners.strategies;

public class NicePeriodical implements Strategies {
    private String name;

    public NicePeriodical(){
        this.name = "NicePeriodical";
    }

    @Override
    public Move execute(int currentTurn, Move[] moves, int... score) {
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

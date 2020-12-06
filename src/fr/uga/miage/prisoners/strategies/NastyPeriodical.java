package fr.uga.miage.prisoners.strategies;

public class NastyPeriodical implements Strategies {
    private String name;

    public NastyPeriodical(){
        this.name = "NastyPeriodical";
    }

    @Override
    public Move execute(int currentTurn, Move[] moves, int... score) {
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

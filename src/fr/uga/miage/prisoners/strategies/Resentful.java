package fr.uga.miage.prisoners.strategies;

public class Resentful implements Strategies {
    private String name;

    public Resentful(){
        this.name = "Resentful";
    }

    @Override
    public Move execute(int currentTurn, Move[] moves, int... score) {
        boolean needToBetray = false;

        if(currentTurn == 0){
            return Move.COOPERATE;
        }
        for (Move m: moves) {
            needToBetray = needToBetray || m == Move.BETRAY;
        }
        return needToBetray ? Move.BETRAY : Move.COOPERATE;
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

package fr.uga.miage.prisoners.strategies;

public class GiveAndTake implements Strategies {
    private String name;

    public GiveAndTake(){
        this.name = "GiveAndTake";
    }

    @Override
    public Move execute(int currentTurn, Move[] moves, int... score) {
        if(currentTurn == 0){
            return Move.COOPERATE;
        }
        return moves[currentTurn-1];
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

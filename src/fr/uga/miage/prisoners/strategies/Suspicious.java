package fr.uga.miage.prisoners.strategies;

public class Suspicious implements Strategies {
    private String name;

    public Suspicious(){
        this.name = "Suspicious";
    }

    @Override
    public Move execute(int currentTurn, Move[] moves, int... score) {
        if(currentTurn == 0){
            return Move.BETRAY;
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

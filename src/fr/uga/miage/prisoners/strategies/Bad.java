package fr.uga.miage.prisoners.strategies;

public class Bad implements Strategies {
    private String name;

    public Bad(){
        name = "Bad";
    }

    @Override
    public Move execute(int currentTurn, Move[] moves, int... score) {
        return Move.BETRAY;
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

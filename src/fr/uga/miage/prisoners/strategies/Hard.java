package fr.uga.miage.prisoners.strategies;

public class Hard implements Strategies {
    private String name;

    public Hard(){
        this.name = "Hard";
    }

    @Override
    public Move execute(int currentTurn, Move[] moves, int... score) {
        boolean wasBetrayed = false;
        for (Move m: moves) {
            wasBetrayed = wasBetrayed || m == Move.BETRAY;
        }
        return wasBetrayed ? Move.LEAVE : Move.BETRAY;
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

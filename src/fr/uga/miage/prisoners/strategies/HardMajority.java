package fr.uga.miage.prisoners.strategies;

public class HardMajority implements Strategies {
    private String name;

    public HardMajority(){
        this.name = "HardMajority";
    }

    @Override
    public Move execute(int currentTurn, Move[] moves, int... score) {
        int majority = 0;
        for (Move m: moves) {
            if (m != null) {
                majority += m == Move.COOPERATE ? 1 : -1;
            }
        }
        return majority <= 0 ? Move.BETRAY : Move.COOPERATE;
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

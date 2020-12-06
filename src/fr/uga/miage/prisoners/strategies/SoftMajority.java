package fr.uga.miage.prisoners.strategies;

public class SoftMajority implements Strategies {
    private String name;

    public SoftMajority(){
        this.name = "SoftMajority";
    }

    @Override
    public Move execute(int currentTurn, Move[] moves, int... score) {
        int majority = 0;
        for (Move m: moves) {
            if (m != null) {
                majority += m != null && m == Move.COOPERATE ? 1 : -1;
            }
        }
        System.out.println(majority < 0 ? Move.BETRAY : Move.COOPERATE);
        return majority < 0 ? Move.BETRAY : Move.COOPERATE;
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

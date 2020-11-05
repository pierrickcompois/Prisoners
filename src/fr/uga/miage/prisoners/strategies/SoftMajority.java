package fr.uga.miage.prisoners.strategies;

public class SoftMajority extends Strategies {
    public SoftMajority(){
        super();
        super.name = "SoftMajority";
    }

    @Override
    public Move play(int currentTurn, Move[] moves, int... score) {
        int majority = 0;
        for (Move m: moves) {
            if (m != null) {
                majority += m != null && m == Move.COOPERATE ? 1 : -1;
            }
        }
        System.out.println(majority < 0 ? Move.BETRAY : Move.COOPERATE);
        return majority < 0 ? Move.BETRAY : Move.COOPERATE;
    }
}

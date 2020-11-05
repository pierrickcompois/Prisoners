package fr.uga.miage.prisoners.strategies;

public class HardMajority extends Strategies {
    public HardMajority(){
        super();
        super.name = "HardMajority";
    }

    @Override
    public Move play(int currentTurn, Move[] moves, int... score) {
        int majority = 0;
        for (Move m: moves) {
            if (m != null) {
                majority += m == Move.COOPERATE ? 1 : -1;
            }
        }
        return majority <= 0 ? Move.BETRAY : Move.COOPERATE;
    }
}

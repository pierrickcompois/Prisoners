package fr.uga.miage.prisoners.strategies;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class BadTest {

    @Test
    public void testPlay() {
        double rand = Math.random();
        Strategies bad = new Bad();
        Move[] moves = new Move[(int) rand*100];

        for (int i = 0; i <moves.length; i++){
            double ran = Math.random();
            moves[i] = (ran < (double) 1/3) ? Move.BETRAY : (ran < (double) 2/3) ? Move.COOPERATE : Move.LEAVE;
        }
        assertSame(Move.BETRAY, bad.play((int) rand * 100, moves));
    }

}

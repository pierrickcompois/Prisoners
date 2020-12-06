package fr.uga.miage.prisoners.strategies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FriendlyTest {

    @Test
    public void testPlay() {
        double rand = Math.random();
        Strategies friendly = new Friendly();
        Move[] moves = new Move[(int) rand*100];

        for (int i = 0; i <moves.length; i++){
            moves[i] = (Math.random() < (double) 1/3) ? Move.BETRAY : (Math.random() < (double) 2/3) ? Move.COOPERATE : Move.LEAVE;
        }
        assertSame(Move.COOPERATE, friendly.execute((int) rand * 100, moves));
    }
}

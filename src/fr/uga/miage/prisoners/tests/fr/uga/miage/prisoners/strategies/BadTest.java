package fr.uga.miage.prisoners.strategies;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BadTest {

    @Test
    public void testPlay() {
        double rand = Math.random();
        Strategies bad = new Bad();
        Move[] moves = new Move[(int) rand*100];

        for (int i = 0; i <moves.length; i++){
            moves[i] = (rand < 1/3) ? Move.BETRAY : (rand < 2/3) ? Move.COOPERATE : Move.LEAVE;
        }
        assertTrue(Move.BETRAY == bad.play((int) rand*100, moves));
    }

}

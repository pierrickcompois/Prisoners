package fr.uga.miage.prisoners.strategies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NastyPeriodicalTest {

    @Test
    void play() {
        double rand = Math.random();
        Strategies s = new NastyPeriodical();
        int turns = (int) rand*100;
        Move[] moves = new Move[turns];
        boolean testGood = true;
        Move moveToPlay;

        for (int j = 0; j < 100; j++){
            for (int i = 0; i <moves.length; i++){
                double ran = Math.random();
                moves[i] = (ran < (double) 1/3) ? Move.BETRAY : (ran < (double) 2/3) ? Move.COOPERATE : Move.LEAVE;
            }

            moveToPlay = (turns%3 == 2) ? Move.COOPERATE : Move.BETRAY;

            testGood = (moveToPlay == s.execute(turns, moves)) && testGood;
        }

        assertTrue(testGood);
    }
}

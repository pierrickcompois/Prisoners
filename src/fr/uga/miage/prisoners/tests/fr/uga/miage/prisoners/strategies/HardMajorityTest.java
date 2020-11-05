package fr.uga.miage.prisoners.strategies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HardMajorityTest {

    @Test
    void play() {
        double rand = Math.random();
        Strategies s = new HardMajority();
        int turns = (int) rand*100;
        Move[] moves = new Move[turns];
        boolean testGood = true;
        Move moveToPlay;
        int count = 0;


        for (int j = 0; j < 100; j++){
            for (int i = 0; i <moves.length; i++){
                double ran = Math.random();
                if (ran < (double) 1 / 3){
                    moves[i] = Move.BETRAY;
                    count--;
                } else {
                    if (ran < (double) 2 / 3){
                        moves[i] = Move.COOPERATE;
                        count++;
                    } else moves[i] = Move.LEAVE;
                }
            }

            moveToPlay = (count >= 0) ? Move.BETRAY : Move.COOPERATE;
            testGood = (moveToPlay == s.play(turns, moves)) && testGood;
        }
        assertTrue(testGood);
    }
}
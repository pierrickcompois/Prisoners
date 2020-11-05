package fr.uga.miage.prisoners.strategies;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class HardTest {
    @Test
    public void testNeverBetrayed() {
        boolean testFailed = false;
        int remainingAttempts = 100;

        while (remainingAttempts > 0 && !testFailed) {
            Strategies hard = new Hard();
            int currentTurn = ThreadLocalRandom.current().nextInt(1, 100 + 1);
            Move[] moves = new Move[currentTurn];
            for(int i=0; i < currentTurn; i++) {
                moves[i] = Move.COOPERATE;
            }

            testFailed = Move.BETRAY != hard.play(currentTurn, moves);
            remainingAttempts--;
        }

        assertFalse(testFailed);
    }

    @Test
    public void testLeave() {
        Strategies hard = new Hard();

        Move[] moves = new Move[3];
        moves[0] = Move.COOPERATE;
        moves[1] = Move.COOPERATE;
        assertEquals(Move.BETRAY, hard.play(2, moves));

        moves[0] = Move.COOPERATE;
        moves[2] = Move.BETRAY;
        assertEquals(Move.LEAVE, hard.play(2, moves));
    }
}

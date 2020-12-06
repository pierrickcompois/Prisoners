package fr.uga.miage.prisoners.strategies;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class SuspiciousTest {
    @Test
    public void testBetrayFirstRound() {
        Strategies suspicious = new Suspicious();
        Move[] moves = new Move[0];
        assertEquals(Move.BETRAY, suspicious.execute(0, moves));
    }

    @Test
    public void testPlay() {
        boolean testFailed = false;
        int remainingAttempts = 100;

        while (remainingAttempts > 0 && !testFailed) {
            Strategies suspicious = new Suspicious();
            int currentTurn = ThreadLocalRandom.current().nextInt(1, 100 + 1);
            Move[] moves = new Move[currentTurn];
            for(int i=0; i < currentTurn; i++) {
                double rand = Math.random();
                moves[i] = rand < 1.0/3.0 ? Move.COOPERATE : (rand < 2.0/3.0 ? Move.BETRAY : Move.LEAVE);
            }

            testFailed = moves[currentTurn - 1] != suspicious.execute(currentTurn, moves);
            remainingAttempts--;
        }

        assertFalse(testFailed);
    }

}

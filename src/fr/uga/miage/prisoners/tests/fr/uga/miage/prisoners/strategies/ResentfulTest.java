package fr.uga.miage.prisoners.strategies;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class ResentfulTest {
    @Test
    public void testCooperateFirstRound() {
        Strategies resentful = new Resentful();
        Move[] moves = new Move[0];
        assertEquals(Move.COOPERATE, resentful.execute(0, moves));
    }

    @Test
    public void testNeverBetrayed() {
        boolean testFailed = false;
        int remainingAttempts = 100;

        while (remainingAttempts > 0 && !testFailed) {
            Strategies resentful = new Resentful();
            int currentTurn = ThreadLocalRandom.current().nextInt(1, 100 + 1);
            Move[] moves = new Move[currentTurn];
            for(int i=0; i < currentTurn; i++) {
                moves[i] = Move.COOPERATE;
            }

            testFailed = Move.COOPERATE != resentful.execute(currentTurn, moves);
            remainingAttempts--;
        }

        assertFalse(testFailed);
    }

    @Test
    public void testBetrayed() {
        boolean testFailed = false;
        int remainingAttempts = 100;

        while (remainingAttempts > 0 && !testFailed) {
            Strategies resentful = new Resentful();
            int currentTurn = ThreadLocalRandom.current().nextInt(1, 100 + 1);
            System.out.println(currentTurn);
            Move[] moves = new Move[currentTurn];
            moves[0] = Move.BETRAY;
            for(int i=1; i < currentTurn; i++) {
                double rand = Math.random();
                moves[i] = rand < 1.0/3.0 ? Move.COOPERATE : (rand < 2.0/3.0 ? Move.BETRAY : Move.LEAVE);
            }

            testFailed = Move.BETRAY != resentful.execute(currentTurn, moves);
            remainingAttempts--;
        }

        assertFalse(testFailed);
    }
}

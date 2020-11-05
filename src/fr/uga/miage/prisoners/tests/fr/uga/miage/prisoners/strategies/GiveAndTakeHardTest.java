package fr.uga.miage.prisoners.strategies;

import org.junit.jupiter.api.Test;
import java.util.concurrent.ThreadLocalRandom;
import static org.junit.jupiter.api.Assertions.*;

class GiveAndTakeHardTest {
    @Test
    public void testCooperateFirstRound() {
        Strategies giveAndTakeHard = new GiveAndTakeHard();
        Move[] moves = new Move[0];
        assertEquals(Move.COOPERATE, giveAndTakeHard.play(0, moves));
    }

    @Test
    public void testPlaySecondTurn() {
        Strategies giveAndTakeHard = new GiveAndTakeHard();
        Move[] moves = new Move[1];
        moves[0] = Move.COOPERATE;
        assertEquals(Move.COOPERATE, giveAndTakeHard.play(1, moves));
        moves[0] = Move.BETRAY;
        assertEquals(Move.BETRAY, giveAndTakeHard.play(1, moves));
    }

    @Test
    public void testPlayAfterSecondTurn() {
        Strategies giveAndTakeHard = new GiveAndTakeHard();

        Move[] moves = new Move[2];
        moves[0] = Move.COOPERATE;
        moves[1] = Move.COOPERATE;
        assertEquals(Move.COOPERATE, giveAndTakeHard.play(2, moves));

        moves[0] = Move.COOPERATE;
        moves[1] = Move.BETRAY;
        assertEquals(Move.BETRAY, giveAndTakeHard.play(2, moves));

        moves[0] = Move.BETRAY;
        moves[1] = Move.COOPERATE;
        assertEquals(Move.BETRAY, giveAndTakeHard.play(2, moves));

        moves[0] = Move.BETRAY;
        moves[1] = Move.BETRAY;
        assertEquals(Move.BETRAY, giveAndTakeHard.play(2, moves));
    }
}

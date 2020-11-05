package fr.uga.miage.prisoners;

import fr.uga.miage.prisoners.strategies.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfrontationTest {

    @Test
    public void testAddPoints() {

    }

    @Test
    public void testDefaultConfrontation() {
        Strategies s1 = new Friendly();
        Strategies s2 = new Bad();
        Confrontation c = new Confrontation(s1, s2, 20);
        c.playAllTurns();
        Assertions.assertEquals(c.getS1Score(), 0);
        Assertions.assertEquals(c.getS2Score(), 100);
    }

    @Test
    public void testGiveAndTakeAgainstResentfulBehavior() {
        Strategies s1 = new GiveAndTake();
        Strategies s2 = new Resentful();
        Confrontation c = new Confrontation(s1, s2, 10);
        c.playAllTurns();
        Assertions.assertEquals(c.getS1Score(), 30);
        Assertions.assertEquals(c.getS2Score(), 30);
    }

    @Test
    public void testNastyPeriodicalAgainstSoftMajorityBehavior() {
        Strategies s1 = new NastyPeriodical();
        Strategies s2 = new SoftMajority();
        Confrontation c = new Confrontation(s1, s2, 10);
        c.playAllTurns();
        Assertions.assertEquals(c.getS1Score(), 11);
        Assertions.assertEquals(c.getS2Score(), 21);
    }

    @Test
    public void testNastyPeriodicalAgainstSeedOfChampionBehavior() {
        Strategies s1 = new NastyPeriodical();
        Strategies s2 = new SeedOfChampion();
        Confrontation c = new Confrontation(s1, s2, 50);
        c.playAllTurns();
        Assertions.assertEquals(c.getS1Score(), 11);
        Assertions.assertEquals(c.getS2Score(), 21);
    }
}

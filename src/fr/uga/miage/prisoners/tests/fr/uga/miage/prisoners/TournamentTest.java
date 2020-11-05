package fr.uga.miage.prisoners;

import fr.uga.miage.prisoners.strategies.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class TournamentTest {

    @Test
    public void testTournamentWithBasicsStrategies() {
        Strategies s1 = new Friendly();
        Strategies s2 = new Bad();

        ArrayList<Strategies> strategies = new ArrayList<>();
        strategies.add(s1);
        strategies.add(s2);

        Tournament t = new Tournament(20, strategies);
        t.startTournament();
        int[][] score = t.getScore();
        Assertions.assertEquals(score[0][0], 60);
        Assertions.assertEquals(score[0][1], 0);
        Assertions.assertEquals(score[1][0], 100);
        Assertions.assertEquals(score[1][1], 20);
    }

}

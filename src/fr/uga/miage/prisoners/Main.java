package fr.uga.miage.prisoners;

import fr.uga.miage.prisoners.strategies.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Strategies friendly = new Friendly();
        Strategies bad = new Bad();
        Strategies giveAndTake = new GiveAndTake();
        Strategies champion = new SeedOfChampion();

        ArrayList<Strategies> s = new ArrayList<>();
        s.add(friendly);
        s.add(bad);
        s.add(giveAndTake);

        Tournament t = new Tournament(20, s);
        t.startTournament();
        System.out.println(t.toString());

        t.addStrategy(champion);
        t.startTournament();
        System.out.println(t.toString());
    }
}

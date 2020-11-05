package fr.uga.miage.prisoners;

import fr.uga.miage.prisoners.strategies.Strategies;

import java.util.ArrayList;

public class Tournament {

    private ArrayList<Strategies> strategies;
    private int nbTurns;
    private int[][] score;

    public Tournament(int nbTurns, ArrayList<Strategies> s){
        this.nbTurns = nbTurns;
        this.strategies = s;
        initScore();
    }

    public void startTournament() {
        initScore();
        for (int i = 0; i < strategies.size(); i++) {
            for (int j = 0; j < strategies.size(); j++) {
                strategies.get(i).initStrategy();
                strategies.get(j).initStrategy();
                Confrontation c = new Confrontation(strategies.get(i), strategies.get(j), nbTurns);
                c.playAllTurns();
                score[i][j] = c.getS1Score();
            }
        }
    }

    public void addStrategy(Strategies s) {
        strategies.add(s);
    }

    public void removeStrategy(Strategies s) {
        strategies.remove(s);
    }

    public void setTurns(int i) {
        nbTurns = i;
    }

    public int[][] getScore() {
        return score;
    }

    private void initScore() {
        this.score = new int[strategies.size()][strategies.size()];
    }

    @Override
    public String toString() {
       StringBuilder res = new StringBuilder();
        for (Strategies s : strategies) {
            res.append("\t\t\t").append(s.toString());
        }
        for (int i = 0; i < strategies.size(); i++) {
            res.append("\n").append(strategies.get(i).toString());
            for(int j = 0; j < strategies.size(); j++){
                res.append("\t\t").append(score[i][j]);
            }
        }
        return res.toString();
    }
}

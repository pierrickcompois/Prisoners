package fr.uga.miage.prisoners;

import fr.uga.miage.prisoners.strategies.GiveAndTakeWithSeuil;
import fr.uga.miage.prisoners.strategies.Move;
import fr.uga.miage.prisoners.strategies.Strategies;

public class Confrontation {
    private static final int T = 5;
    private static final int D = 0;
    private static final int C = 3;
    private static final int P = 1;
    private static final int N = 2;

    private Strategies s1;
    private Strategies s2;
    private int nbTurns;
    private int s1Score = 0;
    private int s2Score = 0;
    private int currentTurn;

    public Confrontation(Strategies s1, Strategies s2, int nbTurns) {
        this.s1 = s1;
        this.s2 = s2;
        this.nbTurns = nbTurns;
    }

    public void playAllTurns() {
        Move[] oldMovesS1 = new Move[nbTurns];
        Move[] oldMovesS2 = new Move[nbTurns];
        Move m1;
        Move m2;
        for(currentTurn = 0; currentTurn < nbTurns; currentTurn++) {
            m1 = (s1.getName().equals(new GiveAndTakeWithSeuil().getName())) ? playTurn(s1,oldMovesS2,s1Score) : playTurn(s1,oldMovesS2);
            m2 = (s2.getName().equals(new GiveAndTakeWithSeuil().getName())) ? playTurn(s2,oldMovesS1,s2Score) : playTurn(s2,oldMovesS1);

            oldMovesS1[currentTurn] = m1;
            oldMovesS2[currentTurn] = m2;

            addPoints(m1, m2);
        }
    }

    private Move playTurn(Strategies s, Move[] oldOpponentMoves) {
        return s.play(currentTurn, oldOpponentMoves);
    }

    private Move playTurn(Strategies s, Move[] oldOpponentMoves, int score) {
        return s.play(currentTurn, oldOpponentMoves, score);
    }

    private void addPoints(Move m1, Move m2) {
        if (m1 == Move.COOPERATE){
            if (m2 == Move.COOPERATE){
                s1Score += C; //C = 3
                s2Score += C;
            } else if(m2 == Move.BETRAY){
                // s1Score += D;
                s2Score += T; // T = 5
            } else {
                s1Score += N; // N = 2
                s2Score += N;
            }
        } else if (m1 == Move.BETRAY){
            if(m2 == Move.COOPERATE){
                s1Score += T;
                // s2Score += D;
            } else if(m2 == Move.BETRAY){
                s1Score += P;
                s2Score += P; // P = 1
            } else {
                s1Score += N; // N = 2
                s2Score += N;
            }
        } else {
            s1Score += 2; // N = 2
            s2Score += 2;
        }
    }

    public int getS1Score() {
        return s1Score;
    }

    public int getS2Score() {
        return s2Score;
    }
}

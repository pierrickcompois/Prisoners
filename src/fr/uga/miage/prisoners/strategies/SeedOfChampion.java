package fr.uga.miage.prisoners.strategies;

public class SeedOfChampion extends Strategies {

    private int betrayCount = 0;
    private boolean punishment = false;
    private int punishmentDuring = 0;
    private int nbBetrayOutOfPunishment = 0;
    private int outOfPunishment = 0;

    public SeedOfChampion(){
        super();
        super.name = "SeedOfChampion";
    }

    @Override
    public Move play(int currentTurn, Move[] moves, int... score) {
        int scoreSum = 0;
        double average;
        Move m = Move.COOPERATE;

        if(currentTurn == 0){
            return Move.COOPERATE;
        }

        if (currentTurn % 20 == 0){
            for (int s : score) {
                scoreSum += s;
            }

            average = (float) scoreSum / currentTurn;
            m = (average < 1.5) ? Move.LEAVE : Move.COOPERATE;
        }

        if(moves[currentTurn-1] == Move.BETRAY) {
            betrayCount++;
            if(punishment){
                punishmentDuring--;
                if(punishmentDuring == 0){
                    punishment = false;
                    outOfPunishment = 1;
                    return Move.COOPERATE;
                }
            } else {
                nbBetrayOutOfPunishment++;
                punishment = true;
                punishmentDuring = (nbBetrayOutOfPunishment * (nbBetrayOutOfPunishment + 1)) / 2;
            }
            return Move.BETRAY;
        }

        if(outOfPunishment == 1) {
            outOfPunishment--;
            return Move.COOPERATE;
        }
        return m;

    }

}

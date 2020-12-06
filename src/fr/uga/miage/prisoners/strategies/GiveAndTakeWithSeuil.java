package fr.uga.miage.prisoners.strategies;

public class GiveAndTakeWithSeuil implements Strategies {
    private String name;

    public GiveAndTakeWithSeuil(){
        this.name = "GiveAndTakeWithSeuil";
    }

    @Override
    public Move execute(int currentTurn, Move[] moves, int... score) {
        boolean hasBetray = false;
        float average = 3;
        int scoreSum = 0;
        if(currentTurn == 0){
            return Move.COOPERATE;
        }
        if (currentTurn == 1) {
            hasBetray = moves[currentTurn-1] == Move.BETRAY;
        }

        if (currentTurn >= 2) {
            hasBetray = moves[currentTurn-1] == Move.BETRAY || moves[currentTurn-2] == Move.BETRAY;
        }

        if (currentTurn % 5 == 0){
            for (int s : score) {
                scoreSum += s;
            }

            average = scoreSum / currentTurn;
        }

        return (average < 2) ? Move.LEAVE : hasBetray ? Move.BETRAY : Move.COOPERATE;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void initStrategy() {

    }
}

package fr.uga.miage.prisoners.strategies;

public class GiveAndTakeHard implements Strategies {
    private String name;

    public GiveAndTakeHard(){
        this.name = "GiveAndTakeHard";
    }

    @Override
    public Move execute(int currentTurn, Move[] moves, int... score) {
        boolean betrayedInTwoPreviousRounds = false;

        if(currentTurn == 0){
            return Move.COOPERATE;
        }
        if (currentTurn == 1) {
            betrayedInTwoPreviousRounds = moves[currentTurn-1] == Move.BETRAY;
        }

        if (currentTurn >= 2) {
            betrayedInTwoPreviousRounds = moves[currentTurn-1] == Move.BETRAY || moves[currentTurn-2] == Move.BETRAY;
        }

        return betrayedInTwoPreviousRounds ? Move.BETRAY : Move.COOPERATE;
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

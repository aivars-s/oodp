package oodp.homework.game.state;

import oodp.homework.game.Game;

public class GameStateOngoing implements GameState {

    private static GameStateOngoing instance = new GameStateOngoing();

    public static GameStateOngoing getInstance() {
        return instance;
    }

    public void updateState(Game game) {
        System.out.println("GameStateOngoing --- updating state");
        game.currentPlayerPerformMove();

        int currentNumber = game.getCurrentNumber();
        int targetNumber = game.getTargetNumber();
        int minAllowedNumber = game.getMinAllowedNumber();
        int maxAllowedNumber = game.getMaxAllowedNumber();

        if (currentNumber > targetNumber || maxAllowedNumber < minAllowedNumber) {
            System.out.println("GameStateOngoing --- updating state -> unwinnable");
            game.setState(GameStateUnwinnable.getInstance());
        } else if (currentNumber == targetNumber) {
            System.out.println("GameStateOngoing --- updating state -> won");
            game.setState(GameStateWon.getInstance());
        } else {
            System.out.println("GameStateOngoing --- updating state -> ongoing");
            game.nextPlayer();
        }
    }

    @Override
    public String toString() {
        return "Ongoing";
    }

}

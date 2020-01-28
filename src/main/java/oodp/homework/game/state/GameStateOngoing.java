package oodp.homework.game.state;

import oodp.homework.game.Game;
import oodp.homework.game.callback.GameCallback;

public class GameStateOngoing implements GameState {

    private static final GameStateOngoing INSTANCE = new GameStateOngoing();

    public static GameStateOngoing getInstance() {
        return INSTANCE;
    }

    private GameStateOngoing() {}

    public void updateState(Game game, GameCallback callback) {
        System.out.println("GameStateOngoing --- updating state");

        int currentNumber = callback.getCurrentNumber();
        int targetNumber = callback.getTargetNumber();
        int minAllowedNumber = callback.getMinAllowedNumber();
        int maxAllowedNumber = callback.getMaxAllowedNumber();

        if (currentNumber > targetNumber || maxAllowedNumber < minAllowedNumber) {
            System.out.println("GameStateOngoing --- updating state -> unwinnable");
            callback.getStateConsumer().accept(GameStateUnwinnable.getInstance());
        } else if (currentNumber == targetNumber) {
            System.out.println("GameStateOngoing --- updating state -> won");
            callback.getStateConsumer().accept(GameStateWon.getInstance());
        } else {
            System.out.println("GameStateOngoing --- updating state -> ongoing");
            game.currentPlayerPerformMove();
            callback.getStateConsumer().accept(this);
            game.nextPlayer();
        }
    }

    @Override
    public String toString() {
        return "Ongoing";
    }

}

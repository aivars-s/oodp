package oodp.homework.game.callback;

import oodp.homework.game.state.GameState;

import java.util.function.Consumer;

public class GameCallback {

    private final int currentNumber;
    private final int targetNumber;
    private final int minAllowedNumber;
    private final int maxAllowedNumber;
    private final boolean running;
    private final Consumer<GameState> stateConsumer;

    public GameCallback(
            int currentNumber,
            int targetNumber,
            int minAllowedNumber,
            int maxAllowedNumber,
            boolean running,
            Consumer<GameState> stateConsumer
    ) {
        this.currentNumber = currentNumber;
        this.targetNumber = targetNumber;
        this.minAllowedNumber = minAllowedNumber;
        this.maxAllowedNumber = maxAllowedNumber;
        this.running = running;
        this.stateConsumer = stateConsumer;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public int getMinAllowedNumber() {
        return minAllowedNumber;
    }

    public int getMaxAllowedNumber() {
        return maxAllowedNumber;
    }

    public boolean isRunning() {
        return running;
    }

    public Consumer<GameState> getStateConsumer() {
        return stateConsumer;
    }

}

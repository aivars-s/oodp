package oodp.homework.game;

import oodp.homework.game.player.Player;
import oodp.homework.game.state.GameState;

import java.util.List;

public class GameMemento {

    private final int currentNumber;
    private final int targetNumber;
    private final int minAllowedNumber;
    private final int maxAllowedNumber;
    private final boolean running;
    private final GameState state;
    private final List<Player> players;
    private final Player currentPlayer;
    private final int currentPlayerNumber;

    public GameMemento(
            int currentNumber,
            int targetNumber,
            int minAllowedNumber,
            int maxAllowedNumber,
            boolean running,
            GameState state,
            List<Player> players,
            Player currentPlayer,
            int currentPlayerNumber
    ) {
        this.currentNumber = currentNumber;
        this.targetNumber = targetNumber;
        this.minAllowedNumber = minAllowedNumber;
        this.maxAllowedNumber = maxAllowedNumber;
        this.running = running;
        this.state = state;
        this.players = players;
        this.currentPlayer = currentPlayer;
        this.currentPlayerNumber = currentPlayerNumber;
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

    public GameState getState() {
        return state;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int getCurrentPlayerNumber() {
        return currentPlayerNumber;
    }

}

package oodp.homework.game;

import oodp.homework.game.player.Player;
import oodp.homework.game.state.GameState;

import java.util.List;

public interface Game {
    void start();

    void update();

    void currentPlayerPerformMove();

    void nextPlayer();

    void addNumber(int number);

    void incrementAllowedNumbers();

    GameMemento createMemento();

    void restore(GameMemento memento);

    int getCurrentNumber();

    void setCurrentNumber(int number);

    int getTargetNumber();

    void setTargetNumber(int number);

    int getMinAllowedNumber();

    void setMinAllowedNumber(int number);

    int getMaxAllowedNumber();

    void setMaxAllowedNumber(int number);

    List<Player> getPlayers();

    void setPlayers(List<Player> players);

    Player getCurrentPlayer();

    void setCurrentPlayer(Player player);

    int getCurrentPlayerNumber();

    void setCurrentPlayerNumber(int number);

    boolean isRunning();

    void setRunning(boolean running);

    GameState getState();

    void setState(GameState state);
}

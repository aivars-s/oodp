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

    int getTargetNumber();

    int getMinAllowedNumber();

    int getMaxAllowedNumber();

    boolean isRunning();

    void setRunning(boolean running);

    void setState(GameState state);

}

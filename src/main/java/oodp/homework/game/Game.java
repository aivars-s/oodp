package oodp.homework.game;

import oodp.homework.game.player.Player;
import oodp.homework.game.state.GameState;

import java.util.List;

public interface Game {
    void start();

    void stop();

    void update();

    void currentPlayerPerformMove();

    void nextPlayer();

    void addNumber(int number);

    void incrementAllowedNumbers();

    GameMemento createMemento();

    void restore(GameMemento memento);

    void doBeforeUpdate(Runnable runnable);
}

package oodp.homework.game;

import oodp.homework.game.state.GameState;
import oodp.homework.game.state.GameStateOngoing;

import java.util.Deque;

public class GameDecorator implements Game {

    private final Game game;
    private final Deque<GameMemento> mementos;

    public GameDecorator(Game game, Deque<GameMemento> mementos) {
        this.game = game;
        this.mementos = mementos;
    }

    @Override
    public void start() {
        System.out.println("GameDecorator --- starting");
        game.setState(GameStateOngoing.getInstance());
        game.setRunning(true);
        while (game.isRunning()) {
            update();
        }
    }

    @Override
    public void update() {
        System.out.println("GameDecorator --- updating");
        mementos.push(game.createMemento());
        game.update();
    }

    @Override
    public void currentPlayerPerformMove() {
        game.currentPlayerPerformMove();
    }

    @Override
    public void nextPlayer() {
        game.nextPlayer();
    }

    @Override
    public void addNumber(int number) {
        game.addNumber(number);
    }

    @Override
    public void incrementAllowedNumbers() {
        game.incrementAllowedNumbers();
    }

    @Override
    public GameMemento createMemento() {
        return game.createMemento();
    }

    @Override
    public void restore(GameMemento memento) {
        game.restore(memento);
    }

    @Override
    public int getCurrentNumber() {
        return game.getCurrentNumber();
    }

    @Override
    public int getTargetNumber() {
        return game.getTargetNumber();
    }

    @Override
    public int getMinAllowedNumber() {
        return game.getMinAllowedNumber();
    }

    @Override
    public int getMaxAllowedNumber() {
        return game.getMaxAllowedNumber();
    }

    @Override
    public boolean isRunning() {
        return game.isRunning();
    }

    @Override
    public void setRunning(boolean running) {
        game.setRunning(running);
    }

    @Override
    public void setState(GameState state) {
        game.setState(state);
    }

}

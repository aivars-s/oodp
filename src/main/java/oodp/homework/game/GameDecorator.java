package oodp.homework.game;

import oodp.homework.game.player.Player;
import oodp.homework.game.state.GameState;
import oodp.homework.game.state.GameStateOngoing;

import java.util.Deque;
import java.util.List;

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
    public void setCurrentNumber(int number) {
        game.setCurrentNumber(number);
    }

    @Override
    public int getTargetNumber() {
        return game.getTargetNumber();
    }

    @Override
    public void setTargetNumber(int number) {
        game.setCurrentNumber(number);
    }

    @Override
    public int getMinAllowedNumber() {
        return game.getMinAllowedNumber();
    }

    @Override
    public void setMinAllowedNumber(int number) {
        game.setMinAllowedNumber(number);
    }

    @Override
    public int getMaxAllowedNumber() {
        return game.getMaxAllowedNumber();
    }

    @Override
    public void setMaxAllowedNumber(int number) {
        game.setMaxAllowedNumber(number);
    }

    @Override
    public List<Player> getPlayers() {
        return game.getPlayers();
    }

    @Override
    public void setPlayers(List<Player> players) {
        game.setPlayers(players);
    }

    @Override
    public Player getCurrentPlayer() {
        return game.getCurrentPlayer();
    }

    @Override
    public void setCurrentPlayer(Player player) {
        game.setCurrentPlayer(player);
    }

    @Override
    public int getCurrentPlayerNumber() {
        return game.getCurrentPlayerNumber();
    }

    @Override
    public void setCurrentPlayerNumber(int number) {
        game.setCurrentPlayerNumber(number);
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
    public GameState getState() {
        return game.getState();
    }

    @Override
    public void setState(GameState state) {
        game.setState(state);
    }

}

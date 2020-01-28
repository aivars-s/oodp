package oodp.homework.game.state;

import oodp.homework.game.Game;

public class GameStateWon implements GameState {

    private static final GameStateWon INSTANCE = new GameStateWon();

    public static GameStateWon getInstance() {
        return INSTANCE;
    }

    private GameStateWon() {}

    public void updateState(Game game) {
        System.out.println("GameStateWon --- updating state");
        game.setRunning(false);
    }

    @Override
    public String toString() {
        return "Won";
    }

}

package oodp.homework.game.state;

import oodp.homework.game.Game;
import oodp.homework.game.callback.GameCallback;

public class GameStateWon implements GameState {

    private static final GameStateWon INSTANCE = new GameStateWon();

    public static GameStateWon getInstance() {
        return INSTANCE;
    }

    private GameStateWon() {}

    public void updateState(Game game, GameCallback callback) {
        System.out.println("GameStateWon --- updating state");
        if (callback.isRunning()) {
            game.stop();
        }
    }

    @Override
    public String toString() {
        return "Won";
    }

}

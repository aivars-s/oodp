package oodp.homework.game.state;

import oodp.homework.game.Game;
import oodp.homework.game.callback.GameCallback;

public class GameStateUnwinnable implements GameState  {

    private static final GameStateUnwinnable INSTANCE = new GameStateUnwinnable();

    public static GameStateUnwinnable getInstance() {
        return INSTANCE;
    }

    private GameStateUnwinnable() {}

    public void updateState(Game game, GameCallback callback) {
        System.out.println("GameStateUnwinnable --- updating state");
        if (callback.isRunning()) {
            game.stop();
        }
    }

    @Override
    public String toString() {
        return "Unwinnable";
    }

}

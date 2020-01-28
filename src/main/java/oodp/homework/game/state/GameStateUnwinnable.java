package oodp.homework.game.state;

import oodp.homework.game.Game;

public class GameStateUnwinnable implements GameState  {

    private static final GameStateUnwinnable INSTANCE = new GameStateUnwinnable();

    public static GameStateUnwinnable getInstance() {
        return INSTANCE;
    }

    private GameStateUnwinnable() {}

    public void updateState(Game game) {
        System.out.println("GameStateUnwinnable --- updating state");
        if (game.isRunning()) {
            game.setRunning(false);
        }
    }

    @Override
    public String toString() {
        return "Unwinnable";
    }

}

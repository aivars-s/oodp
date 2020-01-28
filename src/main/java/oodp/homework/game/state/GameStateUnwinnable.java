package oodp.homework.game.state;

import oodp.homework.game.Game;

public class GameStateUnwinnable implements GameState  {

    private static GameStateUnwinnable instance = new GameStateUnwinnable();

    public static GameStateUnwinnable getInstance() {
        return instance;
    }

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

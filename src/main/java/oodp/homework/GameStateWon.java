package oodp.homework;

public class GameStateWon implements GameState {

    private static GameStateWon instance = new GameStateWon();

    public static GameStateWon getInstance() {
        return instance;
    }

    public void updateState(Game game) {
        System.out.println("GameStateWon --- updating state");
        game.setRunning(false);
    }

    @Override
    public String toString() {
        return "Won";
    }

}

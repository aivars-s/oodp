package oodp.homework.game;

import oodp.homework.game.callback.GameCallback;
import oodp.homework.game.player.Player;
import oodp.homework.game.state.GameState;
import oodp.homework.game.state.GameStateOngoing;

import java.util.List;

public class GameImpl implements Game {

    private static final int DEFAULT_MIN_ALLOWED_NUMBER = 1;
    private static final int DEFAULT_MAX_ALLOWED_NUMBER = 10;
    private static final int DEFAULT_TARGET_NUMBER = 20;

    private int currentNumber;
    private int targetNumber;
    private int minAllowedNumber;
    private int maxAllowedNumber;
    private boolean running;
    private GameState state;
    private List<Player> players;
    private Player currentPlayer;
    private int currentPlayerNumber;
    private Runnable beforeUpdate;

    public GameImpl(List<Player> players) {
        this(DEFAULT_TARGET_NUMBER, players);
    }

    public GameImpl(int targetNumber, List<Player> players) {
        System.out.println("GameImpl --- creating");

        this.currentNumber = 0;
        this.targetNumber = targetNumber;
        this.minAllowedNumber = DEFAULT_MIN_ALLOWED_NUMBER;
        this.maxAllowedNumber = DEFAULT_MAX_ALLOWED_NUMBER;
        this.currentPlayerNumber = 0;
        this.currentPlayer = players.get(currentPlayerNumber);
        this.players = players;

        System.out.println("  target number: " + this.targetNumber);
        System.out.println("  player count:  " + this.players.size());
        System.out.println("  players: " + this.players);
    }

    @Override
    public void start() {
        System.out.println("GameImpl --- starting");
        this.state = GameStateOngoing.getInstance();
        running = true;
        while (running) {
            update();
        }
    }

    @Override
    public void stop() {
        System.out.println("GameImpl --- stopping");
        running = false;
    }

    private void setState(GameState state) {
        this.state = state;
    }

    @Override
    public void update() {
        if (beforeUpdate != null) {
            System.out.println("GameImpl --- executing before update");
            beforeUpdate.run();
        }
        System.out.println("GameImpl --- updating");
        System.out.println(String.format(
                "  current player:     %s - %s",
                currentPlayerNumber,
                currentPlayer
        ));
        System.out.println("  current number:     " + currentNumber);
        System.out.println("  min allowed number: " + minAllowedNumber);
        System.out.println("  max allowed number: " + maxAllowedNumber);

        state.updateState(this, new GameCallback(
                currentNumber,
                targetNumber,
                minAllowedNumber,
                maxAllowedNumber,
                running,
                this::setState
        ));
    }

    @Override
    public void currentPlayerPerformMove() {
        currentPlayer.performMove(this, new GameCallback(
                currentNumber,
                targetNumber,
                minAllowedNumber,
                maxAllowedNumber,
                running,
                null
        ));
        incrementAllowedNumbers();
    }

    @Override
    public void nextPlayer() {
        currentPlayerNumber = (currentPlayerNumber + 1) % players.size();
        currentPlayer = players.get(currentPlayerNumber);
    }

    @Override
    public void addNumber(int number) {
        System.out.println(String.format(
                "GameImpl --- adding number %s to %s",
                number, currentNumber));
        currentNumber += number;
    }

    @Override
    public void incrementAllowedNumbers() {
        System.out.println("GameImpl --- incrementing allowed numbers");
        minAllowedNumber++;
        maxAllowedNumber++;
    }

    @Override
    public GameMemento createMemento() {
        System.out.println("Game --- creating memento");

        return new GameMemento(
                currentNumber,
                targetNumber,
                minAllowedNumber,
                maxAllowedNumber,
                running,
                state,
                players,
                currentPlayer,
                currentPlayerNumber
        );
    }

    @Override
    public void restore(GameMemento memento) {
        System.out.println("Game --- restoring from memento:");

        currentNumber = memento.getCurrentNumber();
        targetNumber = memento.getTargetNumber();
        minAllowedNumber = memento.getMinAllowedNumber();
        maxAllowedNumber = memento.getMaxAllowedNumber();
        running = memento.isRunning();
        state = memento.getState();
        players = memento.getPlayers();
        currentPlayer = memento.getCurrentPlayer();
        currentPlayerNumber = memento.getCurrentPlayerNumber();

        System.out.println("  currentNumber:       " + currentNumber);
        System.out.println("  targetNumber:        " + targetNumber);
        System.out.println("  minAllowedNumber:    " + minAllowedNumber);
        System.out.println("  maxAllowedNumber:    " + maxAllowedNumber);
        System.out.println("  running:             " + running);
        System.out.println("  state:               " + state);
        System.out.println("  players:             " + players);
        System.out.println("  currentPlayer:       " + currentPlayer);
        System.out.println("  currentPlayerNumber: " + currentPlayerNumber);
    }

    @Override
    public void doBeforeUpdate(Runnable runnable) {
        beforeUpdate = runnable;
    }

}

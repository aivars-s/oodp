package oodp.homework.game.player;

import oodp.homework.game.Game;
import oodp.homework.game.callback.GameCallback;

public class MaxAmountPlayer implements Player  {

    private static final MaxAmountPlayer INSTANCE = new MaxAmountPlayer();

    public static MaxAmountPlayer getInstance() {
        return INSTANCE;
    }

    private MaxAmountPlayer() {}

    public void performMove(Game game, GameCallback callback) {
        System.out.println("MaxAmountPlayer --- performing move");
        int currentNumber = callback.getCurrentNumber();
        int targetNumber = callback.getTargetNumber();
        int minAllowedNumber = callback.getMinAllowedNumber();
        int maxAllowedNumber = callback.getMaxAllowedNumber();
        int bestNumber = targetNumber - currentNumber;

        if (bestNumber >= minAllowedNumber && bestNumber <= maxAllowedNumber) {
            System.out.println(String.format("  choosing best number %s", bestNumber));
            game.addNumber(bestNumber);
        } else {
            System.out.println(String.format("  choosing max number %s", maxAllowedNumber));
            game.addNumber(maxAllowedNumber);
        }
    }

    @Override
    public String toString() {
        return "MaxAmountPlayer";
    }
}

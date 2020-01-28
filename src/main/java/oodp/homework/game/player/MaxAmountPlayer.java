package oodp.homework.game.player;

import oodp.homework.game.Game;

public class MaxAmountPlayer implements Player  {

    private static final MaxAmountPlayer INSTANCE = new MaxAmountPlayer();

    public static MaxAmountPlayer getInstance() {
        return INSTANCE;
    }

    private MaxAmountPlayer() {}

    public void performMove(Game game) {
        System.out.println("MaxAmountPlayer --- performing move");
        int currentNumber = game.getCurrentNumber();
        int targetNumber = game.getTargetNumber();
        int minAllowedNumber = game.getMinAllowedNumber();
        int maxAllowedNumber = game.getMaxAllowedNumber();
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

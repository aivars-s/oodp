package oodp.homework.game.player;

import oodp.homework.game.Game;

public class MinAmountPlayer implements Player {

    private static final MinAmountPlayer INSTANCE = new MinAmountPlayer();

    public static MinAmountPlayer getInstance() {
        return INSTANCE;
    }

    private MinAmountPlayer() {}

    public void performMove(Game game) {
        System.out.println("MinAmountPlayer --- performing move");
        int currentNumber = game.getCurrentNumber();
        int targetNumber = game.getTargetNumber();
        int minAllowedNumber = game.getMinAllowedNumber();
        int maxAllowedNumber = game.getMaxAllowedNumber();
        int bestNumber = targetNumber - currentNumber;

        if (bestNumber >= minAllowedNumber && bestNumber <= maxAllowedNumber) {
            System.out.println(String.format("  choosing best number %s", bestNumber));
            game.addNumber(bestNumber);
        } else {
            System.out.println(String.format("  choosing min number %s", minAllowedNumber));
            game.addNumber(minAllowedNumber);
        }
    }

    @Override
    public String toString() {
        return "MinAmountPlayer";
    }

}

package oodp.homework.game.player;

import oodp.homework.game.Game;
import oodp.homework.game.callback.GameCallback;

import java.util.Random;

public class RandomAmountPlayer implements Player  {

    private static final RandomAmountPlayer INSTANCE = new RandomAmountPlayer();

    public static RandomAmountPlayer getInstance() {
        return INSTANCE;
    }

    Random random;

    private RandomAmountPlayer() {
         random = new Random(System.currentTimeMillis());
    }

    public void performMove(Game game, GameCallback callback) {
        System.out.println("RandomAmountPlayer --- performing move");
        int currentNumber = callback.getCurrentNumber();
        int targetNumber = callback.getTargetNumber();
        int minAllowedNumber = callback.getMinAllowedNumber();
        int maxAllowedNumber = callback.getMaxAllowedNumber();
        int bestNumber = targetNumber - currentNumber;

        if (bestNumber >= minAllowedNumber && bestNumber <= maxAllowedNumber) {
            System.out.println(String.format("  choosing best number %s", bestNumber));
            game.addNumber(bestNumber);
        } else {
            int randomNumber = random.nextInt(maxAllowedNumber) + 1;
            System.out.println(String.format("  choosing random number %s", randomNumber));
            game.addNumber(randomNumber);
        }
    }

    @Override
    public String toString() {
        return "RandomAmountPlayer";
    }

}

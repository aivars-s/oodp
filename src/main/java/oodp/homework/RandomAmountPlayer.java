package oodp.homework;

import java.util.Random;

public class RandomAmountPlayer implements Player  {

    private static RandomAmountPlayer instance = new RandomAmountPlayer();

    public static RandomAmountPlayer getInstance() {
        return instance;
    }

    Random random;

    private RandomAmountPlayer() {
         random = new Random(System.currentTimeMillis());
    }

    public void performMove(Game game) {
        System.out.println("RandomAmountPlayer --- performing move");
        int currentNumber = game.getCurrentNumber();
        int targetNumber = game.getTargetNumber();
        int minAllowedNumber = game.getMinAllowedNumber();
        int maxAllowedNumber = game.getMaxAllowedNumber();
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

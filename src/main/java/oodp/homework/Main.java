package oodp.homework;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Player> game1Players = Arrays.asList(
                MinAmountPlayer.getInstance(),
                MaxAmountPlayer.getInstance());
        Game game1 = new GameImpl(game1Players);
        game1.start();

        System.out.println();

        List<Player> game2Players = Arrays.asList(
                MinAmountPlayer.getInstance(),
                MaxAmountPlayer.getInstance(),
                RandomAmountPlayer.getInstance());
        Game game2 = new GameImpl(25, game2Players);
        game2.start();

        System.out.println();

        Game game3 = new GameImpl(game1Players);
        Deque<GameMemento> game3Mementos = new ArrayDeque<>();
        Game game3Decorator = new GameDecorator(game3, game3Mementos);
        game3Decorator.start();
        while (!game3Mementos.isEmpty()) {
            game3Decorator.restore(game3Mementos.pop());
        }
    }


}

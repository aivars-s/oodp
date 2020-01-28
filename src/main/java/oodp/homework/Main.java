package oodp.homework;

import oodp.homework.game.Game;
import oodp.homework.game.GameImpl;
import oodp.homework.game.GameMemento;
import oodp.homework.game.player.MaxAmountPlayer;
import oodp.homework.game.player.MinAmountPlayer;
import oodp.homework.game.player.Player;
import oodp.homework.game.player.RandomAmountPlayer;

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
        game3.doBeforeUpdate(() -> game3Mementos.push(game3.createMemento()));
        game3.start();
        while (!game3Mementos.isEmpty()) {
            game3.restore(game3Mementos.pop());
        }
    }

}

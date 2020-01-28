package oodp.homework.game.player;

import oodp.homework.game.Game;
import oodp.homework.game.callback.GameCallback;

public interface Player {

    void performMove(Game game, GameCallback callback);

}

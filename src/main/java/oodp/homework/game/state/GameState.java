package oodp.homework.game.state;

import oodp.homework.game.Game;
import oodp.homework.game.callback.GameCallback;

public interface GameState {

    void updateState(Game game, GameCallback callback);

}

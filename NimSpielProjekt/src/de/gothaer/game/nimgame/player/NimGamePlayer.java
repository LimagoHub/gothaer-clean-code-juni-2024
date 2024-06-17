package de.gothaer.game.nimgame.player;

import de.gothaer.game.player.Player;

public interface NimGamePlayer extends Player<Integer, Integer> {


    String getName();
    Integer doTurn(final Integer stones);

}

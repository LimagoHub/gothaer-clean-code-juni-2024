package de.gothaer.game.player;

public interface Player<BOARD, TURN> {
    String getName();
    TURN doTurn(final BOARD stones);
}

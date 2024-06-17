package de.gothaer.client;

import de.gothaer.game.Game;

public class GameClient {

    private final Game game;

    public GameClient(final Game game) {
        this.game = game;
    }

    public void go() {
        game.play();
    }
}

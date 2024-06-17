package de.gothaer.application;

import de.gothaer.client.GameClient;
import de.gothaer.game.Game;
import de.gothaer.game.nimgame.NimGame;

public class Main {
    public static void main(String[] args) {

        Game game = new NimGame();
        GameClient client = new GameClient(game);
        client.go();
    }
}
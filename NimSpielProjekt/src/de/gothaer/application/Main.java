package de.gothaer.application;

import de.gothaer.client.GameClient;
import de.gothaer.game.nimgame.NimGame;
import de.gothaer.game.nimgame.player.ComputerPlayer;
import de.gothaer.game.nimgame.player.HumanPlayer;
import de.gothaer.io.ConsoleWriter;

public class Main {
    public static void main(String[] args) {

        NimGame game = new NimGame(new ConsoleWriter());
        game.addPlayer(new HumanPlayer());
        game.addPlayer(new ComputerPlayer());
        GameClient client = new GameClient(game);
        client.go();
    }
}
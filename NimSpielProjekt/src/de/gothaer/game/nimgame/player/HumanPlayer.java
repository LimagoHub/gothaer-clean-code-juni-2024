package de.gothaer.game.nimgame.player;

import java.util.Scanner;

public class HumanPlayer extends AbstractNimGamePlayer{

    private final Scanner scanner = new Scanner(System.in);

    public HumanPlayer() {
    }

    public HumanPlayer(final String name) {
        super(name);
    }

    @Override
    public Integer doTurn(final Integer stones) {

        System.out.println("Es gibt " + stones + " Steine. Bitte nehmen Sie 1,2 oder 3!");
        return scanner.nextInt();
    }
}

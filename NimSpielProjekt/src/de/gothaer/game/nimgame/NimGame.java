package de.gothaer.game.nimgame;

import de.gothaer.game.Game;

import java.util.Scanner;

public class NimGame implements Game {

    private final Scanner scanner = new Scanner(System.in);
    private int stones;
    private boolean gameover = false;
    public NimGame() {
        stones = 23;
    }
    @Override
    public void play() {
        while( ! gameover) {
            playRound();
        }
    }
    private void playRound() {
        humanTurn();
        computerTurn();
    }
    private void humanTurn() {
        int turn;
        while(true) {
            System.out.println("Es gibt " + stones + " Steine. Bitte nehmen Sie 1,2 oder 3!");
            turn = scanner.nextInt();
            if(turn >= 1 && turn <= 3) break;
            System.out.println("Ungueltiger Zug");
        }
        stones -= turn;
    }
    private void computerTurn() {
        final int [] turns = {3,1,1,2};
        int turn;
        if( stones < 1 ) {
            System.out.println("Du Loser");
            gameover = true;
            return;
        }
        if( stones == 1 ) {
            System.out.println("Du hast nur Glueck gehabt");
            gameover = true;
            return;
        }
        turn = turns[stones % 4];
        System.out.println("Computer nimmt " + turn + " Steine.");
        stones -= turn;

    }
}

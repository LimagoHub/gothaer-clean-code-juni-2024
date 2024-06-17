package de.gothaer.game.nimgame;

import de.gothaer.game.Game;

import java.util.Scanner;

public class NimGame implements Game {

    private final Scanner scanner = new Scanner(System.in);
    private int stones;
    private int turn;
    public NimGame() {
        stones = 23;
    }
    @Override
    public void play() {
        while( ! isGameover()) {
            playRound();
        }
    }
    private void playRound() {
        humanTurn();
        computerTurn();
    }
    private void humanTurn() {
        if(isGameover()) return;

        while(true) {
            System.out.println("Es gibt " + stones + " Steine. Bitte nehmen Sie 1,2 oder 3!");
            turn = scanner.nextInt();
            if(turn >= 1 && turn <= 3) break;
            System.out.println("Ungueltiger Zug");
        }
        terminateTurn( "Mensch");
    }
    private void computerTurn() {
        if(isGameover()) return;
        final int [] turns = {3,1,1,2};


        turn = turns[stones % 4];
        System.out.println("Computer nimmt " + turn + " Steine.");
        terminateTurn( "Computer");

    }

    private void terminateTurn(final String player) { // Integration
        updateBoard();
        printGameOverMessageIfGameIsOver(player);
    }

    private void printGameOverMessageIfGameIsOver(final String player) { // Operation
        if(isGameover()) {
            System.out.println(player + " hat verloren");
        }
    }


    //---------------- Implementierungssumpf ------------------------
    private void updateBoard() {
        stones -= turn;
    }

    private boolean isGameover() {
        return stones < 1;
    }
}

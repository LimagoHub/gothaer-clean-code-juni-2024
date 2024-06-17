package de.gothaer.game;

import de.gothaer.game.nimgame.player.NimGamePlayer;
import de.gothaer.game.player.Player;
import de.gothaer.io.Writer;

import java.util.ArrayList;
import java.util.List;

public abstract  class AbstractGame<BOARD, TURN>  implements Game{

    private final Writer writer;
    private final List<Player<BOARD,TURN>> players = new ArrayList<>();
    private  Player<BOARD,TURN> currentPlayer;

    private BOARD board;
    private TURN turn;


    public AbstractGame(final Writer writer) {
        this.writer = writer;

    }

    protected BOARD getBoard() {
        return board;
    }

    protected void setBoard(final BOARD board) {
        this.board = board;
    }

    protected TURN getTurn() {
        return turn;
    }

    protected void setTurn(final TURN turn) {
        this.turn = turn;
    }

    protected Player<BOARD,TURN> getCurrentPlayer() {
        return currentPlayer;
    }

    protected void setCurrentPlayer(final Player<BOARD,TURN> currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    protected List<Player<BOARD,TURN>> getPlayers() {
        return players;
    }

    public void addPlayer(final Player<BOARD,TURN> player) {
        players.add(player);
    }

    public void removePlayer(final Player<BOARD,TURN>  player) {
        players.remove(player);
    }
    @Override
    public void play() {
        while( ! isGameover()) {
            playRound();
        }
    }

    private void playRound() {
        for (var player : players) {
            setCurrentPlayer(player);
            playSingleTurn();
        }
    }

    private void playSingleTurn() {
        if(isGameover()) return;
        executeTurn();
        terminateTurn( );
    }

    private void terminateTurn() { // Integration
        updateBoard();
        printGameOverMessageIfGameIsOver();
    }

    private void printGameOverMessageIfGameIsOver() { // Operation
        if(isGameover()) {
            write(getCurrentPlayer().getName() + " hat verloren");
        }
    }



    private void executeTurn() {

        do {
            turn = getCurrentPlayer().doTurn(board);
        } while( turnIsNotValid());
    }


    private boolean turnIsNotValid() {
        if(isTurnValid()) return false;
        write("Ungueltiger Zug");
        return true;
    }

    protected void write(String message) {
        writer.write(message);
    }

    protected abstract void updateBoard();
    protected abstract boolean isGameover();
    protected abstract  boolean isTurnValid();
}

package de.gothaer.game.nimgame;

import de.gothaer.game.AbstractGame;
import de.gothaer.io.Writer;

public class NimGame extends AbstractGame<Integer, Integer> {


    public NimGame(final Writer writer) {
        super(writer);
        setBoard(23);
    }



    //---------------- Implementierungssumpf ------------------------


    @Override
    protected void updateBoard() {
        setBoard(getBoard() - getTurn());
    }

    @Override
    protected boolean isGameover() {
        return getBoard() < 1 || getPlayers().isEmpty();
    }
    @Override
    protected boolean isTurnValid() {
        return getTurn() >= 1 && getTurn() <= 3;
    }
}

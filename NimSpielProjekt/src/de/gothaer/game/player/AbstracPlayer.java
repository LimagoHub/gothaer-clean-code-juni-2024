package de.gothaer.game.player;

public abstract class AbstracPlayer<BOARD,TURN> implements Player<BOARD,TURN> {

    private String name = getClass().getSimpleName();

    protected AbstracPlayer() {
    }

    public AbstracPlayer(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }


}

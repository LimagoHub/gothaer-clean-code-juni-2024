package de.gothaer.game.player;

public abstract class AbstracPlayer implements Player {

    private String name = getClass().getSimpleName();

    public AbstracPlayer() {
    }

    public AbstracPlayer(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }


}

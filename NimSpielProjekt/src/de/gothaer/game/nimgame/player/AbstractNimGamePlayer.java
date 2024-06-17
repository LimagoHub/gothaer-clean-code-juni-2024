package de.gothaer.game.nimgame.player;

public abstract class AbstractNimGamePlayer implements NimGamePlayer{

    private String name = getClass().getSimpleName();

    public AbstractNimGamePlayer() {
    }

    public AbstractNimGamePlayer(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }


}

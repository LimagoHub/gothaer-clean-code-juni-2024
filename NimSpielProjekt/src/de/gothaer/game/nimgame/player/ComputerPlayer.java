package de.gothaer.game.nimgame.player;

public class ComputerPlayer extends AbstractNimGamePlayer{

    private static final int [] TURNS = {3,1,1,2};
    public ComputerPlayer() {
    }

    public ComputerPlayer(final String name) {
        super(name);
    }

    @Override
    public Integer doTurn(final Integer stones) {
        final Integer turn = TURNS[stones % 4];
        System.out.println("Computer nimmt " + turn + " Steine.");
        return turn;
    }
}

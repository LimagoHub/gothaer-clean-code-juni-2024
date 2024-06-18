package de.gothaer.application.container.internal.decorator;

import de.gothaer.application.container.IntArrayFiller;

public class IntArrayFillerLoggerDecorator implements IntArrayFiller{

    private final IntArrayFiller intArrayFiller;

    public IntArrayFillerLoggerDecorator(final IntArrayFiller intArrayFiller) {
        this.intArrayFiller = intArrayFiller;
    }

    public int[] fillArray(final int[] arrayToFill) {
        System.out.println("fillArray wurde mit groesse " + arrayToFill.length + " aufgerufen");
        return intArrayFiller.fillArray(arrayToFill);
    }
}

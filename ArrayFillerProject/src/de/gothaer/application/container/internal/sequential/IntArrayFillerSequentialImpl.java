package de.gothaer.application.container.internal.sequential;


import de.gothaer.application.container.IntArrayFiller;
import de.gothaer.application.generator.IntGenerator;

public class IntArrayFillerSequentialImpl implements IntArrayFiller {

    private final IntGenerator generator;

    public IntArrayFillerSequentialImpl(final IntGenerator generator) {
        this.generator = generator;
    }

    @Override
    public int [] fillArray(final int[] arrayToFill) {
        for (int i = 0; i < arrayToFill.length; i++) {
            arrayToFill[i] = generator.next();
        }
        return arrayToFill;
    }

}

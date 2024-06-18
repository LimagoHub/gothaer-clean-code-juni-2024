package de.gothaer.application.container.internal.decorator;


import de.gothaer.application.container.IntArrayFiller;
import de.gothaer.application.time.Stopwatch;

public class IntArrayFillerBenchmarkDecorator implements IntArrayFiller {

    private final Stopwatch stopwatch;
    private final IntArrayFiller intArrayFiller;;

    public IntArrayFillerBenchmarkDecorator(final IntArrayFiller intArrayFiller, final Stopwatch stopwatch) {
        this.stopwatch = stopwatch;
        this.intArrayFiller = intArrayFiller;
    }

    @Override
    public int[] fillArray(final int[] arrayToFill) {
        stopwatch.start();
        final int[] result =  intArrayFiller.fillArray(arrayToFill);
        stopwatch.stop();
        System.out.println("Duration = " + stopwatch.getDuration().toMillis() + " millis");
        return result;
    }
}

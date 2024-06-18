package de.gothaer.application.bootstrap;

import de.gothaer.application.client.Client;
import de.gothaer.application.client.internal.ClientImpl;
import de.gothaer.application.container.IntArrayFiller;
import de.gothaer.application.container.internal.decorator.IntArrayFillerBenchmarkDecorator;
import de.gothaer.application.container.internal.decorator.IntArrayFillerLoggerDecorator;
import de.gothaer.application.container.internal.sequential.IntArrayFillerSequentialImpl;
import de.gothaer.application.generator.IntGenerator;
import de.gothaer.application.generator.IntGeneratorBuilder;
import de.gothaer.application.generator.internal.random.RandomGeneratorBuilderImpl;
import de.gothaer.application.generator.internal.random.RandomNumberGenerator;
import de.gothaer.application.time.internal.StopwatchImpl;

public class Bootstrap {

    private boolean logger = false;
    private boolean benchmark = true;

    public void startApplication() {
        for (int treadCount = 1; treadCount <= Runtime.getRuntime().availableProcessors() + 1; treadCount++) {
            run(treadCount);
        }
    }

    private void run(final int treadCount) {

        System.out.print("Running with " + treadCount + " threads...");

        IntGenerator generator = createIntGenerator();
        IntArrayFiller arrayFiller = createIntFiller(generator, treadCount);
        Client client = createClient(arrayFiller);
        client.doSomethingWithLargeArray();

    }

    private static IntGenerator createIntGenerator() {
        return new RandomNumberGenerator();
    }

    private IntArrayFiller createIntFiller(IntGenerator generator, final int treadCount) {
        IntArrayFiller result;

        result = new IntArrayFillerSequentialImpl(generator);

        if(logger) result = new IntArrayFillerLoggerDecorator(result);
        if(benchmark) result = new IntArrayFillerBenchmarkDecorator(result, new StopwatchImpl());
        return result;
    }

    private static Client createClient(IntArrayFiller arrayFiller) {
        return new ClientImpl(arrayFiller);

    }
}

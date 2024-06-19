package de.gothaer.application.bootstrap;


import de.gothaer.application.client.Client;
import de.gothaer.application.client.internal.ClientImpl;
import de.gothaer.application.container.IntArrayFiller;
import de.gothaer.application.container.internal.decorator.IntArrayFillerBenchmarkDecorator;
import de.gothaer.application.container.internal.parallel.IntArrayFillerParallelImpl;
import de.gothaer.application.container.internal.sequential.IntArrayFillerSequentialImpl;
import de.gothaer.application.generator.IntGeneratorBuilder;
import de.gothaer.application.generator.internal.random.RandomGeneratorBuilderImpl;
import de.gothaer.application.time.internal.StopwatchImpl;

public class Bootstrap {

    public void startApplication() {
        for (int treadCount = 1; treadCount <= Runtime.getRuntime().availableProcessors() + 1; treadCount++) {
            run(treadCount);
        }
    }

    private void run(final int treadCount) {

        System.out.print("Running with " + treadCount + " threads...");

        IntGeneratorBuilder generatorBuilder = createIntGeneratorBuilder();
        IntArrayFiller arrayFiller = createIntFiller(generatorBuilder, treadCount);
        Client client = createClient(arrayFiller);
        client.doSomethingWithLargeArray();

    }

    private static IntGeneratorBuilder createIntGeneratorBuilder() {
        return new RandomGeneratorBuilderImpl();
    }

    private static IntArrayFiller createIntFiller(IntGeneratorBuilder generatorBuilder, final int treadCount) {
        IntArrayFiller result;
        if(treadCount == 1)
            result = new IntArrayFillerSequentialImpl(generatorBuilder.create());
        else
            result = new IntArrayFillerParallelImpl(treadCount, generatorBuilder);

        result = new IntArrayFillerBenchmarkDecorator(result, new StopwatchImpl());
        return result;
    }

    private static Client createClient(IntArrayFiller arrayFiller) {
        return new ClientImpl(arrayFiller);

    }

}

package de.gothaer.application.container.internal.parallel;


import de.gothaer.application.container.IntArrayFiller;
import de.gothaer.application.generator.IntGenerator;
import de.gothaer.application.generator.IntGeneratorBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class IntArrayFillerParallelImpl implements IntArrayFiller {


    private int[] arrayToFill;
    private ExecutorService service;
    private int partitionSize;
    private final int runnningThreadCount;
    private final IntGeneratorBuilder generatorBuilder;

    public IntArrayFillerParallelImpl(final int runnningThreadCount, final IntGeneratorBuilder generatorBuilder) {
        this.runnningThreadCount = runnningThreadCount;
        this.generatorBuilder = generatorBuilder;
    }

    @Override
    public int[] fillArray(int[] arrayToFill) {
        this.arrayToFill = arrayToFill;
        calculatePartitionSize();
        tryToFillArrayParallel();
        return arrayToFill;
    }

    private void calculatePartitionSize() {
        partitionSize = arrayToFill.length / runnningThreadCount;
    }

    private void tryToFillArrayParallel() {

        try {
            fillArrayParallel();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }

    private void fillArrayParallel() throws InterruptedException{

        initializeThreadHolder();
        addWorkersToThreads();
        joinThreads();
    }

    private void initializeThreadHolder(){
        service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }
    
    private void addWorkersToThreads() {
        for (int actThread = 0; actThread < runnningThreadCount; actThread++) {
            startSingleWorkerForSegment(actThread);
        }
    }
    
    private void joinThreads() throws InterruptedException {
        service.shutdown();
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
    }

    private void startSingleWorkerForSegment(final int actThread) {


            // TODO separate Segment Logic or Spliterator

            final int start = actThread *partitionSize;
            final int end = start+partitionSize;
            service.execute(new FillSegmentWorker(start, end));

    }



    private class FillSegmentWorker implements Runnable{
        private final IntGenerator generator = generatorBuilder.create();
        private final int start;
        private final int end;

        public FillSegmentWorker(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {

            for (int i = start; i < end; i++) {
                arrayToFill[i] = generator.next();
            }
        }
    }

}

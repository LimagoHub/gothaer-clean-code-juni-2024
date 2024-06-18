package de.gothaer.application;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        for(int threaCount = 1; threaCount<= Runtime.getRuntime().availableProcessors() + 1; threaCount++) {

            //

        }


        IntStream stream = IntStream.of(10,20,30);

        stream.filter(z->z>10);


        final int [] data = new int[Integer.MAX_VALUE / 2];
        final Random random = new Random();

        var start = Instant.now();

        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt();
        }
        var end = Instant.now();

        var duration = Duration.between(start, end);

        System.out.println("Duration = " + duration.toMillis());
    }
}
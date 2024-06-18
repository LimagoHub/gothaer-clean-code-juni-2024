package de.gothaer.application.time.internal;


import de.gothaer.application.time.Stopwatch;

import java.time.Duration;
import java.time.Instant;

public class StopwatchImpl implements Stopwatch {

    private Instant start;
    private Instant end;
    @Override
    public void start() {
        start = Instant.now();
    }

    @Override
    public void stop() {
        end = Instant.now();
    }

    @Override
    public Duration getDuration() {
        return Duration.between(start, end);
    }
}

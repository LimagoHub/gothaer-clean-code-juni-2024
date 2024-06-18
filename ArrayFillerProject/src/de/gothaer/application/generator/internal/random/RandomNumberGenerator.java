package de.gothaer.application.generator.internal.random;


import de.gothaer.application.generator.IntGenerator;

import java.util.Random;

public class RandomNumberGenerator implements IntGenerator {
    private final Random random = new Random();


    @Override
    public int next() {
        return random.nextInt();
    }
}

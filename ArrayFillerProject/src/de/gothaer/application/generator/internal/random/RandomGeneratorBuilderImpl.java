package de.gothaer.application.generator.internal.random;


import de.gothaer.application.generator.IntGenerator;
import de.gothaer.application.generator.IntGeneratorBuilder;

public class RandomGeneratorBuilderImpl implements IntGeneratorBuilder {
    @Override
    public IntGenerator create() {
        return new RandomNumberGenerator();
    }
}

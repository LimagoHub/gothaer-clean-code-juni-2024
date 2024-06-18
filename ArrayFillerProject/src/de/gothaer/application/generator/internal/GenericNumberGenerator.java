package de.gothaer.application.generator.internal;


import de.gothaer.application.generator.IntGenerator;

import java.util.function.Function;

public class GenericNumberGenerator implements IntGenerator {

    private int oldValue;
    private Function<Integer,Integer> myFunction;

    public GenericNumberGenerator(int seed, Function<Integer, Integer> myFunction) {
        this.oldValue = seed;
        this.myFunction = myFunction;
    }

    @Override
    public int next() {
        int result = oldValue;
        oldValue = myFunction.apply(result);
        return result;
    }
}

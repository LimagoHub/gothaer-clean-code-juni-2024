package de.application.application.model.mandel;

import de.application.application.converter.ComplexToIntegerConverter;
import de.application.application.math.Complex;

public class ComplexToIntegerConverterMandelbrotImpl implements ComplexToIntegerConverter {
    @Override
    public int convert(final Complex complex) {
        final int MAXITER = 255;
        int retval = 0;
        Complex z = new Complex();
        while(z.abs() < 2 ) {
            z = z.times(z);
            z = z.plus(complex);
            retval ++;
            if (retval > MAXITER) return 0;
        }
        return retval;
    }
}

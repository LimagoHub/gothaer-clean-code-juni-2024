package de.application.application.converter;

import de.application.application.converter.internal.CoordinatesToComplexConverterImpl;
import de.application.application.math.Complex;

public interface CoordinatesToComplexConverter {

    Complex convertToComplex(final int x, final int y);
    static CoordinatesToComplexConverter newInstance(Complex linkeUntereEcke, double breite, int size) {
        return new CoordinatesToComplexConverterImpl(linkeUntereEcke, breite, size);
    }
}

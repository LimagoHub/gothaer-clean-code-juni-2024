package de.application.application.converter.internal;

import de.application.application.converter.CoordinatesToComplexConverter;
import de.application.application.math.Complex;

public class CoordinatesToComplexConverterImpl implements CoordinatesToComplexConverter {

    private final Complex linkeUntereEcke;
    private final double breite;
    private final int pixelSize;

    public CoordinatesToComplexConverterImpl(final Complex linkeUntereEcke, final double breite, final int pixelSize) {
        this.linkeUntereEcke = linkeUntereEcke;
        this.breite = breite;
        this.pixelSize = pixelSize;
    }

    @Override
    public Complex convertToComplex(final int x, final int y) {
        double delta = breite / (double) pixelSize;
        return new Complex(linkeUntereEcke.re() + x * delta, linkeUntereEcke.im() + y * delta);
    }


}

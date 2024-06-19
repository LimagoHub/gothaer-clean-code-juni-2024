package de.application.application.model.mandel;

import de.application.application.converter.IntToRGBConverter;

import java.awt.*;

public class IntToRGBConverterMandelImpl implements IntToRGBConverter {
    @Override
    public int convertIntToRGB(final int value) {


        final int rot = (value * 3) % 256;
        final int gruen = (value * 5) % 256;
        final int blau = (value * 11) % 256;
        return (rot << 16) | (gruen << 8) | blau;
    }
}

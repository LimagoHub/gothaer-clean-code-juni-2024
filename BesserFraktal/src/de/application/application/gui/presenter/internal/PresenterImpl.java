package de.application.application.gui.presenter.internal;

import de.application.application.converter.ComplexToIntegerConverter;
import de.application.application.converter.CoordinatesToComplexConverter;
import de.application.application.converter.IntToRGBConverter;
import de.application.application.gui.GenericPixelView;
import de.application.application.gui.presenter.Presenter;
import de.application.application.math.Complex;

import java.util.ArrayDeque;
import java.util.Deque;

public class PresenterImpl implements Presenter {

    private final Deque<CoordinatesToComplexConverter> pixelToComplexConverters = new ArrayDeque<>();
    private GenericPixelView view;
    private final ComplexToIntegerConverter complexToIntegerConverter;
    private CoordinatesToComplexConverter coordinatesToComplexConverter;
    private final IntToRGBConverter intToRGBConverter;
    private final int size;

    public PresenterImpl(final ComplexToIntegerConverter complexToIntegerConverter, final CoordinatesToComplexConverter coordinatesToComplexConverter, final IntToRGBConverter intToRGBConverter, final int size) {
        this.complexToIntegerConverter = complexToIntegerConverter;
        this.coordinatesToComplexConverter = coordinatesToComplexConverter;
        this.intToRGBConverter = intToRGBConverter;
        this.size = size;
    }

    @Override
    public void setGenericPixelView(final GenericPixelView genericPixelView) {
        this.view = genericPixelView;
    }

    @Override
    public void populateView() {
        calculatePixel();
    }

    @Override
    public void onClose() {
        view.close();
    }

    @Override
    public void onZoomIn(final int x1, final int y1, final int x2, final int y2) {
        Complex linkeUntereEcke = coordinatesToComplexConverter.convertToComplex(x1,y1);
        Complex rechteObereEcke = coordinatesToComplexConverter.convertToComplex(x2,y2);
        double neueBreite = getNeueBreite(rechteObereEcke, linkeUntereEcke);
        pixelToComplexConverters.push(coordinatesToComplexConverter);
        coordinatesToComplexConverter = CoordinatesToComplexConverter.newInstance(linkeUntereEcke,neueBreite, size);
        calculatePixel();
    }

    @Override
    public void onZoomOut() {
        if( pixelToComplexConverters.isEmpty()) return ;

        coordinatesToComplexConverter=pixelToComplexConverters.pop();
        calculatePixel();

    }

    private void calculatePixel (){

       ;
        final int [] feld = new int[size * size];
        for( int x = 0 ; x < size ; x ++) {
            for(int y = 0; y < size; y ++) {
                Complex c = coordinatesToComplexConverter.convertToComplex(x,y);

                int pixelValue = complexToIntegerConverter.convert(c);

                int farbwert = intToRGBConverter.convertIntToRGB(pixelValue);
                feld[x + y * size] = farbwert;
            }
        }
        view.setPixel(feld);
    }
    private static double getNeueBreite(Complex rechteObereEcke, Complex linkeUntereEcke) {
        double breite = rechteObereEcke.re() - linkeUntereEcke.re();
        double hoehe = rechteObereEcke.im() - linkeUntereEcke.im();
        return Math.max(breite,hoehe);

    }
}

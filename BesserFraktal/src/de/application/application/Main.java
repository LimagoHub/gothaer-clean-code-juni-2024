package de.application.application;

import de.application.application.converter.ComplexToIntegerConverter;
import de.application.application.converter.CoordinatesToComplexConverter;
import de.application.application.converter.IntToRGBConverter;
import de.application.application.gui.GenericPixelView;
import de.application.application.gui.internal.GenericPixelViewAwtImpl;
import de.application.application.gui.presenter.Presenter;
import de.application.application.gui.presenter.internal.PresenterImpl;
import de.application.application.math.Complex;
import de.application.application.model.mandel.ComplexToIntegerConverterMandelbrotImpl;
import de.application.application.model.mandel.IntToRGBConverterMandelImpl;

public class Main {
    public static void main(String[] args) {

        final int size = 500;
        final ComplexToIntegerConverter complexToIntegerConverter = new ComplexToIntegerConverterMandelbrotImpl();
        final CoordinatesToComplexConverter coordinatesToComplexConverter = CoordinatesToComplexConverter.newInstance(new Complex(-2.0, -1.25), 2.5, size);
        final IntToRGBConverter intToRGBConverter = new IntToRGBConverterMandelImpl();

        final Presenter presenter = new PresenterImpl(complexToIntegerConverter,coordinatesToComplexConverter,intToRGBConverter, size);
        final GenericPixelView view = new GenericPixelViewAwtImpl(size);

        presenter.setGenericPixelView(view);
        view.setPresenter(presenter);

        presenter.populateView();

        view.show();

    }
}
package de.application.application.gui;

import de.application.application.gui.presenter.Presenter;

public interface GenericPixelView {


    void setPresenter(Presenter presenter);
    void setPixel(int [] pixelArray);
    void show();
    void close();

}

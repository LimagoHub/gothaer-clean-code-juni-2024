package de.application.application.gui.presenter;

import de.application.application.gui.GenericPixelView;

public interface Presenter {

    void setGenericPixelView(GenericPixelView genericPixelView);
    void populateView();

    void onClose();
    void onZoomIn(int x1, int y1, int x2, int y2);
    void onZoomOut();

}

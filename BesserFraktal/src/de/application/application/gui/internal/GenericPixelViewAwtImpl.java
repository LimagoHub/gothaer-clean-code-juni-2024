package de.application.application.gui.internal;

import de.application.application.gui.GenericPixelView;
import de.application.application.gui.presenter.Presenter;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class GenericPixelViewAwtImpl implements GenericPixelView {

    private final int size;
    private final BufferedImage image;
    private Presenter presenter;

    private Fenster myWindow = new Fenster();
    public GenericPixelViewAwtImpl(final int size) {
        this.size = size;
        image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        myWindow.setSize(size,size);
        myWindow.setResizable(false);
    }

    @Override
    public void setPresenter(final Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setPixel(final int[] pixelArray) {
        image.setRGB(0,0,size,size, pixelArray,0, size);
        myWindow.repaint();
    }

    @Override
    public void show() {
        myWindow.setVisible(true);
    }

    @Override
    public void close() {
        myWindow.dispose();
    }

    private class MyMouseListener extends MouseAdapter {
        private int x;
        private int y;
        @Override
        public void mousePressed(MouseEvent e) {
            x = e.getX();
            y = e.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1) {
                presenter.onZoomIn(x,y, e.getX(),e.getY());
            }
            else {
                presenter.onZoomOut();
            }

        }
    }


    private class Fenster extends Frame {

        public Fenster()  {
            setSize(size,size);
            addMouseListener(new MyMouseListener());
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    close();
                }
            });
        }

        @Override
        public void paint(Graphics g) {

            g.drawImage(image,0,0,this);
        }
    }
}

package de.limago;

import java.awt.*;
import java.awt.event.*;


public class Fenster  {


    private Frame myWindow = new Frame();


    public Fenster()  {

        myWindow.setSize(300, 300);
        Button button = new Button("Drück mich");
        button.addActionListener(e->ausgabe());
        myWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                // Speichern von daten
                beenden();
            }
        });
        myWindow.add(button);
        myWindow.setVisible(true);

    }


    private void beenden() {
        myWindow.dispose();
    }

    private void ausgabe() {
        System.out.println("Button wurde gedrückt!");
    }


    public static void main(String[] args) {

        new Fenster();
    }




   /* private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent e) {
           ausgabe();
        }
    }*/
}

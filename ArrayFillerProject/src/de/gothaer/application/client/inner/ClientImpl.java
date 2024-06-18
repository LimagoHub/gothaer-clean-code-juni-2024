package de.gothaer.application.client.inner;


import de.gothaer.application.client.Client;
import de.gothaer.application.container.IntArrayFiller;

public class ClientImpl implements Client {

    private int field[] = new int[Integer.MAX_VALUE / 32];
    private final IntArrayFiller arrayFiller;

    public ClientImpl(IntArrayFiller arrayFiller) {
        this.arrayFiller = arrayFiller;
    }

    @Override
    public void doSomethingWithLargeArray() {
        //System.out.println("Showing first 10 values of Array");
        arrayFiller.fillArray(field);

//        for (int i = 0; i < 10; i++) {
//            System.out.println(field[i]);
//        }
    }
}

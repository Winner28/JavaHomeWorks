package Module_Two.Task_Two;


import Module_Two.Task_One.Color;
import Module_Two.Task_Two.Stuff_List.Notebooks;
import Module_Two.Task_Two.Stuff_List.OtherStuff;
import Module_Two.Task_Two.Stuff_List.Pen;
import Module_Two.Task_Two.Stuff_List.Stuff;

import java.util.Comparator;

/**
 * Stationery
 * @author  vlaDey
 * @version 1.0
 */


public class Stationery implements StationeryOperations {


    private final int standartLists = 48;
    private final Color standartColor = Color.BLUE;

    private Pen pens[];
    private int pen_next = 0;


    private Notebooks notebooks[];
    private int notebook_next = 0;


    private OtherStuff<Stuff> otherStuff;

    private OtherStuff<Stuff> allStuff;


    public Stationery(int pens_size, int notebooks_size) {

        pens = new Pen[pens_size];
        notebooks = new Notebooks[notebooks_size];
        otherStuff = new OtherStuff<Stuff>();

    }

    public Stationery() {
        pens = new Pen[3];
        notebooks = new Notebooks[3];
        otherStuff = new OtherStuff<Stuff>();
    }


    @Override
    public void addOtherStuff(int price, String name) {
        otherStuff.add(new Stuff().setPrice(price).setName(name));

    }


    @Override
    public void addPensWithFixedPriceAndName(int price, String name) {

        for (int i = 0; i < pens.length; i++) {
            pens[i] = new Pen().setColor(standartColor).setPrice(30).setName(name);
        }

        pen_next = pens.length;
    }

    @Override
    public void addNotebookWithFixedPriceAndName(int price, String name) {

        for (int i = 0; i < notebooks.length; i++) {
            notebooks[i] = new Notebooks().setList_count(standartLists).setName(name).setPrice(price);
        }

        notebook_next = notebooks.length;
    }


    @Override
    public void addPen(int price, String name, Color color) {

        if (pen_next >= pens.length) {
            // pens[pen_next++] = new Pen().setPrice(price).setColor(color).setName(name);
            System.out.println("Размер ручек ограничен!");
            return;
        }

        pens[pen_next++] = new Pen().setColor(color).setPrice(price).setName(name);

    }

    @Override
    public void addNote(int price, String name, int lists) {

        if (notebook_next >= notebooks.length) {
            // notebooks[notebook_next++] = new Notebooks().setList_count(lists).setName(name).setPrice(price);
            System.out.println("Размер тетрадей ограничен!");
            return;
        }

        notebooks[notebook_next++] = new Notebooks().setList_count(lists).setPrice(price).setName(name);
    }

    @Override
    public void showPenList() {

        for (Pen pen : pens)
            System.out.println(pen.toString());
    }


    @Override
    public void showNotebookList() {

        for (Notebooks notebook : notebooks)
            System.out.println(notebook.toString());
    }


    @Override
    public void showOtherStuffList() {

        for (int i = 0; i < otherStuff.getSize(); i++) {
            System.out.println(otherStuff.get(i));
        }

    }

    @Override
    public int getFullPrice() {
        int result = 0;

        for (Pen pen : pens)
            result += pen.getPrice();

        for (Notebooks notebook : notebooks)
            result += notebook.getPrice();


        for (int i = 0; i < otherStuff.getSize(); i++) {
            result += otherStuff.get(i).getPrice();
        }

        return result;
    }



    private void convertToAllStuff() {
        allStuff = new OtherStuff<>(otherStuff.getSize() + pens.length + notebooks.length);
        for (Pen pen: pens)
            allStuff.add(pen);

        for (Notebooks notebook: notebooks)
            allStuff.add(notebook);


        allStuff.add(otherStuff);
    }


    public void showAllStuff() {
        convertToAllStuff();
        for (int i =0; i<allStuff.getSize(); i++) {
            System.out.println(allStuff.get(i));
        }
    }


}

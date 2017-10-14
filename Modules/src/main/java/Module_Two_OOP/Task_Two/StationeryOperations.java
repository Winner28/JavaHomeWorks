package Module_Two_OOP.Task_Two;

import Module_Two_OOP.Task_One.Color;

public interface StationeryOperations {

    void addPensWithFixedPriceAndName(int price, String name);
    void addNotebookWithFixedPriceAndName(int price, String name);
    void addPen(int price, String name, Color color);
    void addNote(int price, String name, int lists);
    void addOtherStuff(int price, String name);
    void showPenList();
    void showNotebookList();
    void showOtherStuffList();
    int getFullPrice();

}

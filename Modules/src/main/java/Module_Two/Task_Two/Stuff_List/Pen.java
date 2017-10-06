package Module_Two.Task_Two.Stuff_List;

import Module_Two.Task_One.Color;

public class Pen extends Stuff {

    Color color;


    public Pen setColor(Color color) {
        this.color = color;
        return this;
    }


    @Override
    public String toString() {
        return "Thi is Pen. \n" + "Name: " + getStuffName() + " \nPrice: " + getPrice() + "\n" + color;
    }


}

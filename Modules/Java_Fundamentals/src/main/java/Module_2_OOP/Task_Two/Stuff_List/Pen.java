package Module_2_OOP.Task_Two.Stuff_List;

import Module_2_OOP.Task_One.Color;

public class Pen extends Stuff<Pen> {

    private Color color;


    /**
     *
     * @param color
     * @return Pen.this
     */

    public Pen setColor(Color color) {
        this.color = color;
        return this;
    }


    @Override
    public String toString() {
        return "This is Pen. \n" + "Name: " + getStuffName() + " \nPrice: " + getPrice() + "\n" + color;
    }

}

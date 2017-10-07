package Module_Two.Task_ZThree;

import Module_Two.Task_One.Color;
import Module_Two.Task_Two.Stationery;
import Module_Two.Task_Two.Stuff_List.Notebooks;
import Module_Two.Task_Two.Stuff_List.OtherStuff;
import Module_Two.Task_Two.Stuff_List.Pen;
import Module_Two.Task_Two.Stuff_List.Stuff;
import lombok.Getter;

import java.util.List;


@Getter
public class NoviceRecr extends Stationery implements NoviceOperations, Comparable {

    private final String DEFAULT_NAME = "DEFAULT_NAME";
    private final int DEFAULT_PRICE = 30;

    private String last_name;

    private String first_name;

    private int age;

    OtherStuff<Stuff> novice_stuff;

    public NoviceRecr() {
        novice_stuff = new OtherStuff<>();
    }


    public NoviceRecr setAge(int age) {
        this.age = age;
        return this;
    }

    public NoviceRecr setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public NoviceRecr setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }




    @Override
    public void needPen(Color color) {
        novice_stuff.add(new Pen().setName(DEFAULT_NAME).setPrice(DEFAULT_PRICE).setColor(color));
    }

    @Override
    public void needNotebook(int lists) {
        novice_stuff.add(new Notebooks().setName(DEFAULT_NAME).setPrice(DEFAULT_PRICE).setList_count(lists));
    }

    @Override
    public void needOtherStuff(String name, int price) {
        novice_stuff.add(new Stuff().setName(name).setPrice(price));
    }

    @Override
    public void getAllStuff() {

        System.out.printf("Hello dear %s %s! Here is your set:\n", getFirst_name(), getLast_name());
        System.out.println("********************");

        for (int i =0; i<novice_stuff.getSize(); i++) {
            System.out.println(novice_stuff.get(i));
            System.out.println("-------------------");
        }

    }

    @Override
    public int compareTo(Object o) {
        return this.compareTo(o);
    }
}

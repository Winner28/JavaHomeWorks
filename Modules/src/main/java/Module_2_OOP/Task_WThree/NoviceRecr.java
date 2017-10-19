package Module_2_OOP.Task_WThree;

import Module_2_OOP.Task_One.Color;
import Module_2_OOP.Task_Two.Stationery;
import Module_2_OOP.Task_Two.Stuff_List.Notebooks;
import Module_2_OOP.Task_Two.Stuff_List.OtherStuff;
import Module_2_OOP.Task_Two.Stuff_List.Pen;
import Module_2_OOP.Task_Two.Stuff_List.Stuff;
import lombok.Getter;


import java.util.Objects;


@Getter
public class NoviceRecr extends Stationery implements NoviceOperations {

    private final String DEFAULT_NAME = "DEFAULT_NAME";
    private final int DEFAULT_PRICE = 30;

    private String last_name;

    private String first_name;

    private int age;

    private int result_price;

    private OtherStuff<Stuff> novice_stuff;

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
        result_price += DEFAULT_PRICE;
    }

    @Override
    public void needNotebook(int lists) {
        novice_stuff.add(new Notebooks().setName(DEFAULT_NAME).setPrice(DEFAULT_PRICE).setList_count(lists));
        result_price += DEFAULT_PRICE;
    }

    @Override
    public void needOtherStuff(String name, int price) {
        novice_stuff.add(new Stuff().setName(name).setPrice(price));
        result_price += price;
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
    public String toString() {
        return "Recrut: \n" + first_name + " " + last_name;
    }


    @Override
    public int hashCode() {
        int result = 31;

        result = 31*result + first_name.hashCode();
        result = 31*result + last_name.hashCode();
        result = 31*result + result_price;

        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }

        NoviceRecr noviceRecr = (NoviceRecr)object;

        if (Objects.equals(this.last_name, noviceRecr.last_name) && Objects.equals(this.first_name,noviceRecr.first_name)) {
            if (this.novice_stuff.getSize() == noviceRecr.novice_stuff.getSize() && this.result_price == noviceRecr.result_price) {
                for (int i = 0; i<novice_stuff.getSize(); i++) {
                    if (!(this.novice_stuff.get(i).getPrice() == noviceRecr.novice_stuff.get(i).getPrice() &&
                            this.novice_stuff.get(i).getStuffName().equals(noviceRecr.novice_stuff.get(i).getStuffName()))) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}

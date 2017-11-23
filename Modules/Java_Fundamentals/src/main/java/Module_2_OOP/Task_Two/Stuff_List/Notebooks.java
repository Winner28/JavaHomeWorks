package Module_2_OOP.Task_Two.Stuff_List;

public class Notebooks extends Stuff<Notebooks> {

    private int list_count;

    public Notebooks setList_count(int list_count) {
        this.list_count = list_count;
        return this;
    }

    public int getList_count() {
        return list_count;
    }


    @Override
    public String toString() {
        return "This is Notebook. \n" + "Name: " + getStuffName() + " \nPrice: " + getPrice() + "\n" + "+Lists: " + getList_count();
    }

}

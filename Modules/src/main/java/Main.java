import Module_One.TasksFrom_One_To_Five.Task1;
import Module_One.TasksFrom_One_To_Five.Task2;
import Module_Two.Task_One.Color;
import Module_Two.Task_One.Pen;
import Module_Two.Task_Two.Stationery;

public class Main {

    public static void main(String[] args) throws Exception {
        Stationery stationery = new Stationery(10,10);
        stationery.addPensWithFixedPriceAndName(100, "Gelly");
    }

}

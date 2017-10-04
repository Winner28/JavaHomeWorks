import Module_One.TasksFrom_One_To_Five.Task1;
import Module_One.TasksFrom_One_To_Five.Task2;
import Module_Two.Task_One.Color;
import Module_Two.Task_One.Pen;

public class Main {
    public static void main(String[] args) throws Exception {
        Pen pen = new Pen();
        pen.setColor(Color.BLUE);
        pen.setMark("English Mark");
        pen.setPrice(300);
        System.out.println(pen);

        Pen pen1 = new Pen();
        pen1.setColor(Color.DARK);
        pen1.setMark("sd");
        pen1.setPrice(123);

        System.out.println(pen.equals(pen1));
    }

}

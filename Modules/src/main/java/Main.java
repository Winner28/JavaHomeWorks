import Module_Two.Task_One.Color;
import Module_Two.Task_Two.Stationery;
import Module_Two.Task_WThree.NoviceRecr;
import Module_Two.Task_WWFive.Discipline;
import Module_Two.Task_WWFive.University;

public class Main {

    public static void main(String[] args) throws Throwable {

        Stationery stationery = new Stationery();

        stationery.addPen(30, "Gelly", Color.RED);
        stationery.addPen(30, "Gelly", Color.YELLOW);
        stationery.addPen(30, "Gelly", Color.DARK);


        stationery.addNote(15, "Xciv", 49);
        stationery.addNote(15, "Xcyv", 49);
        stationery.addNote(15, "Xyam", 49);

        stationery.addOtherStuff(30, "Karandash");


        NoviceRecr noviceRecr = new NoviceRecr().setAge(15).setFirst_name("Lesha").setLast_name("Anabolik");
        noviceRecr.needNotebook(40);
        noviceRecr.needOtherStuff("Karkakyli", 50);
        noviceRecr.needPen(Color.DARK);

        noviceRecr.getAllStuff();


        University university = new University().setUniversityName("LETI");







    }

}

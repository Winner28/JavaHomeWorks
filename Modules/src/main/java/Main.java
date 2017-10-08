import Module_Two.Task_One.Color;
import Module_Two.Task_Two.Stationery;
import Module_Two.Task_WThree.NoviceRecr;
import Module_Two.Task_WWFive.Discipline;
import Module_Two.Task_WWFive.Mark;
import Module_Two.Task_WWFive.University;
import Module_Two.Task_ZSix_Seven.AtomicBoat;
import Module_Two.Task_ZSix_Seven.Destination;

public class Main {

    public static void main(String[] args) throws Throwable {

       /* Stationery stationery = new Stationery();

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


        university.addStudentInGroup(Discipline.Math, "V", "B", 19);
        university.setStudentMark(Discipline.Math, "V", "B", 19,  new Mark<>().setMark(3));

        university.addStudentInGroup(Discipline.History, "V", "B", 19);
        university.setStudentMark(Discipline.History, "V", "B", 19, new Mark<>().setMark(3.44));

        university.compareScores("V", "B", 19);
*/

        AtomicBoat atomicBoat = new AtomicBoat();
        atomicBoat.swimTo(new Destination().setxDest(5).setyDest(3));

        AtomicBoat.Engine engine = atomicBoat.new Engine();
        engine.startEngine();

        atomicBoat.swimTo(new Destination().setxDest(5).setyDest(3));

        engine.stopEngine();

        atomicBoat.swimTo(new Destination().setyDest(5).setxDest(30));





    }

}

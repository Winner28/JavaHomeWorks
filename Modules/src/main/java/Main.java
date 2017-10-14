import Module_Two_OOP.Task_ZSix_Seven.AtomicBoat;
import Module_Two_OOP.Task_ZSix_Seven.Destination;
import Module_vThree_Strings.Task_One.CrazyLogger;
import Module_vThree_Strings.Task_One.CrazyLoggerApi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

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

   /*     AtomicBoat atomicBoat = new AtomicBoat();
        atomicBoat.swimTo(new Destination().setxDest(5).setyDest(3));

        AtomicBoat.Engine engine = atomicBoat.new Engine();
        engine.startEngine();

        atomicBoat.swimTo(new Destination().setxDest(5).setyDest(3));

        engine.stopEngine();

        atomicBoat.swimTo(new Destination().setyDest(5).setxDest(30));*/


    /*    CrazyLoggerApi crazyLoggerApi = new CrazyLogger();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        String dateInString = "13-10-2017 13:22";
        Date date = simpleDateFormat.parse(dateInString);
        System.out.println(date.toString());*/

    CrazyLogger crazyLogger = new CrazyLogger();
    crazyLogger.writeLog("message");
        System.out.println(crazyLogger.getLogByMessage(""));
    crazyLogger.getLogByMessage("message");



    }

}

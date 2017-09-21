import Task6.Notepad;
import TasksFrom2To5.Task1;
import TasksFrom2To5.Task2;
import TasksFrom2To5.Task3;

public class Main {
    public static void main(String[] args) throws Exception {
        Task1 task1 = new Task1(10,1350);
        task1.solve();

        System.out.println();

        Task2 task2 = new Task2(1,10,1);
        task2.solve();

        System.out.println();

        Task3 task3 = new Task3(3);
        task3.show();

        System.out.println();

        Notepad notepad = new Notepad(5);

        for (int i =0; i<5; i++) notepad.addNote("asd");
        notepad.showAllNotes();
        notepad.dellNote("asd");
        notepad.showAllNotes();



    }

}

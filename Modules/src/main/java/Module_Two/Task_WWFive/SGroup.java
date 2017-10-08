package Module_Two.Task_WWFive;

public class SGroup {

    private MyList<Student> studentList;
    private Discipline discipline;

    public SGroup(Discipline discipline) {
        this.discipline = discipline;
        studentList = new MyList<>();
    }


    public void addStudent(String first, String last, int age) {
        studentList.add(new Student().setAge(age).setDiscipline(this.discipline).setFirst(first).setLast(last));
    }

    public void showStudentsInGroup() {
        System.out.println("GROUP DISCIPLINE: " + discipline);
        System.out.println("-------------------");
        System.out.println("STUDENTS:");
        System.out.println("-------------------");
        for (int i = 0; i < studentList.getSize(); i++) {
            System.out.println(studentList.get(i));
            System.out.println();
            System.out.println("***");
       }
    }

    public void isStudentInGroups(String first, String last, int age) {
        for (int i = 0; i < studentList.getSize(); i++) {
            if (studentList.get(i).equals(new Student().setFirst(first).setLast(last).setAge(age))) {
                System.out.println("STUDENT IN GROUP: " + discipline);
                return;
            }
        }

    }

    public void studentScore(String first, String last, int age) {
        for (int i = 0; i < studentList.getSize(); i++) {
            if (studentList.get(i).equals(new Student().setFirst(first).setLast(last).setAge(age))) {
                System.out.println("STUDENT IN GROUP of " + discipline + " \nHis MARK is: " + studentList.get(i).getI_mark());
                System.out.println("***");
                return;
            }
        }

    }


    public void setStudentMark(String first, String last, int age, Mark<?> mark) {
        for (int i = 0; i < studentList.getSize(); i++) {
            if (studentList.get(i).equals(new Student().setFirst(first).setLast(last).setAge(age))) {
                studentList.get(i).setI_mark(mark);
                return;
            }
        }
        System.out.println("Student not in group!");
    }


    Discipline getDiscipline() {
        return discipline;
    }


    @Override
    public String toString() {
        return "Disc: " + this.getDiscipline();
    }

}

package Module_Two.Task_WWFive;

public class SGroup {

    private MyList<Student> studentList;
    private Discipline discipline;

    public SGroup(Discipline discipline) {
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
       }
    }

    public void isStudentInGroups(String first, String last) {
        for (int i = 0; i < studentList.getSize(); i++) {
            if (studentList.get(i).equals(new Student().setFirst(first).setLast(last))) {
                System.out.println("STUDENT IN GROUP: " + discipline);
                return;
            }
        }
        System.out.println("STUDENT NOT IN GROUP: " + discipline);
    }


    Discipline getDiscipline() {
        return discipline;
    }

}

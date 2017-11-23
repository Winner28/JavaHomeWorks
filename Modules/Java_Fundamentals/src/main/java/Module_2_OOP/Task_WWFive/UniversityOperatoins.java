package Module_2_OOP.Task_WWFive;

public interface UniversityOperatoins {

    void addStudentInGroup(Discipline discipline, String first, String last, int age);
    void showStudentsInGroup(Discipline discipline);
    void showStudentGroups(String first, String last, int age);
    void setStudentMark(Discipline discipline, String first, String last, int age, Mark<?> mark);
    void compareScores(String first, String last, int age);

}


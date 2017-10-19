package Module_2_OOP.Task_WWFive;


public class University implements UniversityOperatoins {


    private final int HISTORY_DISC   = 0;
    private final int MEDECINE_DISC  = 1;
    private final int MATH_DISC      = 2;
    private final int LANGUAGES_DISC = 3;
    private final int SOCIOLOGY_DISC = 4;


    private String universityName;
    private SGroup groups[];



    public University() {

        groups = new SGroup[Discipline.disciplineCounter()];
        groups[HISTORY_DISC] = new SGroup(Discipline.History);
        groups[MEDECINE_DISC] = new SGroup(Discipline.Medecine);
        groups[MATH_DISC] = new SGroup(Discipline.Math);
        groups[LANGUAGES_DISC] = new SGroup(Discipline.Languages);
        groups[SOCIOLOGY_DISC] = new SGroup(Discipline.Sociology);
    }




    @Override
    public void addStudentInGroup(Discipline discipline, String first, String last, int age) {

        switch (discipline) {
            case History:
                groups[HISTORY_DISC].addStudent(first, last, age);
                break;
            case Medecine:
                groups[MEDECINE_DISC].addStudent(first, last, age);
                break;
            case Math:
                groups[MATH_DISC].addStudent(first, last, age);
                break;
            case Languages:
                groups[LANGUAGES_DISC].addStudent(first, last, age);
                break;
            case Sociology:
                groups[SOCIOLOGY_DISC].addStudent(first, last, age);
                break;
        }

    }


    @Override
    public void showStudentsInGroup(Discipline discipline) {


        switch (discipline) {
            case History:
                groups[HISTORY_DISC].showStudentsInGroup();
                break;
            case Medecine:
                groups[MEDECINE_DISC].showStudentsInGroup();
                break;
            case Math:
                groups[MATH_DISC].showStudentsInGroup();
                break;
            case Languages:
                groups[LANGUAGES_DISC].showStudentsInGroup();
                break;
            case Sociology:
                groups[SOCIOLOGY_DISC].showStudentsInGroup();
                break;
        }
    }


    @Override
    public void showStudentGroups(String first, String last, int age) {
        for (int i = 0; i < groups.length; i++) {
            groups[i].isStudentInGroups(first, last, age);
        }
    }


    @Override
    public void setStudentMark(Discipline discipline, String first, String last, int age, Mark<?> mark) {
        switch (discipline) {
            case History:
                groups[HISTORY_DISC].setStudentMark(first, last, age, mark);
                break;
            case Medecine:
                groups[MEDECINE_DISC].setStudentMark(first, last, age, mark);
                break;
            case Math:
                groups[MATH_DISC].setStudentMark(first, last, age, mark);
                break;
            case Languages:
                groups[LANGUAGES_DISC].setStudentMark(first, last, age, mark);
                break;
            case Sociology:
                groups[SOCIOLOGY_DISC].setStudentMark(first, last, age, mark);
                break;
        }
    }


    @Override
    public void compareScores(String first, String last, int age) {
        System.out.printf("Student %s %s\n", first, last);
        System.out.println("---------------");
        for (int i = 0; i < groups.length; i++) {
            groups[i].studentScore(first, last, age);
        }
    }

    @Override
    public String toString() {
        return "University: " + this.universityName;
    }


    public University setUniversityName(String universityName) {
        this.universityName = universityName;
        return this;
    }


}

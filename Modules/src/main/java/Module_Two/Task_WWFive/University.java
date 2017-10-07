package Module_Two.Task_WWFive;

import java.security.acl.Group;


public class University {

    private String universityName;
    private SGroup groups[];
    private int size;

    public University() {
        groups = new SGroup[Discipline.disciplineCounter()];
    }


    public void createGroup(Discipline discipline) {
        checkSize();
        groups[size++] = new SGroup(discipline);
    }


    private void checkSize() {
        if (size >= Discipline.disciplineCounter()) {
            throw new IndexOutOfBoundsException();
        }
    }


    public SGroup getGroup(Discipline discipline) {
        for (SGroup group: groups) {
            if (group.getDiscipline().equals(discipline)) {
                return group;
            }
        }

        return null;
    }


    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

}

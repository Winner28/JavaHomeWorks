package Module_Two.Task_WWFive;


import lombok.Getter;

@Getter
public class Student {

    private Discipline displine;

    private String first;

    private String last;

    private int age;

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public Student setFirst(String first) {
        this.first = first;
        return this;
    }

    public Student setDiscipline(Discipline discipline) {
        this.displine = discipline;
        return this;
    }

    public Student setLast(String last) {
        this.last = last;
        return this;
    }


    @Override
    public String toString() {
        return "Name: " + first + " \nLast name: " + last + "\nAge: " + age;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (this.getClass() != o.getClass())
            return false;

        Student student = (Student)o;


        return this.first.equals(student.first) && this.last.equals(student.last) && this.age == student.age;

    }
}

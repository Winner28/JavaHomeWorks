package Module_Two.Task_WWFive;

public enum Discipline {

    History,
    Medecine,
    Math,
    Sociology,
    Languages;

    @Override
    public String toString() {
        return "Discipline: " + this.name();
    }

    public static int disciplineCounter() {
        return 5;
    }

}

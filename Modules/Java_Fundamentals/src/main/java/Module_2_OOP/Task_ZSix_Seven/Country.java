package Module_2_OOP.Task_ZSix_Seven;

public enum Country {

    USA,
    Russia,
    Ukraine,
    BELORUSSIA;


    @Override
    public String toString() {
        return "Country: " + this.name();
    }
}

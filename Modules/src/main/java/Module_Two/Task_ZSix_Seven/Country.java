package Module_Two.Task_ZSix_Seven;

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

package Module_2_OOP.Task_WWFive;

public class Mark<T extends Number> {

    T mark;

    public Mark<T> setMark(T mark) {
        this.mark =  mark;
        return this;
    }


    public String toString() {
        return String.valueOf(mark);
    }

}

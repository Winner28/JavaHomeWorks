package Module_Two_OOP.Task_ZSix_Seven;

public class Destination {

    private float xDest;

    private float yDest;

    public Destination setxDest(float xDest) {
        this.xDest = xDest;
        return this;
    }

    public Destination setyDest(float yDest) {
        this.yDest = yDest;
        return this;
    }

    @Override
    public String toString() {
        return "...Destination...\n" + "x: " + this.xDest + "\ny:" + this.yDest;
    }
}

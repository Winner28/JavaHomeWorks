package Module_Two.Task_One;


import lombok.*;

/**
 * Pen class
 * @author  vlaDey
 * @version 1.0
 */


@Setter
@Getter
public class Pen {

    private Color color;
    private int price;
    private String mark;

    public Pen() {

    }


    /**
     * @param o
     * @return Equals of the objects
     */
    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (this.getClass() != o.getClass())
            return false;

        if (this.hashCode() != o.hashCode())
            return false;

        Pen pen = (Pen)o;
        return this.mark.equals(pen.mark) &&
                this.price == pen.price &&
                this.color.equals(pen.color);
    }


    /**
     * @return non-negative integer value
     */
    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + price;
        result = 31 * result + color.hashCode();
        result = 31 * result + mark.hashCode();

        return result;
    }


    /**
     * @return String impl
     */
    @Override
    public String toString() {
        return "This is a pen. \nMark: " + mark + "; \nprice: " + price + "; \ncolor: " + color;
    }

}

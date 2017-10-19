package Module_2_OOP.Task_Two.Stuff_List;


import lombok.NoArgsConstructor;



@NoArgsConstructor
public class Stuff<T extends Stuff<T>> {



    private String stuffName;

    private int price;




    public T setPrice(int price) {
        this.price = price;
        return (T) this;
    }




    public T setName(String stuffName) {
        this.stuffName = stuffName;
        return (T) this;
    }




    public int getPrice() {
        return price;
    }



    public String getStuffName() {
        return stuffName;
    }



    @Override
    public String toString() {
        return "Name: " + getStuffName() + " Price: " + getPrice();
    }


}

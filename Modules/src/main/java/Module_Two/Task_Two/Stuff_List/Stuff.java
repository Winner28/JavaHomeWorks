package Module_Two.Task_Two.Stuff_List;


import lombok.NoArgsConstructor;



@NoArgsConstructor
public class Stuff {

    private String stuffName;

    private int price;

   /* public Stuff setPrice(int price) {
        this.price = price;
        return this;
    }*/

    public <T extends Stuff> T setPrice(int price) {
        this.price = price;
        return (T) this;
    }


    public <T extends Stuff> T setName(String stuffName) {
        this.stuffName = stuffName;
        return (T) this;
    }


    public int getPrice() {
        return price;
    }

    public String getStuffName() {
        return stuffName;
    }


}

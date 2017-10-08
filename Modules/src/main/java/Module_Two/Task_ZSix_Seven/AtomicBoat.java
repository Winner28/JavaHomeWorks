package Module_Two.Task_ZSix_Seven;

import lombok.Getter;

@Getter
public class AtomicBoat {

    private String boat_name;

    private Country country;

    private boolean isStarted;

    public AtomicBoat() {

        boat_name = "Ybiica babo4ek";
        country = Country.BELORUSSIA;
        System.out.println("Boat created :)");
    }


    public void swimTo(Destination destination) {

        if (!isStarted) {
            System.out.println("You need to start Engine first!!!");
            return;
        }

        System.out.println("Swiming to " + destination);

    }

    public AtomicBoat setBoat_name(String boat_name) {
        this.boat_name = boat_name;
        return this;
    }

    public AtomicBoat setCountry(Country country) {
        this.country = country;
        return this;
    }


    public  class Engine {

        public Engine() {
            System.out.println("Engine created, may be you wanna test it?");
        }

        public void startEngine() {
            isStarted = true;
            System.out.println("ENGINE OF THIS BOAT STARTED!!!\n" + AtomicBoat.this.toString());
        }

        public void stopEngine() {
            isStarted = false;
            System.out.println("ENGINE STOPPED!!!!!");
        }

    }


    @Override
    public String toString() {
        return "This a atomic boat!!!" + this.country + " Name is... " + this.boat_name + " !!!";
    }

}

package Module_4_IO.Task_wFour.Actor;

import Module_4_IO.Task_wFour.Movie.Movie;

import java.io.Serializable;
import java.util.HashSet;


public class Actor implements Serializable {

    private String firstName;
    private String lastName;
    private int age;
    private int totalPayment;

    private HashSet<Movie> actorMovies;

    public Actor() {
        actorMovies = new HashSet<>(16);
    }


    public Actor setAge(int age) {
        this.age = age;
        return this;
    }


    public Actor setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Actor setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }


    public void addMovie(Movie movie, int payment) {
        actorMovies.add(movie);
        addPay(payment);
    }


    private void addPay(int payment) {
        this.totalPayment += payment;
    }


    public String getLastName() {
        return lastName;
    }

    public void aboutActor() {
        System.out.printf("Actor: %s %s; Age: %d \n Total Cash: %d\n Movies:\n", firstName, lastName, age, totalPayment);
        for (Movie movie : actorMovies) {
            System.out.println(movie);
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;

        Actor actor = (Actor) o;

        return this.firstName == null || this.firstName.equals(actor.firstName);

    }
}

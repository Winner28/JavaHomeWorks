package Module_4_IO.Task_wFour.Movie;

import Module_4_IO.Task_wFour.Actor.Actor;

import java.io.Serializable;
import java.util.HashSet;

public class Movie implements Serializable {

    private HashSet<Actor> actorsInMovie;
    private String movieName;
    private String description;
    private int filmBudget;

    public Movie() {
        actorsInMovie = new HashSet<>();
    }


    public Movie setDescription(String description) {
        this.description = description;
        return this;
    }

    public Movie setMovieName(String movieName) {
        this.movieName = movieName;
        return this;
    }

    public Movie setFilmBudget(int filmBudget) {
        this.filmBudget = filmBudget;
        return this;
    }

    public int getFilmBudget() {
        return filmBudget;
    }

    public String getMovieName() {
        return movieName;
    }


    public void aboutActor(String lastname) {
        for (Actor actor : actorsInMovie) {
            if (actor.getLastName().equals(lastname)) {
                actor.aboutActor();
                return;
            }
        }
        System.out.println("Not such actor");
    }

    public void aboutMovie() {
        System.out.printf("...%s...\n", movieName);
        System.out.println("... " + description + " ...");
        System.out.println("Cast:\n");
        for (Actor actor: actorsInMovie) {
            System.out.println(actor);
        }
    }

    public void addActorToMovie(Actor actor, int payment) {
        if (actorsInMovie.contains(actor)) {
            System.out.println("We already have that actor in our movie!");
            return;
        }
        actorsInMovie.add(actor);
        actor.addMovie(this, payment);
    }






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;

        Movie movie = (Movie)o;

        return this.movieName.equals(movie.movieName) &&
                this.description.equals(movie.description) && this.filmBudget == movie.filmBudget;
    }


    @Override
    public String toString() {
        return movieName;
    }
}

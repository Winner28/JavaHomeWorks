package Module_4_IO.Task_wFour.Hollywood;

import Module_4_IO.Task_wFour.Actor.Actor;
import Module_4_IO.Task_wFour.Hollywood.PictureCreator;
import Module_4_IO.Task_wFour.Movie.Movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Hollywood implements PictureCreator, Serializable {


    private List<Movie> hwMovies;

    public Hollywood() {
        hwMovies = new ArrayList<>(10);
    }

    @Override
    public void createMovie(String movieName, String description, int budget) {
        if (hwMovies.contains(new Movie().setMovieName(movieName).setDescription(description).setFilmBudget(budget))) {
            System.out.println("Movie is already in list!");
        }
        hwMovies.add(new Movie().setMovieName(movieName).setDescription(description).setFilmBudget(budget));
    }

    @Override
    public void addActor(String movieName, Actor actor, int payment) {
        for (Movie movie : hwMovies) {
            if (movie.getMovieName().equals(movieName)) {
                movie.addActorToMovie(actor, payment);
                return;
            }
        }

        System.out.println("We dont have such movie!");
    }

    @Override
    public void aboutActor(String lastname) {
        for (Movie movie : hwMovies) {
            movie.aboutActor(lastname);
        }
    }

    @Override
    public void aboutMovies() {
        aboutHollywood();
    }

    @Override
    public Movie aboutMovie(String movieName) {
        for (Movie movie : hwMovies) {
            if (movie.getMovieName().equals(movieName)) {
                movie.aboutMovie();
                return movie;
            }
        }
        System.out.println("We dont have such movie!");
        return null;
    }

    @Override
    public void getTotalBudget() {
        int budget = 0;
        for (Movie movie : hwMovies) {
            budget+=movie.getFilmBudget();
        }

        System.out.println("Total budget: " + budget);
    }

    public void aboutHollywood() {
        System.out.println("...This is Hollywood...\n We got such films: \n");
        for (Movie movie : hwMovies) {
            System.out.println(movie);
        }

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Movie movie : hwMovies) {
            stringBuilder.append(movie);
        }

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (this.getClass() != object.getClass()) return false;

        Hollywood hw = (Hollywood)object;

        if (hw.hwMovies.size() == 0 && this.hwMovies.size()!=0) {
            return false;
        }
        if (this.hwMovies.size() == hw.hwMovies.size()) {
            for (int i = 0; i < hw.hwMovies.size(); i++) {
                if (!(this.hwMovies.get(i).equals(hw.hwMovies.get(i)))) {
                    return false;
                }
            }
        }
        return true;
    }

}

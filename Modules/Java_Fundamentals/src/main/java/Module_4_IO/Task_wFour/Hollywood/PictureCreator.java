package Module_4_IO.Task_wFour.Hollywood;


import Module_4_IO.Task_wFour.Actor.Actor;
import Module_4_IO.Task_wFour.Movie.Movie;

public interface PictureCreator {

    void createMovie(String movieName, String description, int budget);

    void addActor(String movieName, Actor actor, int payment);

    void aboutActor(String lastname);

    void aboutMovies();

    Movie aboutMovie(String movieName);

    void getTotalBudget();

}

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MovieController {
    HashMap<String,ArrayList<Movie>> city_movies = new HashMap<>();

    public void AddMovieForCity(String city, Movie movie) {
        if (city_movies.get(city) != null) {
            city_movies.get(city).add(movie);
        } else {
            ArrayList<Movie> movie_list = new ArrayList<>();
            movie_list.add(movie);
            city_movies.put(city, movie_list);
        }
    }

    public void getMoviesForACity(String city) {
        List<Movie> movies = new ArrayList<>();
        if (city_movies.get(city) != null) {
            movies = city_movies.get(city);
            for(Movie movie: movies) {
                System.out.printf("City %s is showing movie %s\n", city, movie.getName());
            }
        } else {
            System.out.printf("No movies for city: %s\n", city);
        }
    }

    public Movie getMovie(String city, String movie_name){
        List<Movie> movies = new ArrayList<>();
        if (city_movies.get(city) != null) {
            movies = city_movies.get(city);
            for(Movie movie: movies) {
                if(movie.getName().equals(movie_name)) {
                    return movie;
                }
            }
        } else {
            System.out.printf("No movie named %s in city: %s\n", movie_name, city);
        }
        return null;
    }
}

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TheatreController {
    HashMap<String, ArrayList<Theatre>> city_theatres;

    public TheatreController() {
        city_theatres = new HashMap<>();
    }

    public ArrayList<Theatre> getTheatreFor(String city){
        if(city_theatres.get(city) != null) {
            return city_theatres.get(city);
        }
        System.out.printf("No theatres in this city: %s\n", city);
        return null;
    }

    public void addTheatre(String city, Theatre theatre) {
        if(city_theatres.get(city) != null){
            city_theatres.get(city).add(theatre);
        } else {
            ArrayList<Theatre> theatres = new ArrayList<>();
            theatres.add(theatre);
            city_theatres.put(city, theatres);
        }
    }

    public ArrayList<Theatre> getAllTheatreWithShowsFor(Movie movie, String city) {
        ArrayList<Theatre> theatres = city_theatres.get(city);
        ArrayList<Theatre> valid_theatres = new ArrayList<>();
        if(theatres != null) {
            for(Theatre theatre : theatres){
                ArrayList<Show> shows = theatre.getShows();
                for(Show show: shows) {
                    if(show.getMovie().getName().equals(movie.getName())) {
                        valid_theatres.add(theatre);
                        System.out.printf("%s showing movie %s at %s%n",
                                theatre.getName(), movie.getName(), show.getLocalTime());

                    }
                }
            }
        }
        return valid_theatres;
    }
}

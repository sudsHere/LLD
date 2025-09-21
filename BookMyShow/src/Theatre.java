import java.util.ArrayList;

public class Theatre {
    String name;
    String city;
    ArrayList<Show> shows;
    ArrayList<Screen> screens;

    public Theatre(String name, String city) {
        this.name = name;
        this.city = city;
        this.shows = new ArrayList<>();
        this.screens = new ArrayList<>();
    }

    public void addScreens(Screen screen){
        this.screens.add(screen);
    }

    public void addShows(Show show){
        this.shows.add(show);
    }

    public ArrayList<Show> getShows() {
        return this.shows;
    }

    public String getName() {
        return this.name;
    }
}

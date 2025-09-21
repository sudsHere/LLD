public class Movie {
    int id;
    String name;
    int running_time;

    public Movie(int id, String name, int running_time){
        this.id = id;
        this.name = name;
        this.running_time = running_time;
    }

    public String getName() {
        return this.name;
    }

    public int getRunningTime() {
        return this.running_time;
    }
}

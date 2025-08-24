public class Filters {
    String color;
    int cc;

    public Filters(String color, int cc) {
        this.color = color;
        this.cc = cc;
    }

    public String GetColor() {
        return this.color;
    }

    public int GetCC() {
        return this.cc;
    }
}

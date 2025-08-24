public class Player {
    String name;
    String id;
    int cur_pos;

    public Player(String name, String id) {
        this.name = name;
        this.id = id;
        this.cur_pos = 0;
    }

    public int GetPosition() {
        return this.cur_pos;
    }

    public void SetPosition(int new_pos) {
        this.cur_pos = new_pos;
    }

    public String GetName() {
        return this.name;
    }
}

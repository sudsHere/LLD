import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("ram", "1");
        Player p2 = new Player("shayam", "2");
        Player p3 = new Player("rohit", "3");
        ArrayList<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        Game new_game = new Game(10, 5, 5, 1, players);

        new_game.StartGame();
    }
}
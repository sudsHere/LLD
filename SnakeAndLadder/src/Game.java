import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Game {
    Board board;
    Deque<Player> players = new ArrayDeque<>();;
    Dice dice;

    public Game(int board_size, int snakes, int ladders, int dice_numbers, ArrayList<Player> players) {
        this.board = new Board(board_size, snakes, ladders);
        this.dice = new Dice(dice_numbers);
        this.players.addAll(players);
    }

    public void StartGame() {
        while(true) {
            Player curr_player = this.players.pop();
            int dice_roll = this.dice.RollDice();
            int new_pos = curr_player.cur_pos + dice_roll;
            if(new_pos >= this.board.GetBoardSize()) {
                System.out.printf("Winner: %s\n", curr_player.GetName());
                break;
            }
            int n_row = new_pos/this.board.size;
            int n_column = n_row%2 == 0 ? (new_pos%this.board.size) : (this.board.size - new_pos%this.board.size - 1);
            Cell new_cell = this.board.GetCell(n_row, n_column);
            if(new_cell.is_occupied){
                new_pos = new_cell.jump.GetEnd();
            }
            curr_player.SetPosition(new_pos);
            this.players.add(curr_player);
        }
    }
}

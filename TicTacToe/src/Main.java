import Board.Board;
import Player.Player;
import PlayingPieces.Cross;
import PlayingPieces.Nought;

import java.awt.geom.QuadCurve2D;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Player player1= new Player("P1", new Cross(), 1);
        Player player2= new Player("P2", new Nought(), 2);
        int n = 3;
        Board board = new Board(n);

        Queue<Player> players = new LinkedList<>();
        players.add(player1);
        players.add(player2);

        int total_turns = n*n;
        boolean game_over = false;

        while((total_turns > 0) && !game_over) {
            Player current_player = players.peek();
            System.out.printf("Player %s enter your move", current_player.GetName());
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            scanner.nextLine(); // consume newline
            int column = scanner.nextInt();
            total_turns--;
            boolean piece_placed = board.PlacePiece(row,column,current_player.GetPiece());
            if (piece_placed) {
                players.remove();
                game_over = board.IsWinner(row, column, current_player.GetPiece());
                players.add(current_player);
                if(game_over){
                    System.out.printf("Player %s is winner", current_player.GetName());
                }
            }
        }
        if(total_turns == 0){
            System.out.print("Game Is draw");
        }
        
    }
}
package Board;

import PlayingPieces.PlayingPiece;
import PlayingPieces.PieceType;

public class Board {
    PlayingPiece[][] playingBoard;
    int size;

    public Board(int size){
        this.size = size;
        playingBoard = new PlayingPiece[size][size];
        for(int i=0;i<this.size;i++){
            for(int j=0;j<this.size;j++){
                this.playingBoard[i][j] = new PlayingPiece(PieceType.D);
            }
        }
        PrintBoard();
    }

    public boolean PlacePiece(int i, int j, PlayingPiece piece){
        if (i >= size || j >= size || i < 0 || j < 0) {
            System.out.println("Invalid Input from user");
            return false;
        } else if (playingBoard[i][j].GetPiece() != PieceType.D){
            System.out.println("Invalid input, pos already filled");
            return false;
        } else {
            playingBoard[i][j] = piece;
            PrintBoard();
            return true;
        }
    }

    void PrintBoard(){
        for(int i=0;i<this.size;i++){
            for(int j=0;j<this.size;j++){
                    switch (this.playingBoard[i][j].GetPiece()) {
                        case PieceType.X -> System.out.print('X');
                        case PieceType.O -> System.out.print('O');
                        case PieceType.D -> System.out.print(' ');
                }

                if(j<this.size-1){
                    System.out.print('|');
                }
            }
            System.out.println();
        }
    }

    boolean isWinner(int counts) {
        return counts >= 3;
    }

    public boolean IsWinner(int pos_i, int pos_j, PlayingPiece piece) {
        // check for 3 rows
        if(pos_i - 1 >= 0 && this.playingBoard[pos_i-1][pos_j].GetPiece() == piece.GetPiece()){
            if(pos_i+1 < size && this.playingBoard[pos_i+1][pos_j].GetPiece() == piece.GetPiece()){
                return true;
            }
        }

        int consecutive_count = 1;
        for(int i = pos_i+1; i<this.size; i++){
            if (this.playingBoard[i][pos_j].GetPiece() == piece.GetPiece()) {
                consecutive_count++;
            }
            if (isWinner(consecutive_count)){
                return true;
            }
        }

        consecutive_count = 1;

        for(int i = pos_i-1; i>=0; i--){
            if (this.playingBoard[i][pos_j].GetPiece() == piece.GetPiece()) {
                consecutive_count++;
            }
            if (isWinner(consecutive_count)){
                return true;
            }
        }

        consecutive_count = 1;
        // check for three columns
        if(pos_j - 1 >= 0 && this.playingBoard[pos_i][pos_j-1].GetPiece() == piece.GetPiece()){
            if(pos_j+1 < size && this.playingBoard[pos_i][pos_j+1].GetPiece() == piece.GetPiece()){
                return true;
            }
        }

        for(int j = pos_j+1; j<this.size; j++){
            if (this.playingBoard[pos_i][j].GetPiece() == piece.GetPiece()) {
                consecutive_count++;
            }
            if (isWinner(consecutive_count)){
                return true;
            }
        }

        consecutive_count = 1;

        for(int j = pos_j-1; j>=0; j--){
            if (this.playingBoard[pos_i][j].GetPiece() == piece.GetPiece()) {
                consecutive_count++;
            }
            if (isWinner(consecutive_count)){
                return true;
            }
        }

        consecutive_count = 1;
        // find the diagonal
        for(int i=pos_i+1, j=pos_j+1; i<this.size && j<this.size; i++,j++){
            if(this.playingBoard[i][j].GetPiece() == piece.GetPiece()){
                consecutive_count++;
            }
            if (isWinner(consecutive_count)){
                return true;
            }
        }

        for(int i=pos_i-1, j=pos_j-1; i>=0 && j>=0; i--,j--){
            if(this.playingBoard[i][j].GetPiece() == piece.GetPiece()){
                consecutive_count++;
            }
            if (isWinner(consecutive_count)){
                return true;
            }
        }

        if(pos_i-1 >= 0 && pos_j-1>=0 && this.playingBoard[pos_i-1][pos_j-1].GetPiece() == piece.GetPiece()){
            if(pos_i+1<this.size && pos_j+1<this.size && this.playingBoard[pos_i+1][pos_j+1].GetPiece() == piece.GetPiece()){
                return true;
            }
        }

        if(pos_i-1>=0 && pos_j+1<this.size && this.playingBoard[pos_i-1][pos_j+1].GetPiece() == piece.GetPiece()){
            return pos_i + 1 < this.size && pos_j - 1 >= 0 && this.playingBoard[pos_i + 1][pos_j - 1].GetPiece() == piece.GetPiece();
        }
        return false;
    }
}

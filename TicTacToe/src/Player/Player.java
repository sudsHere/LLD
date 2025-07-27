package Player;

import PlayingPieces.PlayingPiece;

public class Player {
    String name;
    int Id;
    PlayingPiece piece;

    public Player(String name, PlayingPiece piece, int id) {
        this.name = name;
        this.piece = piece;
        this.Id = id;
    }

    public String GetName(){
        return this.name;
    }

    public PlayingPiece GetPiece() {
        return this.piece;
    }
}

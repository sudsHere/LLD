package PlayingPieces;

public class PlayingPiece {
    PieceType piece;

    public PlayingPiece(PieceType type) {
        this.piece = type;
    }

    public PieceType GetPiece(){
        return this.piece;
    }
}

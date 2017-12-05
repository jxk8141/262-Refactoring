import java.util.Vector;

/**
 * Implements behavior of WallPieceState for a King piece
 */
public class WallPieceStateKing extends WallPieceState {

    private Vector moves = new Vector();
    //***Context Variables***//
    private Board board;
    private Vector leftWallPieces;
    private Vector rightWallPieces;
    private int position;
    private boolean jump;
    private int type;
    private Player player;

    /**
     * Accessor for moves
     * @return moves
     */
    public Vector getMoves() {
        return moves;
    }

    /**
     * The constructor using context from Rules.wallPieceMoves
     * @param theBoard Board - the board
     * @param leftWallPieces Vector - all left wall pieces
     * @param rightWallPieces Vector - all right wall pieces
     * @param piecePosition int - the space this piece is positioned on
     * @param jump boolean - making a jump or regular move
     * @param aPlayer Player - the player who owns this piece
     */
    public WallPieceStateKing(Board theBoard, Vector leftWallPieces, Vector rightWallPieces, int piecePosition, boolean jump, Player aPlayer) {
        this.board = theBoard;
        this.leftWallPieces = leftWallPieces;
        this.rightWallPieces = rightWallPieces;
        this.position = piecePosition;
        this.jump = jump;
        this.player = aPlayer;
    }

    /**
     * The behavior for this wall piece state
     */
    public void behavior() {
        boolean adjacentSpace, endSpace;
        Piece aPiece;

        if ( leftWallPieces.contains( new Integer( position ) ) ) {
            if ( jump ) {
                adjacentSpace = board.occupied( position - 7 );
                aPiece = board.getPieceAt( position - 7 );
                if ( adjacentSpace && ( aPiece.getColor() !=
                        player.getColor() ) ) {
                    // Check the space diagonal to the piece to see if it is empty.
                    endSpace = board.occupied( position - 14 );
                    // If the space is empty, there is a multiple jump that must be made.
                    if ( !endSpace ) {
                        moves.addElement( new Integer(position
                                - 14 ) );
                    }
                }
                adjacentSpace = board.occupied( position + 9 );
                aPiece = board.getPieceAt( position + 9 );
                if ( adjacentSpace && ( aPiece.getColor() !=
                        player.getColor() ) ) {
                    // Check the space diagonal to the piece to see if it is empty.
                    endSpace = board.occupied( position + 18 );
                    // If the space is empty, there is a multiple jump that must be made.
                    if ( !endSpace ) {
                        moves.addElement(new Integer( position
                                + 18 ) );
                    }
                }
            }
            // Otherwise check for a regular move, not a jump.
            else {
                adjacentSpace = board.occupied( position - 7 );
                if ( !adjacentSpace ) {
                    moves.addElement( new Integer(position - 7 ) );
                }
                adjacentSpace = board.occupied( position + 9 );
                if ( !adjacentSpace ) {
                    moves.addElement( new Integer( position + 9 ) );
                }
            }
        }
        // If the piece is on the right wall.
        if ( rightWallPieces.contains( new Integer( position ) ) ) {
            if ( jump ) {
                adjacentSpace = board.occupied( position - 9 );
                aPiece = board.getPieceAt( position - 9 );
                if ( adjacentSpace && ( aPiece.getColor() !=
                        player.getColor() ) ) {
                    // Check the space diagonal to the piece to see if it is empty.
                    endSpace = board.occupied( position - 18 );
                    // If the space is empty, there is a multiple jump that must be made.
                    if ( !endSpace ) {
                        moves.addElement( new Integer( position
                                - 18 ) );
                    }
                }
                adjacentSpace = board.occupied(position + 7 );
                aPiece = board.getPieceAt(position + 7 );
                if ( adjacentSpace && ( aPiece.getColor() !=
                        player.getColor() ) ) {
                    // Check the space diagonal to the piece to see if it is empty.
                    endSpace = board.occupied( position + 14 );
                    // If the space is empty, there is a multiple jump that must be made.
                    if ( !endSpace ) {
                        moves.addElement( new Integer( position
                                + 14 ) );
                    }
                }
            }
            else {
                // Otherwise check for a regular move, not a jump.
                adjacentSpace = board.occupied( position - 9 );
                if ( !adjacentSpace ) {
                    moves.addElement( new Integer( position - 9 ) );
                }
                adjacentSpace = board.occupied( position + 7 );
                if ( !adjacentSpace ) {
                    moves.addElement( new Integer( position + 7 ) );
                }
            }
        } // end if the piece is on the right wall.
    } //behavior

} //WallPieceStateKing.java

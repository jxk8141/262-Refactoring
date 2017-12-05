import java.util.Vector;

/**
 * Abstract class to represent WallPieceState
 */
public abstract class WallPieceState {

    /**
     * The empty constructor
     */
    public WallPieceState() {}

    /**
     * Abstract method for getMoves
     * @return Vector
     */
    public abstract Vector getMoves();

    /**
     * Abstract method for behavior
     */
    public abstract void behavior();

} //WallPieceState.java
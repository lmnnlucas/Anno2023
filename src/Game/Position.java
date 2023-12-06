
package Game;
import java.util.Objects;

/**
 * Class that represents a position on the game's grid
 */
public class Position {
    public final int x;
    public final int y;

    /**
     * Constructor for Position
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor for Position
     * @param position Position to copy
     */
    public Position(Position position) {
        this.x = position.x;
        this.y = position.y;
    }

    /**
     * Returns if this position is equals to another object
     * @param o Object to compare
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    /**
     * Returns the hashcode of this position
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Returns the string representation of this position
     */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    /*public boolean inside(Dimension d) {
        return x >= 0 && x < d.width && y >= 0 && y < d.height;
    }*/
}
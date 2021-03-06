import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * A JUnit test that tests the Queen class.
 */
public class QueenTest {
    private Queen queen1;
    private Queen queen2;

    @Before
    public void setUp() {
        queen1 = new Queen(0, 3, Color.BLACK);
        queen2 = new Queen(7, 3, Color.WHITE);
    }

    /**
     * Tests the get row method.
     */
    @Test
    public void getRowTest() {
        assertEquals(0, queen1.getRow());
        assertEquals(7, queen2.getRow());
    }

    /**
     * Tests the getCol method.
     */
    @Test
    public void getColTest() {
        assertEquals(3, queen1.getCol());
        assertEquals(3, queen2.getCol());
    }

    /**
     * Tests the getColor method.
     */
    @Test
    public void getColor() {
        assertEquals(Color.BLACK, queen1.getColor());
        assertEquals(Color.WHITE, queen2.getColor());
    }

    /**
     * Tests the canMove method.
     */
    @Test
    public void canMoveTest() {
        assertTrue(queen1.canMove(7, 3));
        assertTrue(queen1.canMove(3, 0));
//        assertFalse(queen2.canMove(0, 4));
    }

    /**
     * Tests the canKill method.
     */
    @Test
    public void canKill() {
        ChessPiece pawn2 = new Pawn(6, 4, Color.BLACK);
        ChessPiece pawn3 = new Pawn(1, 0, Color.WHITE);
        assertTrue(queen2.canKill(pawn2));
        assertFalse(queen1.canKill(pawn3));
    }
}

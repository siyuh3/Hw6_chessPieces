import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * A Junit test that tests the Rook class.
 */
public class RookTest {
    private Rook rook1;
    private Rook rook2;

    @Before
    public void setUp() {
        rook1 = new Rook(0, 0, Color.BLACK);
        rook2 = new Rook(0, 7, Color.WHITE);
    }

    /**
     * Test the getRow method.
     */
    @Test
    public void getRowTest() {
        assertEquals(0, rook1.getRow());
        assertEquals(0, rook2.getRow());
    }

    /**
     * Tests the getCol method.
     */
    @Test
    public void getColTest() {
        assertEquals(0, rook1.getCol());
        assertEquals(7, rook2.getCol());
    }

    /**
     * Tests the getColor method.
     */
    @Test
    public void getColor() {
        assertEquals(Color.BLACK, rook1.getColor());
        assertEquals(Color.WHITE, rook2.getColor());
    }

    /**
     * Tests the canMove method.
     */
    @Test
    public void canMoveTest() {
        assertTrue(rook1.canMove(0, 1));
        assertFalse(rook1.canMove(0, 0));
    }

    /**
     * Tests the canKill method.
     */
    @Test
    public void canKill() {
        ChessPiece pawn1 = new Pawn(6, 0, Color.WHITE);
        ChessPiece pawn2 = new Pawn(6, 1, Color.WHITE);
        assertTrue(rook1.canKill(pawn1));
        assertFalse(rook1.canKill(pawn2));
    }
}

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * A JUnit test that tests the Pawn class.
 */
public class PawnTest {
    private Pawn pawn1;
    private Pawn pawn2;
    private Pawn pawn3;

    @Before
    public void setUp() {
        pawn1 = new Pawn(1, 0, Color.BLACK);
        pawn2 = new Pawn(6, 0, Color.WHITE);
        pawn3 = new Pawn(1, 1, Color.WHITE);
    }

    /**
     * Tests the get row method.
     */
    @Test
    public void getRowTest() {
        assertEquals(1, pawn1.getRow());
        assertEquals(6, pawn2.getRow());
    }

    /**
     * Tests the getRow method
     */
    @Test
    public void getColTest() {
        assertEquals(0, pawn1.getCol());
        assertEquals(0, pawn2.getCol());
    }

    /**
     * Tests the getCol method.
     */
    @Test
    public void getColor() {
        assertEquals(Color.BLACK, pawn1.getColor());
        assertEquals(Color.WHITE, pawn2.getColor());

    }

    /**
     * Tests the canMove method.
     */
    @Test
    public void canMoveTest() {
        assertTrue(pawn1.canMove(2, 0));
        assertFalse(pawn2.canMove(7, 1));
    }

    /**
     * Tests the canKill method.
     */
    @Test
    public void canKill() {
        assertTrue(pawn1.canKill(new Pawn(2, 0, Color.WHITE)));
        assertTrue(pawn1.canKill(new Pawn(2, 2, Color.WHITE)));

        assertFalse(pawn1.canKill(new Pawn(2, 1, Color.WHITE)));  // Same column
        assertFalse(pawn1.canKill(new Pawn(0, 1, Color.WHITE)));  // Same column
        assertFalse(pawn1.canKill(new Pawn(1, 0, Color.WHITE)));  // Same row
        assertFalse(pawn1.canKill(new Pawn(1, 2, Color.WHITE)));  // Same row
        assertFalse(pawn1.canKill(new Pawn(0, 2, Color.WHITE)));  // Backward
        assertFalse(pawn1.canKill(new Pawn(3, 2, Color.WHITE)));  // More than 2 rows apart
        assertFalse(pawn1.canKill(new Pawn(2, 3, Color.WHITE)));  // More than 2 columns apart
        assertFalse(pawn1.canKill(new Pawn(2, 0, Color.BLACK)));  // Same color


        assertTrue(pawn4.canKill(new Pawn(5, 0, Color.BLACK)));
        assertTrue(pawn4.canKill(new Pawn(5, 2, Color.BLACK)));

        assertFalse(pawn4.canKill(new Pawn(5, 1, Color.BLACK)));  // Same column
        assertFalse(pawn4.canKill(new Pawn(7, 1, Color.BLACK)));  // Same column
        assertFalse(pawn4.canKill(new Pawn(6, 0, Color.BLACK)));  // Same row
        assertFalse(pawn4.canKill(new Pawn(6, 2, Color.BLACK)));  // Same row
        assertFalse(pawn4.canKill(new Pawn(7, 2, Color.BLACK)));  // Backward
        assertFalse(pawn4.canKill(new Pawn(4, 2, Color.BLACK)));  // More than 2 rows apart
        assertFalse(pawn4.canKill(new Pawn(5, 3, Color.BLACK)));  // More than 2 columns apart
        assertFalse(pawn4.canKill(new Pawn(5, 0, Color.WHITE)));  // Same color

    }
}

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
    private Pawn pawn4;
    private Pawn pawn5;

    @Before
    public void setUp() {
        pawn1 = new Pawn(1, 0, Color.BLACK);
        pawn2 = new Pawn(6, 0, Color.WHITE);
        pawn3 = new Pawn(6, 5, Color.WHITE);
        pawn4 = new Pawn(6,1,Color.WHITE);
        pawn5 = new Pawn(1, 1, Color.BLACK);
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
        // True
        assertTrue(pawn1.canMove(2, 0));
        assertTrue(pawn2.canMove(5, 0));

        // False
        assertFalse(pawn1.canMove(1, 0));  // Same spot
        assertFalse(pawn1.canMove(1, 0));  // Backward
        assertFalse(pawn1.canMove(1, 1));  // Same row
        assertFalse(pawn1.canMove(2, 1));  // Different column
        assertFalse(pawn1.canMove(3, 0));  // More than 2 rows apart

        assertFalse(pawn2.canMove(6, 0));  // Same spot
        assertFalse(pawn2.canMove(7, 0));  // Backward
        assertFalse(pawn2.canMove(6, 1));  // Same row
        assertFalse(pawn2.canMove(5, 1));  // Different column
        assertFalse(pawn2.canMove(4, 0));  // More than 2 rows apart
    }

    /**
     * Tests the canKill method.
     */
    @Test
    public void canKill() {
        // Let's double check below. Feel free to delete and recreate an example.
        // True
//        assertTrue(pawn3.canKill(new Pawn(5,4,Color.BLACK)));
//        assertTrue(pawn3.canKill(new Pawn(5,6,Color.BLACK)));
//        // False
//        assertFalse(pawn3.canKill(new Pawn(0,1,Color.BLACK)));
//        assertFalse(pawn3.canKill(new Pawn(0,2,Color.BLACK)));
//        assertFalse(pawn3.canKill(new Pawn(1,0,Color.BLACK)));
//        assertFalse(pawn3.canKill(new Pawn(1,2,Color.BLACK)));
//        assertFalse(pawn3.canKill(new Pawn(2,1,Color.BLACK)));
//        assertFalse(pawn3.canKill(new Pawn(3,3,Color.BLACK)));
    }
}

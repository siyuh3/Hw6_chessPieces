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

    @Before
    public void setUp() {
        pawn1 = new Pawn(1, 0, Color.BLACK);
        pawn2 = new Pawn(6, 0, Color.WHITE);
        pawn3 = new Pawn(1, 1, Color.WHITE);
        pawn4 = new Pawn(6, 1, Color.BLACK);
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
     * Tests the setRow method
     */
    @Test
    public void testSetRow() {
        pawn2.setRow(0);
        assertEquals(0, pawn2.getRow());
        pawn1.setRow(5);
        assertEquals(5, pawn1.getRow());
    }

    /**
     * Tests the Exception in setRow()
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalRow() {
        pawn1.setRow(9);
        pawn2.setRow(-2);
    }

    /**
     * Tests the setColumn method
     */
    @Test
    public void testSetColumn() {
        pawn2.setColumn(0);
        assertEquals(0, pawn2.getCol());
        pawn1.setColumn(5);
        assertEquals(5, pawn1.getCol());
    }

    /**
     * Tests the Exception in setColumn()
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalColumn() {
        pawn1.setColumn(9);
        pawn2.setColumn(-2);
    }

    /**
     * Tests the setColor method
     */
    @Test
    public void testSetColor() {
        pawn1.setColor(Color.BLACK);
        assertEquals(Color.BLACK, pawn1.getColor());
        pawn2.setColor(Color.WHITE);
        assertEquals(Color.WHITE, pawn2.getColor());
    }
    
    
    /**
     * Tests the canMove method.
     */
    @Test
    public void canMoveTest() {
        // True
        assertTrue(pawn1.canMove(0, 0));
        assertTrue(pawn2.canMove(7, 0));

        // False
        assertFalse(pawn1.canMove(1, 0));  // Same spot
        assertFalse(pawn1.canMove(1, 0));  // Backward
        assertFalse(pawn1.canMove(1, 1));  // Same row
        assertFalse(pawn1.canMove(2, 1));  // Different column
        assertFalse(pawn1.canMove(3, 0));  // More than 2 rows apart

        assertFalse(pawn2.canMove(6, 0));  // Same spot
        assertFalse(pawn2.canMove(5, 0));  // Backward
        assertFalse(pawn2.canMove(6, 1));  // Same row
        assertFalse(pawn2.canMove(5, 1));  // Different column
        assertFalse(pawn2.canMove(4, 0));  // More than 2 rows apart
    }

    /**
     * Tests the canKill method.
     */
    @Test
    public void canKill() {
        assertTrue(pawn3.canKill(new Pawn(2, 0, Color.BLACK)));
        assertTrue(pawn3.canKill(new Pawn(2, 2, Color.BLACK)));

        assertFalse(pawn3.canKill(new Pawn(0, 0, Color.BLACK)));
        assertFalse(pawn3.canKill(new Pawn(0, 1, Color.BLACK)));
        assertFalse(pawn3.canKill(new Pawn(0, 2, Color.BLACK)));
        assertFalse(pawn3.canKill(new Pawn(1, 0, Color.BLACK)));
        assertFalse(pawn3.canKill(new Pawn(1, 2, Color.BLACK)));
        assertFalse(pawn3.canKill(new Pawn(2, 0, Color.WHITE))); // same color
        assertFalse(pawn3.canKill(new Pawn(2, 1, Color.BLACK)));
        assertFalse(pawn3.canKill(new Pawn(2, 3, Color.BLACK)));
        assertFalse(pawn3.canKill(new Pawn(3, 2, Color.BLACK)));


        assertTrue(pawn4.canKill(new Pawn(5, 0, Color.WHITE)));
        assertTrue(pawn4.canKill(new Pawn(5, 2, Color.WHITE)));
        assertFalse(pawn4.canKill(new Pawn(4, 2, Color.WHITE)));
        assertFalse(pawn4.canKill(new Pawn(5, 0, Color.BLACK))); // color
        assertFalse(pawn4.canKill(new Pawn(5, 1, Color.WHITE)));
        assertFalse(pawn4.canKill(new Pawn(5, 3, Color.WHITE)));
        assertFalse(pawn4.canKill(new Pawn(6, 0, Color.WHITE)));
        assertFalse(pawn4.canKill(new Pawn(6, 2, Color.WHITE)));
        assertFalse(pawn4.canKill(new Pawn(7, 0, Color.WHITE)));
        assertFalse(pawn4.canKill(new Pawn(7, 1, Color.WHITE)));
        assertFalse(pawn4.canKill(new Pawn(7, 2, Color.WHITE)));
    }
}

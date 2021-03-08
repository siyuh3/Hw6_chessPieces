import org.junit.Test;
import org.junit.Before;

//import java.awt.Color; - i dont think we need this.

import static org.junit.Assert.*;

/**
 * A Junit test that tests the Rook class.
 */
public class RookTest {
    private Rook rook1;
    private Rook rook2;
    private Rook rook3;

    @Before
    public void setUp() {
        rook1 = new Rook(0, 0, Color.BLACK);
        rook2 = new Rook(0, 7, Color.WHITE);
        rook3 = new Rook(4, 4, Color.WHITE);
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
     * Tests the setRow method
     */
    @Test
    public void testSetRow() {
        rook2.setRow(0);
        assertEquals(0, rook2.getRow());
        rook1.setRow(5);
        assertEquals(5, rook1.getRow());
    }

    /**
     * Tests the Exception in setRow()
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalRow() {
        rook1.setRow(9);
        rook2.setRow(-2);
    }

    /**
     * Tests the setColumn method
     */
    @Test
    public void testSetColumn() {
        rook2.setColumn(0);
        assertEquals(0, rook2.getCol());
        rook1.setColumn(5);
        assertEquals(5, rook1.getCol());
    }

    /**
     * Tests the Exception in setColumn()
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalColumn() {
        rook1.setColumn(9);
        rook2.setColumn(-2);
    }

    /**
     * Tests the setColor method
     */
    @Test
    public void testSetColor() {
        rook1.setColor(Color.BLACK);
        assertEquals(Color.BLACK, rook1.getColor());
        rook2.setColor(Color.WHITE);
        assertEquals(Color.WHITE, rook2.getColor());
    }

    /**
     * Tests the canMove method.
     */
    @Test
    public void canMoveTest() {
        assertTrue(rook1.canMove(0, 1));
        assertTrue(rook1.canMove(5, 0));

        assertFalse(rook1.canMove(0, 0));  // same spot
        assertFalse(rook1.canMove(1, 1));  // diag
        assertFalse(rook1.canMove(1, 2));  // L shape
    }

    /**
     * Tests the canKill method.
     */
    @Test
    public void canKill() {
        assertTrue(rook3.canKill(new Rook(2,4, Color.BLACK)));  // down
        assertTrue(rook3.canKill(new Rook(4,3,Color.BLACK)));   // left
        assertTrue(rook3.canKill(new Rook(4,5,Color.BLACK)));   // right
        assertTrue(rook3.canKill(new Rook(5,4,Color.BLACK)));   // up

        assertFalse(rook3.canKill(new Rook(5,3,Color.BLACK))); // diag
        assertFalse(rook3.canKill(new Rook(5,4,Color.WHITE))); // same color test

    }
}

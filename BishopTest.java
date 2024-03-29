import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * A JUnit test that tests the Bishop class.
 */
public class BishopTest {
    private Bishop bishop1;
    private Bishop bishop2;
    private Bishop bishop3;

    @Before
    public void setUp() {
        bishop1 = new Bishop(0, 2, Color.BLACK);
        bishop2 = new Bishop(0, 5, Color.WHITE);
        bishop3 = new Bishop(2, 2, Color.WHITE);
    }

    /**
     * Tests the get row method for the Bishop class.
     */
    @Test
    public void getRowTest() {
        assertEquals(0, bishop1.getRow());
        assertEquals(0, bishop2.getRow());
    }

    /**
     * Tests the get column method.
     */
    @Test
    public void getColTest() {
        assertEquals(2, bishop1.getCol());
        assertEquals(5, bishop2.getCol());
    }

    /**
     * Tests the get color method.
     */
    @Test
    public void getColorTest() {
        assertEquals(Color.BLACK, bishop1.getColor());
        assertEquals(Color.WHITE, bishop2.getColor());
    }

     /**
     * Tests the setRow method
     */
    @Test
    public void testSetRow() {
        bishop2.setRow(0);
        assertEquals(0, bishop2.getRow());
        bishop1.setRow(5);
        assertEquals(5, bishop1.getRow());
    }

    /**
     * Tests the Exception in setRow()
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalRow() {
        bishop1.setRow(9);
        bishop2.setRow(-2);
    }

    /**
     * Tests the setColumn method
     */
    @Test
    public void testSetColumn() {
        bishop2.setColumn(0);
        assertEquals(0, bishop2.getCol());
        bishop1.setColumn(5);
        assertEquals(5, bishop1.getCol());
    }

    /**
     * Tests the Exception in setColumn()
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalColumn() {
        bishop1.setColumn(9);
        bishop2.setColumn(-2);
    }

    /**
     * Tests the setColor method
     */
    @Test
    public void testSetColor() {
        bishop1.setColor(Color.BLACK);
        assertEquals(Color.BLACK, bishop1.getColor());
        bishop2.setColor(Color.WHITE);
        assertEquals(Color.WHITE, bishop2.getColor());
    }

    /**
     * Tests the canMove method
     */
    @Test
    public void testCanMove() {
        assertTrue(bishop1.canMove(3, 5));  // diag
        assertTrue(bishop1.canMove(1, 3));  // diag
        assertFalse(bishop1.canMove(0, 2));  // same spot
        assertFalse(bishop2.canMove(2,5));  // not diag
    }

    /**
     * Tests the canKill method.
     */
    @Test
    public void testCanKill() {
        assertTrue(bishop3.canKill(new Bishop(1,1,Color.BLACK)));   // diag down left
        assertTrue(bishop3.canKill(new Bishop(1,3,Color.BLACK)));   // diag down right
        assertTrue(bishop3.canKill(new Bishop(3,1,Color.BLACK)));   // diag up left
        assertTrue(bishop3.canKill(new Bishop(3,3,Color.BLACK)));   // diag up right

        assertFalse(bishop3.canKill(new Bishop(3,2,Color.BLACK)));  // same column
        assertFalse(bishop3.canKill(new Bishop(1,2,Color.BLACK)));  // same column
        assertFalse(bishop3.canKill(new Bishop(2,1,Color.BLACK)));  // same row
        assertFalse(bishop3.canKill(new Bishop(2,3,Color.BLACK)));  // same row
        assertFalse(bishop3.canKill(new Bishop(3,3,Color.WHITE)));  // same color
        assertFalse(bishop3.canKill(new Bishop(2,2,Color.WHITE)));  // same spot
    }
}

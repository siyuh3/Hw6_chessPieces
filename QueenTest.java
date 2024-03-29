import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * A JUnit test that tests the Queen class.
 */
public class QueenTest {
    private Queen queen1;
    private Queen queen2;
    private Queen queen3;

    @Before
    public void setUp() {
        queen1 = new Queen(0, 3, Color.BLACK);
        queen2 = new Queen(7, 3, Color.WHITE);
        queen3 = new Queen(2, 2, Color.WHITE);
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
     * Tests the setRow method
     */
    @Test
    public void testSetRow() {
        queen2.setRow(0);
        assertEquals(0, queen2.getRow());
        queen1.setRow(5);
        assertEquals(5, queen1.getRow());
    }

    /**
     * Tests the Exception in setRow()
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalRow() {
        queen1.setRow(9);
        queen2.setRow(-2);
    }

    /**
     * Tests the setColumn method
     */
    @Test
    public void testSetColumn() {
        queen2.setColumn(0);
        assertEquals(0, queen2.getCol());
        queen1.setColumn(5);
        assertEquals(5, queen1.getCol());
    }

    /**
     * Tests the Exception in setColumn()
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalColumn() {
        queen1.setColumn(9);
        queen2.setColumn(-2);
    }

    /**
     * Tests the setColor method
     */
    @Test
    public void testSetColor() {
        queen1.setColor(Color.BLACK);
        assertEquals(Color.BLACK, queen1.getColor());
        queen2.setColor(Color.WHITE);
        assertEquals(Color.WHITE, queen2.getColor());
    }

    /**
     * Tests the canMove method.
     */
    @Test
    public void canMoveTest() {
        assertTrue(queen1.canMove(7, 3));  // vertically???
        assertTrue(queen1.canMove(3, 0));  // diagonally
        assertTrue(queen1.canMove(0, 7));  // horizontally???

        assertFalse(queen2.canMove(0, 4));  // invalid move
    }

    /**
     * Tests the canKill method.
     */
    @Test
    public void canKill() {
        assertTrue(queen3.canKill(new Queen(1,1, Color.BLACK)));    // diag moving back left
        assertTrue(queen3.canKill(new Queen(1,2, Color.BLACK)));    // moving back 1 row
        assertTrue(queen3.canKill(new Queen(1,3, Color.BLACK)));    // diag moving back right
        assertTrue(queen3.canKill(new Queen(2,1, Color.BLACK)));    // left
        assertTrue(queen3.canKill(new Queen(2,3, Color.BLACK)));    // right
        assertTrue(queen3.canKill(new Queen(3,1, Color.BLACK)));    // diag moving up left
        assertTrue(queen3.canKill(new Queen(3,2, Color.BLACK)));    // moving up 1 row
        assertTrue(queen3.canKill(new Queen(3,3, Color.BLACK)));    // diag moving up right

        assertFalse(queen3.canKill(new Queen(0,1, Color.BLACK)));   // not diag -- L shape down 2 left 1
        assertFalse(queen3.canKill(new Queen(0,3, Color.BLACK)));   // not diag -- L shape down 2 right 1
        assertFalse(queen3.canKill(new Queen(1,0, Color.BLACK)));   // not diag -- L shape down 1 left 2
        assertFalse(queen3.canKill(new Queen(1,4, Color.BLACK)));   // not diag -- L shape down 1 right 2
        assertFalse(queen3.canKill(new Queen(3,4, Color.BLACK)));   // not diag -- L shape up 1 right 2
        assertFalse(queen3.canKill(new Queen(4,3, Color.BLACK)));   // not diag -- L shape up 2 right 1
        assertFalse(queen3.canKill(new Queen(1,1, Color.WHITE)));   // same color
    }
}

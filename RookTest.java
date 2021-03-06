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
        rook3 = new Rook(4,4,Color.WHITE);
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
        assertTrue(rook3.canKill(new Rook(2,4, Color.BLACK)));
        assertTrue(rook3.canKill(new Rook(3,4, Color.BLACK)));
        assertTrue(rook3.canKill(new Rook(4,3,Color.BLACK)));
        assertTrue(rook3.canKill(new Rook(4,5,Color.BLACK)));
        assertTrue(rook3.canKill(new Rook(4,5,Color.BLACK)));
        assertFalse(rook3.canKill(new Rook(5,3,Color.BLACK)));
        assertFalse(rook3.canKill(new Rook(5,4,Color.WHITE))); // same color test



    }
}

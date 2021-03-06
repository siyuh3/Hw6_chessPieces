import org.junit.Test;
import org.junit.Before;

import java.awt.Color;

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
        pawn3 = new Pawn(1,1, Color.WHITE);
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
        // True
        assertTrue(pawn3.canKill(new Pawn(2,0,Color.BLACK)));
        assertTrue(pawn3.canKill(new Pawn(2,2,Color.BLACK)));
        // False
        assertFalse(pawn3.canKill(new Pawn(0,1,Color.BLACK)));
        assertFalse(pawn3.canKill(new Pawn(0,2,Color.BLACK)));
        assertFalse(pawn3.canKill(new Pawn(1,0,Color.BLACK)));
        assertFalse(pawn3.canKill(new Pawn(1,2,Color.BLACK)));
        assertFalse(pawn3.canKill(new Pawn(2,1,Color.BLACK)));
        assertFalse(pawn3.canKill(new Pawn(3,3,Color.BLACK)));
    }
}

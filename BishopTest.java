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
    private Bishop bishop4;

    @Before
    public void setUp() {
        bishop1 = new Bishop(0, 2, Color.WHITE);
        bishop2 = new Bishop(0, 5, Color.BLACK);
    }

    /**
     * Tests the get row method for the Bishop class.
     */
    @Test
    public void getRowTest() {
        assertEquals(0, bishop1.getRow());
        assertEquals(0,bishop2.getRow());
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
        assertEquals(Color.WHITE, bishop1.getColor());
        assertEquals(Color.BLACK, bishop2.getColor());
    }

    /**
     * Tests the canMove method
     */
    @Test
    public void testCanMove() {
        assertTrue(bishop1.canMove(1, 3));
        assertFalse(bishop2.canMove(2,5));
    }

    /**
     * Tests the canKill method.
     */
    @Test
    public void testCanKill() {
        bishop3 = new Bishop(3, 5, Color.BLACK);
        assertTrue(bishop1.canKill(bishop3));

        //can't kill if row=2, col = 5
        bishop4 = new Bishop(2, 5, Color.WHITE);
        assertFalse(bishop2.canKill(bishop4));
    }
}

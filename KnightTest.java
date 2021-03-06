import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * A JUnit test that tests the Knight class.
 */
public class KnightTest {
    private Knight knight1;
    private Knight knight2;
    private Knight knight3;

    @Before
    public void setUp(){
        knight1 = new Knight(0,1, Color.WHITE);
        knight2 = new Knight(7, 6, Color.BLACK);
        knight3 = new Knight(4,4, Color.WHITE);
    }

    /**
     * Tests the get row method for the Knight class.
     */
    @Test
    public void getRowTest(){
        assertEquals(0, knight1.getRow());
        assertEquals(7, knight2.getRow());
    }

    /**
     * Tests the get column method.
     */
    @Test
    public void getColTest(){
        assertEquals(1, knight1.getCol());
        assertEquals(6, knight2.getCol());
    }

    /**
     * Tests the getColor method.
     */
    @Test
    public void getColor(){
        assertEquals(Color.WHITE, knight1.getColor());
        assertEquals(Color.BLACK, knight2.getColor());
    }

    /**
     * Tests the canMove method.
     */
    @Test
    public void testCanMove(){
        assertFalse(knight1.canMove(0,1));
        assertTrue(knight1.canMove(2, 2));
        assertTrue(knight1.canMove(1, 3));
        assertFalse(knight1.canMove(3, 2));
    }

    /**
     * Tests the canKill method.
     */
    @Test
    public void testCanKill(){
        assertTrue(knight3.canKill(new Knight(2,3,Color.BLACK)));
        assertTrue(knight3.canKill(new Knight(2,5,Color.BLACK)));
        assertTrue(knight3.canKill(new Knight(3,2,Color.BLACK)));
        assertTrue(knight3.canKill(new Knight(3,6,Color.BLACK)));
        assertTrue(knight3.canKill(new Knight(5,2,Color.BLACK)));
        assertTrue(knight3.canKill(new Knight(5,6,Color.BLACK)));
        assertTrue(knight3.canKill(new Knight(6,3,Color.BLACK)));
        assertTrue(knight3.canKill(new Knight(6,5,Color.BLACK)));

        assertFalse(knight3.canKill(new Knight(4,4,Color.BLACK)));
        assertFalse(knight3.canKill(new Knight(2,3,Color.WHITE))); // color case
        assertFalse(knight3.canKill(new Knight(1,1,Color.BLACK)));
        assertFalse(knight3.canKill(new Knight(3,4,Color.BLACK)));
    }
}

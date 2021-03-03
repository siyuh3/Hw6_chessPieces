import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

/**
 * A JUnit test that tests the Knight class.
 */
public class KnightTest {
    private Knight knight1;
    private Knight knight2;

    @Before
    public void setUp(){
        knight1 = new Knight(0,1,Color.BLACK);
    }

    /**
     * Tests the get row method for the Knight class.
     */
    @Test
    public void getRowTest(){
        assertEquals(0, knight1.getRow());
    }

    /**
     * Tests the get column method.
     */
    @Test
    public void getColTest(){
        assertEquals(1, knight1.getCol());
    }

    /**
     * Tests the getColor method.
     */
    @Test
    public void getColor(){
        assertEquals(Color.BLACK, knight1.getColor());
    }

    /**
     * Tests the canMove method.
     */
    @Test
    public void testCanMove(){
        knight1.canMove(0,1);
    }

    /**
     * Tests the canKill method.
     */
    @Test
    public void testCanKill(){
        knight2 = new Knight(7, 1, Color.WHITE);
        knight1.canKill(knight2);
    }
}


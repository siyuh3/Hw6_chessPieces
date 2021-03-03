import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

/**
 * A JUnit test that tests the Bishop class.
 */
public class BishopTest {
    private Bishop bishop1;
    private Bishop bishop2;

    @Before
    public void setUp(){
        bishop1 = new Bishop(0,2,Color.WHITE);
    }

    /**
     * Tests the get row method for the Bishop class.
     */
    @Test
    public void getRowTest(){
        assertEquals(0, bishop1.getRow());
    }

    /**
     * Tests the get column method.
     */
    @Test
    public void getColTest(){
        assertEquals(2, bishop1.getCol());
    }

    /**
     * Tests the get color method.
     */
    @Test
    public void getColorTest(){
        assertEquals(Color.WHITE, bishop1.getColor());
    }
    /**
     * Tests the canMove method
     */
    @Test
    public void testCanMove(){
        bishop1.canMove(1,3);
    }

    /**
     * Tests the canKill method.
     */
    @Test
    public void testCanKill(){
        bishop2 = new Bishop(3,5,Color.BLACK);
        bishop1.canKill(bishop2);
    }
}

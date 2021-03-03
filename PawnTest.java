import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

/**
 * A test that tests the Pawn class.
 */
public class PawnTest {
    private Pawn pawn1;
    private Pawn pawn2;

    @Before
    public void setUp(){
        pawn1 = new Pawn(1,0, Color.WHITE);
    }

    /**
     * Tests the get row method.
     */
    @Test
    public void getRowTest(){
        assertEquals(1, pawn1.getRow());
    }

    /**
     * Tests the getRow method
     */
    @Test
    public void getColTest(){
        assertEquals(0, pawn1.getCol());
    }

    /**
     * Tests the getCol method.
     */
    @Test
    public void getColor(){
        assertEquals(Color.WHITE, pawn1.getColor());
    }

//    @Test
//    public void setRowTest(){
//        assertEquals(2, pawn1.setRow(row));
//    }

//    @Test
//    public void setColumnTest(){
//
//    }

//    @Test
//    public void setColorTest(){
//
//    }

    /**
     * Tests the canMove method.
     */
    @Test
    public void canMoveTest(){
        pawn1.canMove(2,0);
    }

    /**
     * Tests the canKill method.
     */
    @Test
    public void canKill(){
        pawn2 = new Pawn(3,1,Color.BLACK);
        pawn1.canKill(pawn2);
    }
}

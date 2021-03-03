import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

/**
 * A test that tests the Rook class.
 */
public class RookTest {
    private Rook rook1;
    private Rook rook2;

    @Before
    public void setUp(){
        rook1 = new Rook(0,0, Color.WHITE);
    }

    /**
     * Test the getRow method.
     */
    @Test
    public void getRowTest() {
        assertEquals(0, rook1.getCol());
    }

    /**
     * Tests the getCol method.
     */
    @Test
    public void getColTest(){
        assertEquals(0, rook1.getCol());
    }

    /**
     * Tests the getColor method.
     */
    @Test
    public void getColor(){
        assertEquals(Color.WHITE, rook1.getColor());
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
        rook1.canMove(3,0);
    }

    /**
     * Tests the canKill method.
     */
    @Test
    public void canKill(){
        ChessPiece pawn1 = new Pawn(6, 0, Color.BLACK);
        rook1.canKill(pawn1);
    }
}
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

/**
 * A JUnit test that tests the Queen class.
 */
public class QueenTest {
    private Queen queen1;
    private Queen queen2;

    @Before
    public void setUp(){
        queen1 = new Queen(0,4, Color.WHITE);
    }

    /**
     * Tests the get row method.
     */
    @Test
    public void getRowTest(){
        assertEquals(0, queen1.getRow());
    }

    /**
     * Tests the getCol method.
     */
    @Test
    public void getColTest(){
        assertEquals(4, queen1.getCol());
    }

    /**
     * Tests the getColor method.
     */
    @Test
    public void getColor(){
        assertEquals(Color.WHITE, queen1.getColor());
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
        queen1.canMove(1,5);
    }

    /**
     * Tests the canKill method.
     */
    @Test
    public void canKill(){
        ChessPiece pawn2 = new Pawn(6, 4, Color.BLACK);
        queen1.canKill(pawn2);
    }
}

/**
 * @program: Hw6_chessPieces
 * @description:
 * @author: Siyu Hou
 * @create: 2021-02-26 02:41
 **/
public class Queen implements ChessPiece{
    @Override
    public int getRow() {
        return 0;
    }

    @Override
    public int getCol() {
        return 0;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public boolean canMove(int row, int col) {
        return false;
    }

    @Override
    public boolean canKill(ChessPiece piece) {
        return false;
    }
}

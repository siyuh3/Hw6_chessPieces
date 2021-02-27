/**
 * @program: Hw6_chessPieces
 * @description:
 * @author: Siyu Hou
 * @create: 2021-02-26 02:40
 **/
public class Bishop implements ChessPiece{
    private int row;
    private int column;
    private Color color;

    public Bishop(Color color){
        this.row = 0;
        this.column = 0;
        this.color = color;
    }

    public Bishop(int row, int column, Color color){
        this.row = row;
        this.column = column;
        this.color = color;
    }

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

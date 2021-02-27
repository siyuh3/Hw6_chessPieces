/**
 * @program: Hw6_chessPieces
 * @description: This interface contains all operation that all types of chessPieces
 * @author: Siyu Hou
 * @create: 2021-02-26 02:25
 **/
public interface ChessPiece {
    public int getRow();

    public int getCol();

    public Color getColor();

    public boolean canMove(int row, int col);

    public boolean canKill(ChessPiece piece);
}

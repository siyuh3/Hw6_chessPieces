/**
 * @program: Hw6_chessPieces
 * @description: This interface contains all operation that all types of chessPieces
 * @author: Siyu Hou, Kicho Yu
 * @create: 2021-02-26 02:25
 **/
public interface ChessPiece {

    /**
     * @return the row of a chess piece
     */
    public int getRow();

    /**
     * @return the column of a chess piece
     */
    public int getCol();

    /**
     * @return the color of a chess piece
     */
    public Color getColor();

    /**
     * @param row the position in the row between 0 and 7
     * @param col the position in the column between 0 and 7
     * @return true or false whether the current move is able or hindered
     * at the landing location
     */
    public boolean canMove(int row, int col);

    /**
     * @param piece ChessPiece object
     * @return true or false whether the current move can kill a chess piece
     * at the landing location or not
     */
    public boolean canKill(ChessPiece piece);
}

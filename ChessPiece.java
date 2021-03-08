/**
 * @program: Hw6_chessPieces
 * @description: This interface contains operations of all chess pieces
 * @author: Siyu Hou, Kicho Yu, Shuwei Wang, Chance Lamberth
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
     * Sets the row of a chess piece
     */
    public void setRow(int row);

    /**
     * Sets the column of a chess piece
     */
    public void setColumn(int column);

    /**
     * Sets the color of a chess piece
     */
    public void setColor(Color color);
    
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

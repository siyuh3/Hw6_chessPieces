/**
 * @program: Hw6_chessPieces
 * @description:
 * @author: Siyu Hou, Kicho Yu
 * @create: 2021-02-26 02:41
 **/
public class Queen implements ChessPiece, BoardSize {
    private int row;
    private int column;
    private Color color;

    public Queen(int row, int column, Color color) {
        setRow(row);
        setColumn(column);
        setColor(color);
    }

    public Queen() {
        setRow(0);
        setColumn(0);
        setColor(null);
    }

    public Queen(Queen original) {
        setRow(original.getRow());
        setColor(original.getColor());
        setColumn(original.getCol());
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public int getCol() {
        return this.column;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    public void setRow(int row) throws IllegalArgumentException {
        if (row < MIN_ROW || row > MAX_ROW) {
            throw new IllegalArgumentException("The row/column should range from 0 to 7");
        }
        this.row = row;
    }

    public void setColumn(int column) throws IllegalArgumentException {
        if (column < MIN_COL || column > MAX_COL) {
            throw new IllegalArgumentException("The row/column should range from 0 to 7");
        }
        this.column = column;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Determines if a player's queen can move to the given spot
     *
     * @param row the row of the targeted spot
     * @param col the column of the targeted spot
     * @return true if this queen can move to the given targeted spot and
     * false if not
     */
    @Override
    public boolean canMove(int row, int col) {
        // Validates the targeted spot
        if (row < MIN_ROW || row > MAX_ROW || col < MIN_COL || col > MAX_COL) {
            return false;
        }

        // As a queen can move horizontally, vertically, and diagonally, the distance between
        // the targeted spot and the original spot must be the multiple of one, if move vertically
        // or horizontally, or must be the multiple of square root of two, if move diagonally
        // it moves vertically or horizontally, or be square root of two if diagonally
        double distance = Math.sqrt(Math.pow(this.getRow() - row, 2) + Math.pow(this.getCol() - col, 2));
        return distance % Math.sqrt(2) == 0 || distance % 1 == 0;

    /**
     * Determines if a player's chess piece can kill an opponents chess piece.
     *
     * @param piece ChessPiece object opponents chess piece
     * @return true if the opponents piece is a different color and false if not.
     */
    @Override
    public boolean canKill(ChessPiece piece) {
        if (this.color != piece.getColor() & this.canMove(this.getRow(), this.getCol())
                == piece.canMove(piece.getRow(), piece.getCol())) {
            return true;
        }
        return false;
    }
}

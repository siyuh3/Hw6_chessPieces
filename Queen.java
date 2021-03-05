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
        if (row == this.row && col == this.column) return false;

        // Slope formula (y2-y1)/(x2-x1);
        // move diagonally means slope = +-1, move horizontally or vertically means
        // slope = 0;
        int slope = (col - this.getCol()) / (row - this.getRow());
        return (slope == 1 || slope == -1) || (this.getRow() == row) || (this.getCol() == col);
    }

    /**
     * Determines if a player's chess piece can kill an opponents chess piece.
     *
     * @param piece ChessPiece object opponents chess piece
     * @return true if the opponents piece is a different color and false if not.
     */
    @Override
    public boolean canKill(ChessPiece piece) {
        return this.color != piece.getColor() && this.canMove(piece.getRow(), piece.getCol());
    }
}

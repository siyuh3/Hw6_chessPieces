/**
 * @program: Hw6_chessPieces
 * @description: This Class is Bishop class implements the ChessPiece Class, the Bishop should move
 * diagonally, init position is (0, 2) and (0, 5)
 * @author: Siyu Hou, Kicho Yu
 * @create: 2021-02-26 02:40
 **/
public class Bishop implements ChessPiece, BoardSize {
    private int row;
    private int column;
    private Color color;

    public Bishop(int row, int column, Color color) {
        setRow(row);
        setColumn(column);
        setColor(color);
    }

    public Bishop() {
        setRow(0);
        setColumn(2);
        setColor(null);
    }

    public Bishop(Bishop original) throws IllegalArgumentException {
        if (original == null) {
            throw new IllegalArgumentException("Original Bishop cannot be null");
        }
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
     * Determines if a player's bishop can move to the given spot
     *
     * @param row the row of the targeted spot
     * @param col the column of the targeted spot
     * @return true if this bishop can move to the given targeted spot and
     * false if not
     */
    @Override
    public boolean canMove(int row, int col) {
        // Validates the targeted spot
        if (row < MIN_ROW || row > MAX_ROW || col < MIN_COL || col > MAX_COL) {
            return false;
        }
        if (row == this.getRow() && col == this.getCol()) return false;
        // As bishop moves diagonally, the slope between the targeted spot and the
        // original spot must be either 1 or -1
        int slope = (col - this.getCol()) / (row - this.getRow());
        return slope == 1 || slope == -1;
    }

    /**
     * Determines if a player's chess piece can kill an opponents chess piece.
     *
     * @param piece ChessPiece object opponents chess piece.
     * @return true if opponent's piece is a different color and false otherwise.
     */
    @Override
    public boolean canKill(ChessPiece piece) {
        if(this.color != piece.getColor())
        {
            double slope = ((piece.getCol() - this.getCol()) / (double) (piece.getRow() - this.getRow()));
            if (slope == -1.0 || slope == 1.0) {
                return true;
            }
        }
        return false;
    }

    /**
     * main method to try some case
     *
     * @param args array
     */
    public static void main(String[] args) {
        Bishop bishop2 = new Bishop(0, 2, Color.BLACK);
        Bishop bishop4 = new Bishop(3, 5, Color.WHITE);
        System.out.println(bishop2.canMove(3, 5));
        System.out.println(bishop2.canKill(bishop4));
    }
}

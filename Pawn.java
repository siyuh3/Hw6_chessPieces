/**
 * @program: Hw6_chessPieces
 * @description: This class represent the Pawn piece implements ChessPice class and BoardSize class, the Pawn should
 * move only ahead, not backwards towards where its color started. Init position is (0, 0) and(0, 7).
 * @author: Siyu Hou, Kicho Yu
 * @create: 2021-02-26 02:42
 **/
public class Pawn implements ChessPiece, BoardSize {
    private int row;
    private int column;
    private Color color;

    /**
     * Construct a default Row, Column and Color
     */
    public Pawn() {
        setRow(0);
        setColumn(6);
        setColor(Color.WHITE);
    }

    /**
     * Main Constructor that construct Pawn object
     *
     * @param row    pawn in which row
     * @param column pawn in which column
     * @param color  pawn's color
     */
    public Pawn(int row, int column, Color color) {
        setRow(row);
        setColumn(column);
        setColor(color);
    }

    /**
     * The copy constructor use for copy original Pawn
     *
     * @param original original Pawn object
     */
    public Pawn(Pawn original) {
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
     * Determines if a player's pawn can move to the given spot
     *
     * @param row the row of the targeted spot
     * @param col the column of the targeted spot
     * @return true if this pawn can move to the given targeted spot and
     * false if not
     */
    @Override
    public boolean canMove(int row, int col) {
        // Validates the targeted spot
        if (row < MIN_ROW || row > MAX_ROW || col < MIN_COL || col > MAX_COL) {
            return false;
        }
        // A white pawn can only move one unit upward in row
        if (getColor() == Color.WHITE) {
            return this.getCol() == col && (row - this.getRow()) == 1;
        } else {
            // A black pawn can only move one unit downward in row
            return this.getCol() == col && (this.getRow() - row) == 1;
        }

    }

    /**
     * Determines if a player's chess piece can kill an opponents chess piece.
     *
     * @param piece ChessPiece object opponents chess piece
     * @return true if opponent's piece is a different color and false if not.
     */
    @Override
    public boolean canKill(ChessPiece piece) {
        if (this.color != piece.getColor()) {
            int slope = ((piece.getCol() - this.getCol()) /  (piece.getRow() - this.getRow()));
            if (slope == -1 || slope == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Pawn p1 = new Pawn(1,0, Color.WHITE);
        Pawn p2 = new Pawn(2,1,Color.BLACK);
        Pawn p3 = new Pawn(4,4,Color.BLACK);

        System.out.println(p1.canKill(p2)); // true
        System.out.println(p1.canKill(p3)); // false
    }
}

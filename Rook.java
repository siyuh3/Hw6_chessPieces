/**
 * @program: Hw6_chessPieces
 * @description:
 * @author: Siyu Hou, Kicho Yu
 * @create: 2021-02-26 02:41
 **/
public class Rook implements ChessPiece, BoardSize {
    private int row;
    private int column;
    private Color color;

    /**
     * Main Constructor that construct Rook object
     *
     * @param row    pawn in which row
     * @param column pawn in which column
     * @param color  pawn's color
     */
    public Rook(int row, int column, Color color) {
        setRow(row);
        setColumn(column);
        setColor(color);
    }

    /**
     * Construct a default Row, Column and Color
     */
    public Rook() {
        setRow(0);
        setColumn(7);
        setColor(Color.WHITE);
    }

    /**
     * getRow method
     * @return returns the Rook's current row.
     */
    @Override
    public int getRow() {
        return this.row;
    }

    /**
     * getCol method.
     * @return returns the Rook's current column.
     */
    @Override
    public int getCol() {
        return this.column;
    }

    /**
     * getColor method.
     * @return returns the Rook's color - either white or black.
     */
    @Override
    public Color getColor() {
        return color;
    }

    /**
     * setRow method for changing the object's row.
     * @param row changes the object's row with a new row.
     * @throws IllegalArgumentException an error arises when a proposed value is outside the chess board's boundaries.
     */
    @Override
    public void setRow(int row) throws IllegalArgumentException {
        if (row < MIN_ROW || row > MAX_ROW) {
            throw new IllegalArgumentException("The row/column should range from 0 to 7");
        }
        this.row = row;
    }

    /**
     * setCol method for changing the object's column.
     * @param column changes the object's column with a new column.
     * @throws IllegalArgumentException an error arises when a value is outside the chess board's boundaries.
     */
    @Override
    public void setColumn(int column) throws IllegalArgumentException {
        if (column < MIN_COL || column > MAX_COL) {
            throw new IllegalArgumentException("The row/column should range from 0 to 7");
        }
        this.column = column;
    }

    /**
     * setter method for changing the color of the chess piece.
     * @param color changes the color of the chess piece.
     */
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Determines if a player's rook can move to the given spot.
     *
     * @param row the row of the targeted spot
     * @param col the column of the targeted spot
     * @return true if this rook can move to the given targeted spot and
     * false if not
     */
    @Override
    public boolean canMove(int row, int col) {
        // Validates the targeted spot
        if (row < MIN_ROW || row > MAX_ROW || col < MIN_COL || col > MAX_COL) {
            return false;
        }
        // Can't move to original spot
        if (this.getRow() == row && this.getCol() == col) {
            return false;
        }
        // As a rook can move horizontally or vertically
        return (this.getRow() == row) || (this.getCol() == col);
    }

    /**
     * Determines if a player's chess piece can kill an opponents chess piece.
     * @param piece ChessPiece object opponents chess piece.
     * @return true if opponent's piece is a different color and false otherwise.
     */
    @Override
    public boolean canKill(ChessPiece piece) {
        // First step: determine whether two pieces are same color.
        // If they are in same color, return false.
        // If they are not in same color, return true.
        // Second step: When we invoke canKill, it means we check -->
        // Can Piece1 move to Piece2, if "yes" canKill true, if "no" canKill false,
        // SO JUST INVOKE canMove WILL SATISFY OUR NEEDED
        // DON'T COPY CODE FROM canMove
        return this.color != piece.getColor() && this.canMove(piece.getRow(), piece.getCol());
    }


    public static void main(String[] args) {
        Rook rook1 = new Rook(4,4,Color.WHITE);
        System.out.println("TRUE");
        System.out.println(rook1.canKill(new Rook(4,5,Color.BLACK)) + " = True"); //R
        System.out.println(rook1.canKill(new Rook(3,4,Color.BLACK)) + " = True"); // down
        System.out.println(rook1.canKill(new Rook(4,3, Color.BLACK)) + " = True"); //L
        System.out.println(rook1.canKill( new Rook(5, 4, Color.BLACK)) + " = True"); // Up

        System.out.println("\nFALSE");
        System.out.println(rook1.canKill(new Rook(5,3,Color.BLACK)) + " = False");  // diag
        System.out.println(rook1.canKill(new Rook(3,5,Color.BLACK)) + " = False");  // diag
        System.out.println(rook1.canKill(new Rook(4,4,Color.BLACK)) + " = False");  // same spot
    }
}

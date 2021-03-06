/**
 * @program: Hw6_chessPieces
 * @description: this class is Queen class which implements the ChessPiece class
 * @author: Siyu Hou, Kicho Yu
 * @create: 2021-02-26 02:41
 **/
public class Queen implements ChessPiece, BoardSize {
    private int row;
    private int column;
    private Color color;

    /**
     * Constructs a queen piece with a row number, column number, and color.
     * @param row the row number of the queen
     * @param column the column number of the queen
     * @param color the color of the queen which can be either black or white
     */
    public Queen(int row, int column, Color color) {
        setRow(row);
        setColumn(column);
        setColor(color);
    }

    /**
     * Default constructor
     */
    public Queen() {
        setRow(7);
        setColumn(3);
        setColor(Color.WHITE);
    }

    /**
     * Copy constructor
     */
    public Queen(Queen original) {
        setRow(original.getRow());
        setColor(original.getColor());
        setColumn(original.getCol());
    }

    /**
     * getRow method.
     * @return returns the queen's current row.
     */
    @Override
    public int getRow() {
        return this.row;
    }

    /**
     * getCol method.
     * @return returns the queen's current column.
     */
    @Override
    public int getCol() {
        return this.column;
    }

    /**
     * getColor method.
     * @return returns the queen's color -- either white or black.
     */
    @Override
    public Color getColor() {
        return this.color;
    }

    /**
     * setRow method for changing the queen's row.
     * @param row updates the queen's row with a new row.
     * @throws IllegalArgumentException an error arises when a new proposed value is outside the chess board
     */
    public void setRow(int row) throws IllegalArgumentException {
        if (row < MIN_ROW || row > MAX_ROW) {
            throw new IllegalArgumentException("The row/column should range from 0 to 7");
        }
        this.row = row;
    }

    /**
     * setColumn method for changing the queen's column.
     * @param column changes the queen's column to a new column.
     * @throws IllegalArgumentException an error arises when a new proposed
     * value is outside the chess board's boundaries.
     */
    public void setColumn(int column) throws IllegalArgumentException {
        if (column < MIN_COL || column > MAX_COL) {
            throw new IllegalArgumentException("The row/column should range from 0 to 7");
        }
        this.column = column;
    }

    /**
     * setter method for changing the color of the queen.
     * @param color changes the color of the queen.
     */
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
        // Can't move to original spot
        if (row == this.row && col == this.column) {
            return false;
        }

        // Slope formula (y2-y1)/(x2-x1);
        // Slope = rise / run;
        // move diagonally means slope = +-1;
        // move horizontally or vertically means slope = 0;
        int rise = row - this.getRow();
        int run = col - this.getCol();

        // Can move horizontally or vertically
        // "Can't move to original spot" was checked before.
        if (rise * run == 0) {
            return true;
        }
        // Can move diagonally
        else {
            int slope = rise / run;
            return (slope == 1 || slope == -1);
        }
    }

    /**
     * Determines if a player's chess piece can kill an opponents chess piece.
     *
     * @param piece ChessPiece object opponents chess piece
     * @return true if the opponents piece is a different color and false if not.
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
        Queen queen2 = new Queen(3,5, Color.WHITE);
        System.out.println(queen2.canMove(3,4));  // true, horizontal move
        System.out.println(queen2.canMove(4,5));  // true, vertical move
        System.out.println(queen2.canMove(3,5));  // false, same spot

        Queen queen1 = new Queen(2,2, Color.WHITE);

        System.out.println("\nTRUE");
        System.out.println(queen1.canKill(new Queen(1,1, Color.BLACK)) + " = True");
        System.out.println(queen1.canKill(new Queen(1,2, Color.BLACK)) + " = True");
        System.out.println(queen1.canKill(new Queen(1,3, Color.BLACK)) + " = True");
        System.out.println(queen1.canKill(new Queen(2,1, Color.BLACK)) + " = True");
        System.out.println(queen1.canKill(new Queen(2,3, Color.BLACK)) + " = True");
        System.out.println(queen1.canKill(new Queen(3,1, Color.BLACK)) + " = True");
        System.out.println(queen1.canKill(new Queen(3,2, Color.BLACK)) + " = True");
        System.out.println(queen1.canKill(new Queen(3,3, Color.BLACK)) + " = True");

        System.out.println("\nFALSE");
        System.out.println(queen1.canKill(new Queen(0,1, Color.BLACK)) + " = False");
        System.out.println(queen1.canKill(new Queen(0,3, Color.BLACK)) + " = False");
        System.out.println(queen1.canKill(new Queen(1,0, Color.BLACK)) + " = False");
        System.out.println(queen1.canKill(new Queen(1,4, Color.BLACK)) + " = False");
        System.out.println(queen1.canKill(new Queen(3,4, Color.BLACK)) + " = False");
        System.out.println(queen1.canKill(new Queen(4,3, Color.BLACK)) + " = False");
    }
}

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
    /**
     * Constructs a bishop piece with a row number, column number, and color.
     * @param row the row number of the bishop
     * @param column the column number of the bishop
     * @param color the color of the bishop which can be either black or white
     */
    public Bishop(int row, int column, Color color) {
        setRow(row);
        setColumn(column);
        setColor(color);
    }
    
    /**
     * Default constructor
     */
    public Bishop() {
        setRow(7);
        setColumn(2);
        setColor(Color.WHITE);
    }

    /**
     * Copy constructor
     */
    public Bishop(Bishop original) throws IllegalArgumentException {
        if (original == null) {
            throw new IllegalArgumentException("Original Bishop cannot be null");
        }
        setRow(original.getRow());
        setColor(original.getColor());
        setColumn(original.getCol());
    }

    /**
     * getRow method.
     * @return returns the bishop's current row.
     */
    @Override
    public int getRow() {
        return this.row;
    }

    /**
     * getCol method.
     * @return returns the bishop's current column.
     */
    @Override
    public int getCol() {
        return this.column;
    }

    /**
     * getColor method.
     * @return returns the bishop's color -- either white or black.
     */
    @Override
    public Color getColor() {
        return this.color;
    }

    /**
     * setRow method for changing the bishop's row.
     * @param row updates the bishop's row with a new row.
     * @throws IllegalArgumentException an error arises when a new proposed value is outside the chess board
     */
    @Override
    public void setRow(int row) throws IllegalArgumentException {
        if (row < MIN_ROW || row > MAX_ROW) {
            throw new IllegalArgumentException("The row/column should range from 0 to 7");
        }
        this.row = row;
    }

    /**
     * setColumn method for changing the bishop's column.
     * @param column changes the bishop's column to a new column.
     * @throws IllegalArgumentException an error arises when a new proposed
     * value is outside the chess board's boundaries.
     */
    @Override
    public void setColumn(int column) throws IllegalArgumentException {
        if (column < MIN_COL || column > MAX_COL) {
            throw new IllegalArgumentException("The row/column should range from 0 to 7");
        }
        this.column = column;
    }

    /**
     * setter method for changing the color of the bishop.
     * @param color changes the color of the bishop.
     */
    @Override
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

        // Slope formula (y2-y1)/(x2-x1);
        // Slope = rise / run;
        // move diagonally means slope = +-1;
        // move horizontally or vertically means slope = 0 or undefined;

        int rise = row - this.getRow();
        int run = col - this.getCol();
        // Can't move horizontally or vertically
        // Can't move to original spot.
        if (rise * run == 0) {
            return false;
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
        // SO JUST INVOKE canMove WILL SATISFY OUR NEED
        // DON'T COPY CODE FROM canMove
        return this.color != piece.getColor() && this.canMove(piece.getRow(), piece.getCol());
    }

    /**
     * main method to try some case
     * @param args array
     */
    public static void main(String[] args) {
        Bishop bishop1 = new Bishop(2, 2, Color.WHITE);
        System.out.println("TRUE");
        System.out.println(bishop1.canKill(new Bishop(1,1,Color.BLACK)) + " = True");
        System.out.println(bishop1.canKill(new Bishop(1,3,Color.BLACK)) + " = True");
        System.out.println(bishop1.canKill(new Bishop(3,1,Color.BLACK)) + " = True");
        System.out.println(bishop1.canKill(new Bishop(3,3,Color.BLACK)) + " = True");


        System.out.println("\nFALSE");
        System.out.println(bishop1.canKill(new Bishop(3,2,Color.BLACK)) + " = False");
        System.out.println(bishop1.canKill(new Bishop(1,2,Color.BLACK)) + " = False");
        System.out.println(bishop1.canKill(new Bishop(2,1,Color.BLACK)) + " = False");
        System.out.println(bishop1.canKill(new Bishop(2,3,Color.BLACK)) + " = False");
    }
}

/**
 * @program: Hw6_chessPieces
 * @description: This class represents the Pawn piece and implements the ChessPiece Interface and BoardSize Interface,
 *               the Pawn should move forward only from where its color started. Init position is (0, 0) and(0, 7).
 * @author: Siyu Hou, Kicho Yu, Shuwei Wang, Chance Lamberth
 * @create: 2021-02-26 02:42
 **/
public class Pawn implements ChessPiece, BoardSize {
    private int row;
    private int column;
    private Color color;
    private final static int ONE = 1;

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
     * Construct a default Row, Column and Color
     */
    public Pawn() {
        setRow(0);
        setColumn(6);
        setColor(Color.WHITE);
    }

    /**
     * getRow method.
     * @return returns the pawn's current row.
     */
    @Override
    public int getRow() {
        return this.row;
    }

    /**
     * getCol method.
     * @return returns the pawn's current column.
     */
    @Override
    public int getCol() {
        return this.column;
    }

    /**
     * getColor method.
     * @return returns the pawn's color -- either white or black.
     */
    @Override
    public Color getColor() {
        return this.color;
    }

    /**
     * setRow method for changing the pawn's row.
     * @param row updates the pawn's row with a new row.
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
     * setColumn method for changing the pawn's column.
     * @param column changes the pawn's column to a new column.
     * @throws IllegalArgumentException an error arises when a new proposed
     *         value is outside the chess board's boundaries.
     */
    @Override
    public void setColumn(int column) throws IllegalArgumentException {
        if (column < MIN_COL || column > MAX_COL) {
            throw new IllegalArgumentException("The row/column should range from 0 to 7");
        }
        this.column = column;
    }

    /**
     * setter method for changing the color of the pawn.
     * @param color changes the color of the pawn.
     */
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Determines if a player's pawn can move to the given spot
     *
     * @param row the row of the targeted spot
     * @param col the column of the targeted spot
     * @return true if this pawn can move to the given targeted spot and
     *         false if not
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
        // A black pawn can only move one unit downward in row
        // Downward means the bigger number is this.getRow()
        if (this.getColor() == Color.BLACK) {
            return this.getCol() == col && (this.getRow() - row) == ONE;
        } else {
            // A white pawn can only move one unit upward in row
            // Upward means the bigger number is row variable
            return this.getCol() == col && (row - this.getRow()) == ONE;
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
        /*
        - First step: determine whether two pieces are the same color. If they are the same color,
        canKill returns false. Otherwise it continues on.
        - Second step: determine whether the columns differ by 1. Pawns can only kill at a diagonal.
        - Third step: The color is important. White chess pieces are on the bottom and black pieces are on the top.
        White pawns will always increase in row value since move to a greater number row.
        Moreover, Black pawns will always decrease in row value since they start a high row value and move
        to a lower row value. This is due to the graphical representation of the chess board.
         */
        if (this.color == piece.getColor()) {
            return false;
        }
        //determine whether the columns of two pieces differ by 1
        if (Math.abs(this.getCol() - piece.getCol()) == ONE) {

            //Black pawn: determine it moves one unit downward in row
            if ((this.getColor() == Color.BLACK) && ((this.getRow() - piece.getRow()) == ONE)) {
                return true;
            }

            // White pawn: determine it moves one unit upward in row
            else if ((this.getColor() == Color.WHITE) && ((piece.getRow() - this.getRow()) == ONE)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Pawn p1 = new Pawn(1,1, Color.WHITE);
        System.out.println("\nWHITE Pawn");
        System.out.println("\nTRUE:");
        System.out.println(p1.canKill(new Pawn(2,0,Color.BLACK)) + " = True");
        System.out.println(p1.canKill(new Pawn(2,2,Color.BLACK)) + " = True");

        System.out.println("\nFALSE:");
        System.out.println(p1.canKill(new Pawn(2,1,Color.BLACK)) + " = False");  // Same column
        System.out.println(p1.canKill(new Pawn(0,1,Color.BLACK)) + " = False");  // Same column
        System.out.println(p1.canKill(new Pawn(1,0,Color.BLACK)) + " = False");  // Same row
        System.out.println(p1.canKill(new Pawn(1,2,Color.BLACK)) + " = False");  // Same row
        System.out.println(p1.canKill(new Pawn(0,2,Color.BLACK)) + " = False");  // Backward
        System.out.println(p1.canKill(new Pawn(3,2,Color.BLACK)) + " = False");  // More than 2 rows apart
        System.out.println(p1.canKill(new Pawn(2,3,Color.BLACK)) + " = False");  // More than 2 columns apart
        System.out.println(p1.canKill(new Pawn(2,0,Color.WHITE)) + " = False");  // Same color


        Pawn p2 = new Pawn(6,1, Color.BLACK);
        System.out.println("\nBLACK Pawn");
        System.out.println("\nTRUE:");
        System.out.println(p2.canKill(new Pawn(5,0,Color.WHITE)) + " = True");
        System.out.println(p2.canKill(new Pawn(5,2,Color.WHITE)) + " = True");

        System.out.println("\nFALSE:");
        System.out.println(p2.canKill(new Pawn(5,1,Color.WHITE)) + " = False");  // Same column
        System.out.println(p2.canKill(new Pawn(7,1,Color.WHITE)) + " = False");  // Same column
        System.out.println(p2.canKill(new Pawn(6,0,Color.WHITE)) + " = False");  // Same row
        System.out.println(p2.canKill(new Pawn(6,2,Color.WHITE)) + " = False");  // Same row
        System.out.println(p2.canKill(new Pawn(7,2,Color.WHITE)) + " = False");  // Backward
        System.out.println(p2.canKill(new Pawn(4,2,Color.WHITE)) + " = False");  // More than 2 rows apart
        System.out.println(p2.canKill(new Pawn(5,3,Color.WHITE)) + " = False");  // More than 2 columns apart
        System.out.println(p2.canKill(new Pawn(5,0,Color.BLACK)) + " = False");  // Same color
    }
}

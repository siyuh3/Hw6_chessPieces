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
        // Can't move to original spot
        if (this.getRow() == row && this.getCol() == col) {
            return false;
        }
        // A white pawn can only move one unit upward in row
        // Upward means bigger number is this.getRow()
        if (this.getColor() == Color.WHITE) {
            return this.getCol() == col && (this.getRow() - row) == 1;
        } else {
            // A black pawn can only move one unit downward in row
            // Downward means bigger number is row variable
            return this.getCol() == col && (row - this.getRow()) == 1;
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
        // First step: determine whether two pieces are same color.
        // Cannot kill the same color
        if (this.color == piece.getColor()) {
            return false;
        }
        // Second step: determine whether the columns of two pieces differ by 1
        if (Math.abs(this.getCol() - piece.getCol()) == 1) {
            // Third step: if it is a white pawn,
            // determine it moves one unit upward in row
            if ((this.getColor() == Color.WHITE) && ((this.getRow() - row) == 1)) {
                return true;
            }
            // Fourth step: if it is a black pawn,
            // determine it moves one unit downward in row
            else if ((this.getColor() == Color.BLACK) && ((row - this.getRow()) == 1)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Pawn p1 = new Pawn(1,1, Color.BLACK);
        System.out.println("\nBLACK Pawn");
        System.out.println("\nTRUE:");
        System.out.println(p1.canKill(new Pawn(2,0,Color.WHITE)) + " = True");
        System.out.println(p1.canKill(new Pawn(2,2,Color.WHITE)) + " = True");

        System.out.println("\nFALSE:");
        System.out.println(p1.canKill(new Pawn(2,1,Color.WHITE)) + " = False");  // Same column
        System.out.println(p1.canKill(new Pawn(0,1,Color.WHITE)) + " = False");  // Same column
        System.out.println(p1.canKill(new Pawn(1,0,Color.WHITE)) + " = False");  // Same row
        System.out.println(p1.canKill(new Pawn(1,2,Color.WHITE)) + " = False");  // Same row
        System.out.println(p1.canKill(new Pawn(0,2,Color.WHITE)) + " = False");  // Backward
        System.out.println(p1.canKill(new Pawn(3,2,Color.WHITE)) + " = False");  // More than 2 rows apart
        System.out.println(p1.canKill(new Pawn(2,3,Color.WHITE)) + " = False");  // More than 2 columns apart
        System.out.println(p1.canKill(new Pawn(2,0,Color.BLACK)) + " = False");  // Same color


        Pawn p2 = new Pawn(6,1, Color.WHITE);
        System.out.println("\nWHITE Pawn");
        System.out.println("\nTRUE:");
        System.out.println(p2.canKill(new Pawn(5,0,Color.BLACK)) + " = True");
        System.out.println(p2.canKill(new Pawn(5,2,Color.BLACK)) + " = True");

        System.out.println("\nFALSE:");
        System.out.println(p2.canKill(new Pawn(5,1,Color.BLACK)) + " = False");  // Same column
        System.out.println(p2.canKill(new Pawn(7,1,Color.BLACK)) + " = False");  // Same column
        System.out.println(p2.canKill(new Pawn(6,0,Color.BLACK)) + " = False");  // Same row
        System.out.println(p2.canKill(new Pawn(6,2,Color.BLACK)) + " = False");  // Same row
        System.out.println(p2.canKill(new Pawn(7,2,Color.BLACK)) + " = False");  // Backward
        System.out.println(p2.canKill(new Pawn(4,2,Color.BLACK)) + " = False");  // More than 2 rows apart
        System.out.println(p2.canKill(new Pawn(5,3,Color.BLACK)) + " = False");  // More than 2 columns apart
        System.out.println(p2.canKill(new Pawn(5,0,Color.WHITE)) + " = False");  // Same color
    }
}

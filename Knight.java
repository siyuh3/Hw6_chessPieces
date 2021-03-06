/**
 * @program: Hw6_chessPieces
 * @description: This class is Knight class that implements the ChessPiece class
 * @author: Siyu Hou, Kicho Yu
 * @create: 2021-02-26 02:40
 **/
public class Knight implements ChessPiece, BoardSize {
    private int row;
    private int column;
    private Color color;

    /**
     * Constructs a knight piece with a row number, column number, and color.
     * @param row the row number of the knight
     * @param column the column number of the knight
     * @param color the color of the knight which can be either black or white
     */
    public Knight(int row, int column, Color color) {
        setRow(row);
        setColumn(column);
        setColor(color);
    }

    /**
     * Default constructor
     */
    public Knight() {
        setRow(7);
        setColumn(6);
        setColor(Color.WHITE);
    }

    /**
     * Copy constructor
     */
    public Knight(Knight original) {
        setRow(original.getRow());
        setColor(original.getColor());
        setColumn(original.getCol());
    }

    /**
     * getRow method.
     * @return returns the kngiht's current row.
     */
    @Override
    public int getRow() {
        return this.row;
    }

    /**
     * getCol method.
     * @return returns the knight's current column.
     */
    @Override
    public int getCol() {
        return this.column;
    }

    /**
     * getColor method.
     * @return returns the knight's color -- either white or black.
     */
    @Override
    public Color getColor() {
        return this.color;
    }

    /**
     * setRow method for changing the knight's row.
     * @param row updates the knights's row with a new row.
     * @throws IllegalArgumentException an error arises when a new proposed value is outside the chess board
     */
    public void setRow(int row) throws IllegalArgumentException {
        if (row < MIN_ROW || row > MAX_ROW) {
            throw new IllegalArgumentException("The row/column should range from 0 to 7");
        }
        this.row = row;
    }

    /**
     * setColumn method for changing the knight's column.
     * @param column changes the knight's column to a new column.
     * @throws IllegalArgumentException an error arises when a new proposed
     *         value is outside the chess board's boundaries.
     */
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
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Determines if a player's knight can move to the given spot
     *
     * @param row the row of the targeted spot
     * @param col the column of the targeted spot
     * @return true if this knight can move to the given targeted spot and
     * false if not
     */
    @Override
    public boolean canMove(int row, int col) {
        // Validates the targeted spot
        if (row < MIN_ROW || row > MAX_ROW || col < MIN_COL || col > MAX_COL) {
            return false;
        }
        
        // A knight can move only in an L pattern, either 2 units in row and 1 unit in column or 
        // the other way around. Therefore the slope must be either +-2 or +-1/2
        int rise = row - this.getRow();
        int run = col - this.getCol();
        
        // Can't move horizontally or vertically
        // Can't move to original spot
        if (rise * run == 0) {
            return false;
        }
        double slope = Math.abs((double) rise / run);
        
        // We cannot compare double == double, because of decimal precision.
        // Instead we can compare 2 double numbers using Math.abs
        boolean diff1 = Math.abs(slope - 2) < 0.01;
        boolean diff2 = Math.abs(slope - 0.5) < 0.01;
        return diff1 || diff2;
    }

    /**
     * Determines if a player's chess piece can kill an opponents chess piece.
     *
     * @param piece ChessPiece object opponents chess piece.
     * @return true if opponent's piece is a different color and false otherwise.
     */
    @Override
    public boolean canKill(ChessPiece piece) {
        return this.color != piece.getColor() && this.canMove(piece.getRow(), piece.getCol());
    }

    public static void main(String[] args) {
        Knight knight1 = new Knight(4,4,Color.WHITE);

        // valid
        Knight valid1 = new Knight(2,3,Color.BLACK);
        Knight valid2 = new Knight(2,5, Color.BLACK);
        Knight valid3 = new Knight(3,2,Color.BLACK);
        Knight valid4 = new Knight(3,6,Color.BLACK);
        Knight valid5 = new Knight(5,2,Color.BLACK);
        Knight valid6 = new Knight(5,6,Color.BLACK);
        Knight valid7 = new Knight(6,3, Color.BLACK);
        Knight valid8 = new Knight(6,5, Color.BLACK);

        System.out.println(knight1.canKill(valid1));
        System.out.println(knight1.canKill(valid2));
        System.out.println(knight1.canKill(valid3));
        System.out.println(knight1.canKill(valid4));
        System.out.println();
        System.out.println(knight1.canKill(valid5));
        System.out.println(knight1.canKill(valid6));
        System.out.println(knight1.canKill(valid7));
        System.out.println(knight1.canKill(valid8));
        System.out.println();

        // not valid
        Knight fail1 = new Knight(1,1, Color.BLACK);
        Knight fail2 = new Knight(1,0, Color.BLACK);
        System.out.println(knight1.canKill(fail1));
        System.out.println(knight1.canKill(fail2));

    }
}

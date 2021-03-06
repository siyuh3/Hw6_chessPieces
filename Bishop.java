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
        setRow(7);
        setColumn(2);
        setColor(Color.WHITE);
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
        // Can't move to original spot
        if (row == this.getRow() && col == this.getCol()) {
            return false;
        }

        // Slope formula (y2-y1)/(x2-x1);
        // Slope = rise / run;
        // move diagonally means slope = +-1;
        // move horizontally or vertically means slope = 0;

        int rise = col - this.getCol();
        int run = row - this.getRow();
        // Can move horizontally or vertically
        // "Can't move to original spot" was checked before.
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
        // SO JUST INVOKE canMove WILL SATISFY OUR NEEDED
        // DON'T COPY CODE FROM canMove
        return this.color != piece.getColor() && this.canMove(piece.getRow(), piece.getCol());
    }

    /**
     * main method to try some case
     *
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

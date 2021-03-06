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

    public Rook(int row, int column, Color color) {
        setRow(row);
        setColumn(column);
        setColor(color);
    }

    public Rook() {
        setRow(0);
        setColumn(7);
        setColor(Color.WHITE);
    }

    public Rook(Rook original) {
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
        return color;
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
     * Determines if a player's rook can move to the given spot
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
     *
     * @param piece ChessPiece object opponents chess piece.
     * @return true if opponent's piece is a different color and false otherwise.
     */
    @Override
    public boolean canKill(ChessPiece piece) {
        if (this.color != piece.getColor()) {
            double slope = ((piece.getCol() - this.getCol()) / (double) (piece.getRow() - this.getRow()));
            if (Math.abs(slope) == 0 || this.getRow() == piece.getRow()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Rook rook1 = new Rook(4,4,Color.WHITE);

        System.out.println("TRUE");
        System.out.println(rook1.canKill(new Rook(4,5,Color.BLACK)) + " = True"); //R
        System.out.println(rook1.canKill(new Rook(3,4,Color.BLACK)) + " = True"); // down
        System.out.println(rook1.canKill(new Rook(4,3, Color.BLACK)) + " = True"); //L
        System.out.println(rook1.canKill( new Rook(5, 4, Color.BLACK)) + " = True"); // Up


        System.out.println("\nFALSE");
        System.out.println(rook1.canKill(new Rook(5,3,Color.BLACK)) + " = False");

    }
}

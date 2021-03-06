/**
 * @program: Hw6_chessPieces
 * @description:
 * @author: Siyu Hou, Kicho Yu
 * @create: 2021-02-26 02:40
 **/
public class Knight implements ChessPiece, BoardSize {
    private int row;
    private int column;
    private Color color;

    public Knight(int row, int column, Color color) {
        setRow(row);
        setColumn(column);
        setColor(color);
    }

    public Knight() {
        setRow(7);
        setColumn(6);
        setColor(Color.WHITE);
    }

    public Knight(Knight original) {
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
        // Can't move to original spot
        if (row == this.getRow() && col == this.getCol()) {
            return false;
        }
        // A knight can move only in an L pattern, either 2 units in row and 1 unit in column or 
        // the other way around. Therefore, the distance between the targeted spot and the
        // original spot is square root of 5, by the pythagorean theorem
        // double distance = Math.sqrt(Math.pow(this.getRow() - row, 2) + Math.pow(this.getCol() - col, 2));
        // return distance == Math.sqrt(5);
        int rise = row - this.getRow();
        int run = col - this.getCol();
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
        if (this.color != piece.getColor()) {
            double slope = Math.abs((piece.getCol() - this.getCol()) / (double) (piece.getRow() - this.getRow()));
            if (slope == 2 || slope == 0.5) {
                return true;
            }
        }
        return false;
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

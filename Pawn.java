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
        setColumn(0);
        setColor(null);
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
            throw new IllegalArgumentException("The row should bigger than 0 and smaller than 7!");
        }
        this.row = row;
    }

    public void setColumn(int column) throws IllegalArgumentException {
        if (column < MIN_COL || column > MAX_COL) {
            throw new IllegalArgumentException("The column should bigger than 0 and smaller than 7!");
        }
        this.column = column;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean canMove(int row, int col) {
        if (row < MIN_ROW || row > MAX_ROW || col < MIN_COL || col > MAX_COL) {
            return false;
        }
        return this.getCol() == col && (row - this.getRow()) == 1;
    }

    @Override
    public boolean canKill(ChessPiece piece) {
        return false;
    }
}

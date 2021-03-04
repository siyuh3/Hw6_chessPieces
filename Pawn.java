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
            /*
            should the IllegalArgument say "The row should be greater than -1 and smaller than 8?
             */
            throw new IllegalArgumentException("The row should bigger than 0 and smaller than 7!");
        }
        this.row = row;
    }

    public void setColumn(int column) throws IllegalArgumentException {
        if (column < MIN_COL || column > MAX_COL) {
            /*
            should the IllegalArgument say "The column should be greater than -1 and smaller than 8?
             */
            throw new IllegalArgumentException("The column should bigger than 0 and smaller than 7!");
        }
        this.column = column;
    }

    public void setColor(Color color) {
        this.color = color;
    }

   /**
     * Determines if a player's pawn can move to the given spot
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
        // A white pawn can only move one unit upward in row
        if (this.getColor() == Color.WHITE) {
            return this.getCol() == col && (row - this.getRow()) == 1;
        } else {
            // A black pawn can only move one unit downward in row
            return this.getCol() == col && (this.getRow() - row) == 1;
        }
        
    }

    /**
     * Determines if a player's chess piece can kill an opponents chess piece.
     * @param piece ChessPiece object opponents chess piece
     * @return true if opponent's piece is a different color and false if not.
     */
    @Override
    public boolean canKill(ChessPiece piece) {
       if(this.color != piece.getColor() & this.canMove(this.getRow(), this.getCol())
               == piece.canMove(piece.getRow(), piece.getCol())){
           return true;
       }
       return false;
    }
}

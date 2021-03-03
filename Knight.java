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
        setRow(0);
        setColumn(0);
        setColor(null);
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
        double distance = Math.sqrt(Math.pow(this.getRow() - row, 2) + Math.pow(this.getCol() - col, 2));
        return distance == Math.sqrt(5);
    }

    @Override
    public boolean canKill(ChessPiece piece) {
        return false;
    }
}

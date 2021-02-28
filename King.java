/**
 * @program: Hw6_chessPieces
 * @description:
 * @author: Siyu Hou
 * @create: 2021-02-28 05:38
 **/
public class King implements ChessPiece {
    private int row;
    private int column;
    private Color color;

    public King(int row, int column, Color) {
        setRow(row);
        setColumn(column);
        setColor(color);
    }

    public King(Color color) {
        setRow(0);
        setColumn(0);
        setColor(color);
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public int getRow() {
        return 0;
    }

    @Override
    public int getCol() {
        return 0;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public boolean canMove(int row, int col) {
        return false;
    }

    @Override
    public boolean canKill(ChessPiece piece) {
        return false;
    }
}

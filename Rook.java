/**
 * @program: Hw6_chessPieces
 * @description:
 * @author: Siyu Hou, Kicho Yu
 * @create: 2021-02-26 02:41
 **/
public class Rook implements ChessPiece{
    private int row;
    private int column;
    private Color color;

    public Rook(int row, int column, Color color){
        setRow(row);
        setColumn(column);
        setColor(color);
    }

    public Rook(Color color){
        setRow(0);
        setColumn(0);
        setColor(color);
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
    public boolean canMove(int row, int col) {
        if (row < 0 || row > 7 || col < 0 || col > 7) {
            return false;
        }
        double distance = Math.sqrt(Math.pow(this.getRow() - row, 2) + Math.pow(this.getCol() - col, 2));
        return distance == 1;
    }

    @Override
    public boolean canKill(ChessPiece piece) {
        return false;
    }
}

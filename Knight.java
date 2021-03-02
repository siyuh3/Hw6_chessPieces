/**
 * @program: Hw6_chessPieces
 * @description:
 * @author: Siyu Hou, Kicho Yu
 * @create: 2021-02-26 02:40
 **/
public class Knight implements ChessPiece{
    private int row;
    private int column;
    private Color color;

    public Knight(int row, int column, Color color){
        setRow(row);
        setColumn(column);
        setColor(color);
    }

    public Knight(Color color){
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
        return distance == Math.sqrt(5);
    }

    @Override
    public boolean canKill(ChessPiece piece) {
        return false;
    }
}

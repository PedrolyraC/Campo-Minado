package MineSweeperMatch;

public class GameBoard {
    private int rows;
    private int columns;
    // bombas e seu número
    private int[][] Board;

    public GameBoard(int rows, int columns, int[][] board) {
        this.rows = rows;
        this.columns = columns;
        Board = board;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int[][] getBoard() {
        return Board;
    }

    public void setBoard(int[][] board) {
        Board = board;
    }

    public Squares bombGenerator(){
        return null;
    }

    public int newBoard(){
        return 0;
    }

    public int printBoard(){
        return 0;
    }

    public boolean isValidCoord(int x, int y){
        return (x >= 0 && x<this.getRows() && y>=0 && y<=this.getColumns());
    }

}

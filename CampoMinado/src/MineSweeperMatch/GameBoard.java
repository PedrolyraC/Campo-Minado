package MineSweeperMatch;
import Enums.*;
import java.util.Random;

public class GameBoard {
    private int rows;
    private int columns;
    // bombas e seu número
    private Squares[][] board;
    private Level level;

    public GameBoard(Level level) {
        this.level = level;
        switch (this.level ){
            case EASY:
                this.rows = 8;
                this.columns = 10;
                break;
            case MEDIUM:
                this.rows = 14;
                this.columns = 18;
                break;
            case HARD:
                this.rows = 20;
                this.columns = 24;
                break;
        }
        board = new Squares[this.rows][this.columns];
        for (int r=0; r<this.rows; r++)
            for (int c=0; c<this.columns; c++)
                this.board[r][c] = new Squares(SquareSymbol.WHITESPACE, this.bombGenerator());
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

    public Squares[][] getBoard() {
        return this.board;
    }


    public boolean bombGenerator(){
        Random random = new Random();
        int probability = 0;
        switch (this.level){
            case EASY:
                probability = 10;
                break;
            case MEDIUM:
                probability = 18;
                break;
            case HARD:
                probability = 25;
                break;
        }

        return (random.nextInt(100)+1 <= probability);
    }

    public int newBoard(){
        return 0;
    }

    public int printBoard(){
        return 0;
    }

    public boolean validCoordinate(int x, int y){
        return true;
    }

    public String toString() {
        String display = "";
        for (int r = 0; r < this.rows; r++){
            for (int c = 0; c < this.columns; c++) {
                display += this.board[r][c].toString();
            }
            display += "\n";
        }

        return display;
    }
}

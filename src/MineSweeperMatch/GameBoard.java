package MineSweeperMatch;

import Enums.SquareSymbol;

import java.util.Random;

import static Enums.SquareSymbol.randomSquareSymbolGenerator;

public class GameBoard {
    private int rows;
    private int columns;
    // bombas e seu número
    private Squares[][] board;
    private int difficulty;

    public GameBoard(int difficulty) {

        Random random;

        this.difficulty = difficulty;
        switch (this.difficulty){
            case 1:
                this.rows = 8;
                this.columns = 10;
                break;
            case 2:
                this.rows = 14;
                this.columns = 18;
                break;
            case 3:
                this.rows = 20;
                this.columns = 24;
                break;
        }
        board = new Squares[this.rows][this.columns];

        for(int i = 0; i <= this.rows; i++){
            for(int j = 0; j <= this.columns; j++){
                board[i][j] = new Squares(randomSquareSymbolGenerator(),bombGenerator()); //definir o que vai ser cada casa e gerar
            }
        }
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
        return board;
    }

    public void setBoard(Squares[][] board) {
        board = board;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public boolean bombGenerator(){
        Random random = new Random();
        int probability = 0;
        switch (this.difficulty){
            case 1:
                probability = 10;
                break;
            case 2:
                probability = 18;
                break;
            case 3:
                probability = 25;
                break;
        }
        return (random.nextInt(100)+1 <= probability);
    }

    @Override
    public String toString() {
        String display = "";
        for (int i = 0; i < this.rows; i++){
            for (int j = 0; j < this.columns; j++){
                display += this.board[i][j].toString();
            }
            display += "\n";
        }
        return display;
    }
}

package MineSweeperMatch;

import Enums.SquareSymbol;
import Exceptions.EmptySquareChoosenedException;
import Exceptions.TryToChooseFlagSquareException;

import java.util.Random;

public class GameBoard {
    private int rows;
    private int columns;
    private Squares[][] board;
    private boolean[][] choosened;
    private int difficulty;

    public GameBoard(int difficulty) {

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
        this.board = new Squares[this.rows][this.columns];
        this.choosened = new boolean[this.rows][this.columns];

        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                board[i][j] = new Squares(SquareSymbol.WHITESPACE,bombGenerator());
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

    public boolean getChoosened(Coordinates coord) {
        return this.choosened[coord.getX()][coord.getY()];
    }

    public void setChoosened(Coordinates coord,boolean flag) throws EmptySquareChoosenedException, TryToChooseFlagSquareException {

        if (flag) {
            if (!this.board[coord.getX()][coord.getY()].isFlag()
                    || !this.board[coord.getX()][coord.getY()].isEmpty()) {
                this.board[coord.getX()][coord.getY()].setFlag();
            } else if (this.board[coord.getX()][coord.getY()].isEmpty()) {
                this.board[coord.getX()][coord.getY()].setSquare(SquareSymbol.EMPTY);
            }
        } else {
            if (!this.board[coord.getX()][coord.getY()].isFlag()
                    || !this.board[coord.getX()][coord.getY()].isEmpty()) {
                this.choosened[coord.getX()][coord.getY()] = true;
                if (this.board[coord.getX()][coord.getY()].isBomb()) {
                    this.board[coord.getX()][coord.getY()].setSquare(SquareSymbol.BOMB);
                }
                else if (this.board[coord.getX()][coord.getY()].isFlag()) {
                    this.board[coord.getX()][coord.getY()].setSquare(SquareSymbol.FLAG);
                }
                else if (this.board[coord.getX()][coord.getY()].isEmpty()) {
                    this.board[coord.getX()][coord.getY()].setSquare(SquareSymbol.EMPTY);
                }
                else {
                    this.board[coord.getX()][coord.getY()].setSquare(SquareSymbol.EMPTY);
                }
            }
        }
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Squares getSquare(Coordinates coords){
        return this.board[coords.getX()][coords.getY()];
    }

    public boolean isBomb(Coordinates coord){
        return this.board[coord.getX()][coord.getY()].isBomb();
    }

    public boolean isEmpty(Coordinates coord){
        return this.board[coord.getX()][coord.getY()].isEmpty();
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

    public void printAll(){

        for (int i = 0; i < this.rows; i++){
            for (int j = 0; j < this.columns; j++){
                Match.clearScreen();
                if(this.board[i][j].isBomb()){
                    this.board[i][j].setSquare(SquareSymbol.BOMB);
                }
            }
            System.out.println(this);
        }
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

package MineSweeperMatch;

import Enums.SquareSymbol;

import java.util.Random;

public class Squares {

    private SquareSymbol square;
    private boolean bomb;
    private int number;

    public Squares(SquareSymbol square, boolean bomb) {
        this.square = square;
        this.bomb = bomb;
        this.number = -1;
    }

    public SquareSymbol getSquare() {
        return square;
    }

    public void setSquare(SquareSymbol square) {
        this.square = square;
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setFlag(){
        this.square = SquareSymbol.FLAG;
    }

    public void removeFlag(){
        this.square = SquareSymbol.WHITESPACE;
    }

    @Override
    public String toString() {
        String symbol = "";
        switch (this.square){
            case WHITESPACE:
                symbol = "| |";
                break;
            case BOMB:
                symbol = "|\uD83D\uDCA3 |";
                break;
            case NUMBER:
                symbol = "|"+this.number+"|";
                break;
            case EMPTY:
                symbol = "|\u0000\u20DE|";
                break;
        }
        return symbol;
    }
}


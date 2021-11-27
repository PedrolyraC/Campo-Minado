package MineSweeperMatch;

import Enums.SquareSymbol;

public class Squares {

    private SquareSymbol square;
    private boolean bomb;
    private int number;

    public Squares(SquareSymbol square, boolean bomb) {
        this.square = square;
        this.bomb = bomb;
        this.number = -1;
    }

    public void setSquare(SquareSymbol square) {
        this.square = square;
    }

    public SquareSymbol getSquare() {
        return this.square;
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public void setFlag(){
        this.square = SquareSymbol.FLAG;
    }

    public void removeFlag(){
        this.square = SquareSymbol.WHITESPACE;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public String toString() {
        String symbol = "";
        switch (this.square){
            case WHITESPACE:
                symbol = "| |";
                break;
            case BOMB:
                /* UTF-16 Encoding:	0xD83D0xDCA3*/
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


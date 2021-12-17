package MineSweeperMatch;

import Enums.SquareSymbol;

public class Squares {

    private SquareSymbol square;
    private boolean bomb;
    private boolean flag;
    private boolean empty;
    private int number;

    public Squares(SquareSymbol square, boolean bomb) {
        this.square = square;
        this.bomb = bomb;
        this.number = -1;
        this.flag = false;
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

    public boolean isFlag() {
        return flag;
    }

    public void setFlag() {
        this.flag = true;
        this.square = SquareSymbol.FLAG;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        String symbol = "";
        switch (this.square){
            case WHITESPACE:
                symbol = "|-|";
                break;
            case BOMB:
                symbol = "|B|";
                break;
            case NUMBER:
                symbol = "|"+this.number+"|";
                break;
            case EMPTY:
                symbol = "| |";
                break;
            case FLAG:
                symbol = "|F|";
        }
        return symbol;
    }
}


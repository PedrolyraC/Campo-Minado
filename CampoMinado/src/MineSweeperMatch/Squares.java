package MineSweeperMatch;

import Enums.SquareSymbol;

public class Squares {

    private SquareSymbol square;
    private boolean bomb;

    public Squares(SquareSymbol square, boolean bomb) {
        this.square = square;
        this.bomb = bomb;
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

    public SquareSymbol setFlag(){

    }

    public SquareSymbol removeFlag(){

    }

    public
}


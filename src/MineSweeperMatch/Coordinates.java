package MineSweeperMatch;

public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isEqual(Coordinates coord){
        return (this.getX() == coord.getX() && this.getY() == coord.getY());
    }
}

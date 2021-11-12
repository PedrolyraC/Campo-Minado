package MineSweeperMatch;

public class Match {
    private GameBoard board;
    private int playsMade;
    private long score;

    public Match() {
        board = new GameBoard();
        playsMade = 0;
        score = 0;
    }

    public GameBoard getBoard() {
        return board;
    }

    public void setBoard(GameBoard board) {
        this.board = board;
    }

    public int getPlaysMade() {
        return playsMade;
    }

    public void setPlaysMade(int playsMade) {
        this.playsMade = playsMade;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public int matchScore(){

    }

    public boolean[][] gameOver(){

    }

    public Squares choosenSquare(){

    }

    public boolean possibleMoves(){

    }

    public int clearScreen(){

    }
}

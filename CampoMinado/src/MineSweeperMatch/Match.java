package MineSweeperMatch;

public class Match {
    private GameBoard board;
    private int playsMade;
    private long score;
    private long time;
    private String playerName;
    //Número de jogadas

    public Match(String playerName) {
        this.playerName = playerName;
        this.board = new GameBoard();
        this.playsMade = 0;
        this.score = 0;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
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

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
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

    public void gameStatus(){

    }

    public void quitMatch(){

    }
}

package MineSweeperMatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import MineSweeperMatch.Dinamics.Play;

public class Match{
    private GameBoard board;
    private int playsMade;
    private long score;
    private long time;
    private String playerName;
    private ArrayList<Play> plays;

    public Match(String playerName) {
        this.playerName = playerName;
        this.board = null;//new GameBoard();
        this.playsMade = 0;
        this.score = 0;
        this.plays = new ArrayList<Play>();
    }

    public int compareTo(Match match) {
        return (int) (this.time - match.getTime());
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
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

    public boolean setScore(long score) {
        if (score >= 0) {
            this.score = score;
            return true;
        } else
            return false;
    }

    public int matchScore(){
        return 0;
    }

    public boolean gameOver(){
        return true;
    }

    public Squares choosenSquare(){
        return null;
    }

    public boolean possibleMoves(){
        return true;
    }

    public int clearScreen(){
        return 0;
    }

    public void printStatus(){
        System.out.println("Round " + this.getPlaysMade()+1
                + "\nScore " + this.getScore());
    }

    public void printBoard(){
        this.board.printBoard();
    }
}
